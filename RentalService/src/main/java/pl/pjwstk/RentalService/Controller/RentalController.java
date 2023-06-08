package pl.pjwstk.RentalService.Controller;


import org.springframework.web.bind.annotation.*;
import pl.pjwstk.RentalService.Model.Movie;
import org.springframework.http.ResponseEntity;
import pl.pjwstk.RentalService.Service.RentalService;

@RestController
@RequestMapping("/rentalService")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/movies/{id}/return")
    public ResponseEntity<Void> returnMovie(@PathVariable Long id) {
        return rentalService.returnMovie(id);
    }

    @PutMapping("/movies/{id}/rent")
    public ResponseEntity<Void> rentMovie(@PathVariable Long id) {
        return rentalService.rentMovie(id);
    }
}
