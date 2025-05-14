package cz.bezcisobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.bezcisobe.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
