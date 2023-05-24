package pl.pjatk.movieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movieService.Interface.MovieRepository;
import pl.pjatk.movieService.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return this.movieRepository.findAllMovies();

    }
    public Movie setMovieAvailability(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setIsAvailable(true);
            return movieRepository.save(movie);
        }
        return null;
    }
    public Movie findById(long id) {
        return movieRepository.findMovieById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    public Optional<Movie> updateMovie(long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();
            movie.setName(updatedMovie.getName());
            movie.setMovieCategory(updatedMovie.getMovieCategory());
            return Optional.of(movieRepository.save(movie));
        }
    return Optional.empty();

    }
    public boolean deleteMovie(long id) {
        boolean exists = movieRepository.existsById(id);
        if (exists) {
            movieRepository.deleteById(id);
        }
        return exists;
    }
}
