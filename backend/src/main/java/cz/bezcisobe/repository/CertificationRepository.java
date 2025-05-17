package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.bezcisobe.model.Certification;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
}