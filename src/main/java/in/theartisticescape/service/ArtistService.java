package in.theartisticescape.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import in.theartisticescape.exception.ArtistException;
import in.theartisticescape.model.Art;

public interface ArtistService {
	public String uploadArt(Art art, MultipartFile file);
	public List<Art> getListOfArts(String artistEmailId);
}
