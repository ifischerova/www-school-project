package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.bezcisobe.dto.request.LoginRequest;
import cz.bezcisobe.dto.request.RegisterRequest;
import cz.bezcisobe.dto.response.LoginResponse;
import cz.bezcisobe.service.UserService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  private UserService userService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
      String token = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
      return ResponseEntity.ok(new LoginResponse(token));
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
      userService.register(registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getPassword());
      return ResponseEntity.ok("User registered successfully");
  }
}
