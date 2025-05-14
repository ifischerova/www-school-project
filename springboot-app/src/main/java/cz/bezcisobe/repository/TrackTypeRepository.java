package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.TrackType;

@Repository
public interface TrackTypeRepository extends JpaRepository<TrackType, Long> {
}