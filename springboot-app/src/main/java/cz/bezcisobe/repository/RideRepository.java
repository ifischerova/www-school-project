package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
}