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
        this.movieRepository.findAll();
        return null;
    }

    public Movie findById(long id) {
        movieRepository.findById(id).orElseThrow();
        return null;
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
    public boolean deleteMovie(int id) {
        return movieList.removeIf(movie -> movie.getId() == id);
    }

}
