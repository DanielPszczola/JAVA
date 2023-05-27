package pl.pjwstk.RentalService.Controller;


import pl.pjwstk.RentalService.Model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjwstk.RentalService.Service.RentalService;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        return ResponseEntity.ok(rentalService.Getmoviebyid(id));
    }
}
