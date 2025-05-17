package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.RaceLength;

@Repository
public interface TrackLengthRepository extends JpaRepository<RaceLength, Long> {
}