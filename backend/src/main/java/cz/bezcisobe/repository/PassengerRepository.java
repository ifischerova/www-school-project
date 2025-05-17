package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.Passenger;
import cz.bezcisobe.model.PassengerId;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, PassengerId> {
}