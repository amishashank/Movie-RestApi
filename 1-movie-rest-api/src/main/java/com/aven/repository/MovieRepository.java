package com.aven.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aven.entity.Movie;

@Component
public class MovieRepository {
	List<Movie> movies = new ArrayList<>();
	{
		// instance block
		Movie m1 = new Movie(101, "LORD", "Action", "English");
		Movie m2 = new Movie(102, "Avengers", "Action", "English");
		Movie m3 = new Movie(103, "Matrix", "Sci-fi", "English");
		Movie m4 = new Movie(104, "Shawshank Redemption", "Thriller", "English");
		Movie m5 = new Movie(105, "Godfather", "Action", "English");

		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		movies.add(m4);
		movies.add(m5);
	}

	public List<Movie> getAllMovies()
	{
		return movies;
	}
}
