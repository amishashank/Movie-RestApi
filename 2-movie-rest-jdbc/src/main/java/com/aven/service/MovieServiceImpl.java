package com.aven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aven.entity.Movie;
import com.aven.exceptions.ApplicationException;
import com.aven.repository.MovieRepository;

@Component
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRep;

	@Override
	public List<Movie> allMovies() {

		return movieRep.getAllMovies();
	}

	@Override
	public Movie searchById(int movieId) {
		Movie m = movieRep.searchMovieById(movieId);
		if (m == null || m.getMovieId()==0) 
			throw new ApplicationException("Movie Id "+movieId+ " not Found!!");
		return m;
	}

	@Override
	public Movie movieUpdate(Movie m, int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(int movieId) {
		List<Movie> movies = movieRep.getAllMovies();
		movies.removeIf(p -> p.getMovieId() == movieId);

	}

	@Override
	public Movie addNewMovie(Movie m) {
		return movieRep.addMovie(m);
	}

}
