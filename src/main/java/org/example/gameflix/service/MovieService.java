package org.example.gameflix.service;

import org.example.gameflix.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie(1, "Inception", "Dream invasion story", 2010));
        movies.add(new Movie(2, "Interstellar", "Space and time travel", 2014));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieById(int id) {
        return movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}