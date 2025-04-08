package io.git.industrality.moviebackend.repository;

import io.git.industrality.moviebackend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
