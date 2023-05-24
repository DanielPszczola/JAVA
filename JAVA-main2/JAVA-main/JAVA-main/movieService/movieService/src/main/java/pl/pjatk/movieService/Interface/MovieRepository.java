package pl.pjatk.movieService.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pjatk.movieService.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovies();

    @Query(nativeQuery = true, name = "Movie.findById")
    Optional<Movie> findMovieById(@Param("id") Long id);



}
