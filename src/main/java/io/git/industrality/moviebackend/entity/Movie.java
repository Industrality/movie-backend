package io.git.industrality.moviebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movie {

  @Id
  private Long id;

  private String title;

  private String imageUrl;

  private String description;

}
