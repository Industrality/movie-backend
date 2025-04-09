package io.git.industrality.moviebackend.service;

import io.git.industrality.moviebackend.entity.Movie;
import io.git.industrality.moviebackend.repository.MovieRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

  private final MovieRepository movieRepository;

  public Movie getMovie(Long id) {
    return movieRepository.findById(id).get();
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie addMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public void deleteMovie(Long movieId) {
    movieRepository.deleteById(movieId);
  }
}
