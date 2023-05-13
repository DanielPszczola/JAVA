package pl.pjatk.movieService.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.movieService.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
