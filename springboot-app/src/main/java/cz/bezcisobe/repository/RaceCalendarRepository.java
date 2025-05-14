package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.RaceCalendar;

@Repository
public interface RaceCalendarRepository extends JpaRepository<RaceCalendar, Long> {
}