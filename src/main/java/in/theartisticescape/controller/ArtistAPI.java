package in.theartisticescape.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import in.theartisticescape.exception.ArtistException;
import in.theartisticescape.model.Art;
import in.theartisticescape.model.Artist;
import in.theartisticescape.service.ArtistService;

@RestController
public class ArtistAPI {
	
	
	@Autowired
	private ArtistService artistService;
	@Autowired
	private Environment environment;
	
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
	
@PostMapping("/artist/login")
public ResponseEntity<?> login(@RequestBody Artist artist){

	String emailId=artist.getEmailId();
	String password=artist.getPassword();
	if(emailId.equals(null) || password.equals(null)) {
		return ResponseEntity.badRequest().body(environment.getProperty("ArtistAPI.Invalid_Request"));
	}
	try {
	String token = artistService.loginAndGetToken(emailId, password);
	return ResponseEntity.ok(environment.getProperty("ArtistAPI.loginSuccessful"));
	}
	catch(Exception e) {
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,environment.getProperty("ArtistAPI.INVALID_CREDENTIALS"));
	}
}

@PostMapping(value="/artist/{artistEmailId}")
public ResponseEntity<?> uploadArt(@PathVariable String artistEmailId, @RequestBody MultipartFile file)throws ArtistException {
	try {
		artistService.uploadArt(artistEmailId, file);
		return ResponseEntity.accepted().body(environment.getProperty("successUploadMessage"));
	}
	catch(ArtistException e) {
		throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, environment.getProperty("failedUploadMessage"));
	}

}
@GetMapping(value="/artist/{artistEmailId}")
public ResponseEntity<List<Art>> getArts(@PathVariable String artistEmailId) throws ArtistException{
	
	List<Art> listOfArts=null;
	try {
		listOfArts=artistService.getListOfArts(artistEmailId);
		return ResponseEntity.ok().body(listOfArts);
	}
	catch(ArtistException a) {
		 throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(artistEmailId));
	 }
}


}