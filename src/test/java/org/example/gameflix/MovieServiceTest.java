package org.example.gameflix;

import org.example.gameflix.model.Movie;
import org.example.gameflix.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        Assertions.assertNotNull(movies);
    }

    @Test
    void getMovieById_ShouldReturnMovie() {
        Movie movie = movieService.getMovieById(1);
        Assertions.assertNotNull(movie);
    }

    @Test
    void addMovie_ShouldIncreaseListSize() {
        int oldSize = movieService.getAllMovies().size();
        Movie newMovie = new Movie(99, "Test Movie", "Test Desc", 2024);

        movieService.addMovie(newMovie);
        int newSize = movieService.getAllMovies().size();

        Assertions.assertTrue(newSize > oldSize);
    }
}
