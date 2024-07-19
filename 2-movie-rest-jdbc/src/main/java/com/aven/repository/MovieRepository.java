package com.aven.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aven.entity.Movie;
import com.mysql.cj.protocol.Resultset;

@Component
public class MovieRepository {
//	List<Movie> movies = new ArrayList<>();
//	{
//		// instance block
//		Movie m1 = new Movie(101, "LORD", "Action", "English");
//		Movie m2 = new Movie(102, "Avengers", "Action", "English");
//		Movie m3 = new Movie(103, "Matrix", "Sci-fi", "English");
//		Movie m4 = new Movie(104, "Shawshank Redemption", "Thriller", "English");
//		Movie m5 = new Movie(105, "Godfather", "Action", "English");
//
//		movies.add(m1);
//		movies.add(m2);
//		movies.add(m3);
//		movies.add(m4);
//		movies.add(m5);
//	}
	@Autowired
	private DBconnection dbconnection;
	

	public List<Movie> getAllMovies()
	{
		return null;
	}
	
	public Movie searchMovieById(int movieid) {
		Movie m = new Movie();
		Connection con = dbconnection.getConnection();
		String sql = "select * from movie where movieId=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, movieid);
			ResultSet rs= pstmt.executeQuery(); //for select query
			if(rs.next()) {
			
				int mid =rs.getInt("movieid");
				String mName = rs.getString("movieName");
				String gen = rs.getString("genre");
				String lang = rs.getString("language");
				m.setMovieId(mid);
				m.setMovieName(mName);
				m.setGenre(gen);
				m.setLanguage(lang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	
	public Movie addMovie(Movie m) {
		Connection con = dbconnection.getConnection();	
		String sql = "insert into movie values(?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getMovieId());
			pstmt.setString(2, m.getMovieName());
			pstmt.setString(3, m.getGenre());
			pstmt.setString(4, m.getLanguage());
			pstmt.executeLargeUpdate(); //fires the query in the db
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
}
