package in.theartisticescape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import in.theartisticescape.entity.ArtEntity;
import in.theartisticescape.exception.ArtistException;
import in.theartisticescape.model.Art;
import in.theartisticescape.repository.ArtRepository;
import in.theartisticescape.repository.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	private ArtRepository artRepository;
	@Autowired
	private ArtistRepository artistRepository;
	@Override
	public String uploadArt(Art art, MultipartFile file){
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
				artEntity.setArt_image(file.getBytes());;
			} catch (Exception e) {
				e.printStackTrace();
			}
			artEntity.setDateTime(art.getDateTime());
			artEntity.setFileName(file.getOriginalFilename());
			artEntity.setFileType(art.getFileType());
			artEntity.setPlace(art.getPlace());
			artRepository.save(artEntity);
			return "Uploaded";
		
	}
	
	public List<Art> getListOfArts(String artistEmailId){
		List<Art> listOfArts = artistRepository.findListOfArtsByEmailId(artistEmailId);
		
		return listOfArts;
	}

}
