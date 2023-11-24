package in.theartisticescape.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.theartisticescape.entity.ArtistEntity;
import in.theartisticescape.model.Art;
import in.theartisticescape.model.Artist;

public interface ArtistRepository extends CrudRepository<ArtistEntity, String> {

	
}
