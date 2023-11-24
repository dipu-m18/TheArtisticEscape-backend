package in.theartisticescape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.theartisticescape.entity.ArtEntity;
import in.theartisticescape.model.Art;


public interface ArtRepository extends CrudRepository<ArtEntity, Integer> {
	
	List<ArtEntity> findByArtistEmailId( String artistEmailId);
}
