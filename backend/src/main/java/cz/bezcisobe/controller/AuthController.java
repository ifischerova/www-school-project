package cz.bezcisobe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.bezcisobe.dto.request.LoginRequest;
import cz.bezcisobe.dto.request.RegisterRequest;
import cz.bezcisobe.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication & Authorization", description = "Authentication and Authorization Management APIs")
public class AuthController {
  @Autowired
  private UserService userService;

  @Operation(
      summary = "Logging the registered user.",
      description = "Authorizes the registered user."
  )
  @ApiResponse(responseCode = "200", description = "Registered user is logged.")
  @ApiResponse(responseCode = "400", description = "Invalid request.")
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
      return ResponseEntity.ok(userService.login(loginRequest.getUsername(), loginRequest.getPassword()));
  }

  @Operation(
    summary = "Registering new user.",
    description = "Registers new user."
  )
  @ApiResponse(responseCode = "200", description = "The new user is succesfully registered.")
  @ApiResponse(responseCode = "400", description = "Invalid request.")
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
      userService.register(registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getPassword());
      // TODO: Create empty DTO instead of sending empty json a string
      return ResponseEntity.ok("{}");
  }
}
