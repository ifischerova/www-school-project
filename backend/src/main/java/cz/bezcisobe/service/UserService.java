package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cz.bezcisobe.dto.response.LoginResponse;
import cz.bezcisobe.model.Role;
import cz.bezcisobe.model.User;
import cz.bezcisobe.repository.UserRepository;
import cz.bezcisobe.security.JwtTokenUtil;
import cz.bezcisobe.exception.RegistrationException;
import cz.bezcisobe.exception.AuthenticationException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public LoginResponse login(String username, String password) {
        try {
            User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AuthenticationException("Nesprávné uživatelské jméno nebo heslo"));
                
            if (!passwordEncoder.matches(password, user.getPassword())) {
                throw new AuthenticationException("Nesprávné uživatelské jméno nebo heslo");
            }

            return new LoginResponse(user.getId(), jwtTokenUtil.generateToken(user));
        } catch (Exception e) {
            if (e instanceof AuthenticationException) {
                throw e;
            }
            throw new AuthenticationException("Došlo k chybě při přihlašování");
        }
    }

    public void register(String username, String email, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new RegistrationException("Uživatelské jméno je již zabrané");
        }

        if (userRepository.existsByEmail(email)) {
            throw new RegistrationException("Email je již registrován");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.addRole(Role.ROLE_USER); // Default role

        userRepository.save(user);
    }

    // Method to promote user to admin
    public void promoteToAdmin(Long userId) {
        User user = getUserById(userId);
        user.addRole(Role.ROLE_ADMIN);
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Uzivatele jsme nemohli najit."));
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);

        if (userDetails.getUsername() != null) {
            user.setUsername(userDetails.getUsername());
        }
        if (userDetails.getEmail() != null) {
            user.setEmail(userDetails.getEmail());
        }
        if (userDetails.getPhone() != null) {
            user.setPhone(userDetails.getPhone());
        }
        if (userDetails.getCity() != null) {
            user.setCity(userDetails.getCity());
        }
        
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}