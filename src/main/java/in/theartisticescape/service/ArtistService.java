package in.theartisticescape.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.theartisticescape.exception.ArtistException;
import in.theartisticescape.model.Art;
import in.theartisticescape.model.Artist;

public interface ArtistService {
	public String loginAndGetToken(String emailId, String password) throws Exception;
	public void uploadArt(String artistEmailId, MultipartFile file)throws ArtistException;
	public List<Art> getListOfArts(String artistEmailId) throws ArtistException;
	public void addArtist(Artist artist) throws ArtistException;
	public boolean authenticateArtist(String emailId, String password)throws Exception;
	public void updateProfile(Artist artist) throws Exception;
	public void changePassword(String emailId, String newPassword) throws Exception;
}
