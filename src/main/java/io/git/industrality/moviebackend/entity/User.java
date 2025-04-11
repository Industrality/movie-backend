package io.git.industrality.moviebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class User {

  @Id
  private Long id;

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private boolean enabled;
  private boolean tokenExpired;

  @ManyToMany
  @JoinTable(
      name = "users_roles",
      joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"))
  private Set<Role> roles;
}
