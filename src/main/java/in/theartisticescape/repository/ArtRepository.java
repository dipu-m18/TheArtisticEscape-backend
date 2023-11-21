package in.theartisticescape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.theartisticescape.entity.ArtEntity;


public interface ArtRepository extends CrudRepository<ArtEntity, Integer> {

}
