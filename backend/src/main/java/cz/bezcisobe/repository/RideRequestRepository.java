package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bezcisobe.model.RideRequest;

import java.util.List;

public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
    List<RideRequest> findByUserID(Long userId);
}