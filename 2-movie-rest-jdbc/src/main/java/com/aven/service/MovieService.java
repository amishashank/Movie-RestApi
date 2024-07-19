package com.aven.service;

import java.util.List;

import com.aven.entity.Movie;

public interface MovieService {
List<Movie> allMovies();
Movie searchById(int movieId);
Movie movieUpdate(Movie m,int movieId);
void deleteMovie(int movieId);
Movie addNewMovie(Movie m);
}
