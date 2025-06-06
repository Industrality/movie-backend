package io.git.industrality.moviebackend.controller;

import io.git.industrality.moviebackend.entity.Movie;
import io.git.industrality.moviebackend.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin/movie")
@RequiredArgsConstructor
public class AdminMovieController {

  private final MovieService movieService;

  @PostMapping
  public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
  }

  @DeleteMapping(value = "/movie/{movieId}")
  public void deleteMovie(@PathVariable Long movieId) {
    movieService.deleteMovie(movieId);
  }

  @GetMapping(value = "/movie/{movieId}")
  public Movie getMovie(@PathVariable Long movieId) {
    return movieService.getMovie(movieId);
  }
}
