package io.git.industrality.moviebackend.controller;

import io.git.industrality.moviebackend.dao.CreateUserRequest;
import io.git.industrality.moviebackend.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

  private final KeycloakService keycloakService;

  @PostMapping("/create")
  public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
    keycloakService.createUser(request);
    return ResponseEntity.ok("User created");
  }

}
