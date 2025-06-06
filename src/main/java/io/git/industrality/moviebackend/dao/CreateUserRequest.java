package io.git.industrality.moviebackend.dao;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class CreateUserRequest {
  private String username;
  private String email;
  private String firstName;
  private String lastName;
  private String password;
}
