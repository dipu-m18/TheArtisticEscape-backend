package in.theartisticescape.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.theartisticescape.exception.CustomerException;
import in.theartisticescape.model.Art;
import in.theartisticescape.model.Artist;
import in.theartisticescape.service.ArtistService;

@RestController
@RequestMapping("/TheArtisticEscape")
public class ArtistAPI {
	
	
	@Autowired
	private ArtistService artistService;

	
//	
//@GetMapping(value="/artists/{artistId}")
//public ResponseEntity<List<Artist>> getArtist(@PathVariable Integer artistId) throws ArtistException{
//	
//}
//
//@PostMapping(value="/artist")
//public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) throws ArtistException{
//	
//}
//
//@PutMapping(value="/artist/{artistId}")
//public ResponseEntity<String> updateArtist(@PathVariable Integer artistId, @RequestBody Artist artist) throws ArtistException{
//	
//}
//
//@DeleteMapping(value="/artist/{artistId}")
//public ResponseEntity<String> deleteArtist(@PathVariable Integer artistId) throws ArtistException{
//	
//}

@PostMapping(value="/artist")
public ResponseEntity<String> uploadArt(@RequestBody Art art, @RequestBody MultipartFile file){
	String s=artistService.uploadArt(art, file);
	if(s.equals("Uploaded")) {
		return new ResponseEntity<>("s",HttpStatus.ACCEPTED);
	}
	return new ResponseEntity<>("Image is not uploaded", HttpStatus.BAD_REQUEST);
	}


@GetMapping(value="/artist/{artistEmailId}")
public ResponseEntity<String> getArts(@PathVariable String artistEmailId){
	List<Art> listOfArts=artistService.getListOfArts(artistEmailId);
	if(listOfArts.size()>0) {
		return new ResponseEntity<>("s",HttpStatus.ACCEPTED);
	}
	return new ResponseEntity<>("Image is not uploaded", HttpStatus.BAD_REQUEST);
	}
}