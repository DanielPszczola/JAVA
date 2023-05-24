package pl.pjatk.movieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.movieService.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    List<Movie> movieList = new ArrayList<>();


    public List<Movie> getAllMovies() {
        return movieList;
    }

    public Movie findById(int id) {
        for (Movie movie : movieList) {
            if (movie.getId() == id) {
                return movieList.get(movieList.indexOf(movie));
            }
        }
        throw new RuntimeException("nie znaleziono filmu o takim id");
    }
    public Movie addMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }
    public Movie updateMovie(int id, Movie updatedMovie) {
        Movie existingMovie = findById(id);
        if (existingMovie == null) {
            return null;
        }
        existingMovie.setName(updatedMovie.getName());
        existingMovie.setMovieCategory(updatedMovie.getMovieCategory());
        return existingMovie;
    }
    public boolean deleteMovie(int id) {
        return movieList.removeIf(movie -> movie.getId() == id);
    }

}
