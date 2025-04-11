package io.git.industrality.moviebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {

  @Id
  private Long id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "roles_privileges",
      joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "id"))
  private Set<Privilege> privileges;
}
