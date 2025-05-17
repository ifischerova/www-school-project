package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bezcisobe.model.Race;


public interface RaceRepository extends JpaRepository<Race, Long> {}