package pl.pjatk.movieService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.movieService.model.Movie;
import pl.pjatk.movieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieService")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movieList() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<Movie> movieById(@PathVariable("id") int id) {
        Movie exceptionText = movieService.findById(id);
        return ResponseEntity.ok(exceptionText);
    }
    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movie.getId() != 0) {
            return ResponseEntity.badRequest().build();
        }
        Movie addedMovie = movieService.addMovie(movie);
        if (addedMovie == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(addedMovie);
    }
    @PutMapping("/movies/{id}")
    public ResponseEntity<Optional<Movie>> updateMovie(@PathVariable("id") int id, @RequestBody Movie movie) {
        Optional<Movie> updatedMovie = movieService.updateMovie(id, movie);
        if (updatedMovie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedMovie);
    }
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
        boolean isDeleted = movieService.deleteMovie(id);
        if (isDeleted) {
            return ResponseEntity.ok().build(); // 200 OK
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
