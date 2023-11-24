package in.theartisticescape.service;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import in.theartisticescape.entity.ArtEntity;
import in.theartisticescape.entity.ArtistEntity;
import in.theartisticescape.exception.ArtistException;
import in.theartisticescape.model.Art;
import in.theartisticescape.model.Artist;
import in.theartisticescape.repository.ArtRepository;
import in.theartisticescape.repository.ArtistRepository;
import in.theartisticescape.utility.HashingUtility;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtRepository artRepository;
	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Override
	public void uploadArt(String artistEmailId, MultipartFile file)throws ArtistException{
		// TODO Auto-generated method stub
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		try {	
			if(fileName.contains("..")) {
				throw new ArtistException("Filename contains invalid path sequence "+fileName);
			}
		}
		catch(ArtistException e)
		{
			e.printStackTrace();
		}
			ArtEntity artEntity = new ArtEntity();
			try {
				artEntity.setArt_image(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			//artEntity.setDateTime(art.getDateTime());
			artEntity.setEmail_id(artistEmailId);
			artEntity.setFileName(file.getOriginalFilename());
			artEntity.setFileType(file.getContentType());
			//artEntity.setPlace(art.getPlace());
			artRepository.save(artEntity);
		
	}
	
	public List<Art> getListOfArts(String artistEmailId)throws ArtistException{
		
			List<ArtEntity> listOfArtEntity = new ArrayList<ArtEntity>();
			listOfArtEntity=artRepository.findByArtistEmailId(artistEmailId);
			
			List<Art> listOfArt= new ArrayList<Art>();
			if(listOfArtEntity.size()>0) {
				for(ArtEntity ae:listOfArtEntity) {
					Art a = new Art();
					a.setData(ae.getArt_image());
					a.setDateTime(ae.getDateTime());
					a.setFileName(ae.getFileName());
					a.setFileType(ae.getFileType());
					a.setArtistEmailId(ae.getEmail_id());
					a.setPlace(ae.getPlace());
					listOfArt.add(a);
				}
			}
		return listOfArt;
	}

	@Override
	public void addArtist(Artist artist) throws ArtistException {
		// TODO Auto-generated method stub
		ArtistEntity ae = artistRepository.findById(artist.getEmailId()).get();
		if(ae!=null) {
			throw new ArtistException("ArtistService.User_already_exists");
		}
		ae.setEmailId(artist.getEmailId());
		ae.setName(artist.getName());
		try {
			ae.setPassword(HashingUtility.getHashValue(artist.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		artistRepository.save(ae);
	}

	public boolean authenticateArtist(String emailId, String password)throws Exception{
		Optional<ArtistEntity> optional=artistRepository.findById(emailId);
		ArtistEntity ae= optional.get();
		String hasedPassword = HashingUtility.getHashValue(password);
		if(ae!=null && hasedPassword.equals(ae.getPassword())) {
			return true;
		}else {
			throw new Exception("ArtistService.INVALID_CREDENTIALS");
		}		
	}
	
	public void updateProfile(Artist artist) throws Exception{
		Optional<ArtistEntity> optional=artistRepository.findById(artist.getEmailId());
		ArtistEntity ae= optional.get();
		ae.setName(artist.getName());
		artistRepository.save(ae);
	}
	
	public void changePassword(String emailId, String newPassword) throws Exception {
		Optional<ArtistEntity> optional=artistRepository.findById(emailId);
		ArtistEntity ae= optional.get();
		String newHashedPassword=HashingUtility.getHashValue(newPassword);
		ae.setPassword(newHashedPassword);
		artistRepository.save(ae);
	}
	
	public String loginAndGetToken(String emailId, String password) throws Exception{
		if(authenticateArtist(emailId, password)) {
			String cachedToken = getCachedToken(emailId);
			if(cachedToken!=null) {
				return cachedToken;
			}
			
			String token=generateRandomToken();
			cacheToken(emailId, token);
			return token;
		}
		return null;
	}
	
	private String getCachedToken(String emailId) {
		return redisTemplate.opsForValue().get("token:"+emailId);
	}
	
	private String generateRandomToken() {
		return UUID.randomUUID().toString();
	}
	
	private void cacheToken(String emailId, String token) {
		 redisTemplate.opsForValue().set("token:"+emailId, token, Duration.ofMinutes(60));
	}
	
}
