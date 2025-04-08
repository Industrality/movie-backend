package io.git.industrality.moviebackend.controller;

import io.git.industrality.moviebackend.entity.Movie;
import io.git.industrality.moviebackend.service.MovieService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movie")
@RequiredArgsConstructor
public class MovieController {
  private final MovieService movieService;

  @GetMapping(value = "/{movieId}")
  public Movie getMovie(@PathVariable Long movieId) {
    return movieService.getMovie(movieId);
  }

  @GetMapping
  public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
  }
}
