package pl.pjwstk.RentalService.Service;

import pl.pjwstk.RentalService.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public Movie Getmoviebyid(long id){
        return  restTemplate.getForObject("http://localhost:8080/movieService/movies/" ,Movie.class);
    }
}
