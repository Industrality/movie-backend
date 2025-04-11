package io.git.industrality.moviebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Privilege {

  @Id
  private Long id;

  private String name;
}
