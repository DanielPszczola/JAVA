package pl.pjatk.movieService.model;

public class Movie {

    int id;
    String name;
    MovieCategory movieCategory;


    public Movie(int id, String name, MovieCategory movieCategory) {
        this.id = id;
        this.name = name;
        this.movieCategory = movieCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }
}
