package com.aven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aven.entity.Movie;
import com.aven.service.MovieService;

@RestController
@RequestMapping("api/movies")
public class MovieApi {
	@Autowired
	private MovieService moviService;

	// @GetMapping(produces = "text/html")
	public String test() {
		return "<font size = 50 color = red>Shashank</font>";
	}

	@GetMapping("/sample")
	public Movie sampleData() {
		return new Movie(101, "Avengers", "Action", "English");
	}

	@GetMapping
	public ResponseEntity<List<Movie>> allMovies() // http://localhost:8081/api/movies
	{
		List<Movie> movies = moviService.allMovies();
		if (movies.isEmpty()) {
			//System.out.println("movie list is empty...!!!");
			return new ResponseEntity<List<Movie>>(movies, HttpStatus.NO_CONTENT);
		}
		//System.out.println("movie list is not empty...!!!");
		return new ResponseEntity<List<Movie>>(movies, HttpStatusCode.valueOf(200));
	}

	@GetMapping("/{movieId}")
	// @pathvariable("mid")
	public Movie searchById(@PathVariable int movieId) {
		return moviService.searchById(movieId);
	}
	
	@GetMapping("/search/genre")
	public List<Movie> searchByGenre(@RequestParam("genre") String genre){
		List<Movie> movies = moviService.allMovies();
		List<Movie> filteredMovies =
				movies.stream().filter(p -> p.getGenre().equals(genre)).toList();
		return filteredMovies;
	}

	@PostMapping(consumes = { "application/xml", "application/json" },produces = "application/json")
	public Movie addNewMovie(@RequestBody Movie m) {
		return moviService.addNewMovie(m);
	}
	@DeleteMapping("/{movieId}")
	// @pathvariable("mid")
	public ResponseEntity<Void> removeMovie(@PathVariable int movieId) {
		moviService.deleteMovie(movieId);
		return new ResponseEntity(null, HttpStatusCode.valueOf(202));
	}

}
