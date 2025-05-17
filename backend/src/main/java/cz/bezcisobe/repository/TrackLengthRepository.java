package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.TrackLength;

@Repository
public interface TrackLengthRepository extends JpaRepository<TrackLength, Long> {
}