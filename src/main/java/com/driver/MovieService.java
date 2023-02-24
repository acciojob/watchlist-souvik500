//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MovieService
//{
//    @Autowired
//    MovieRepository movieRepository;
//    public void addMovie (Movie movie) {movieRepository.saveMovies(movie);}
//
//    public void addDirector (Director director) { movieRepository.saveDirectory(director); }
//
//    public void addDirectorCreatMovie (String movie, String director) {
//        movieRepository.saveDirectorMoviePair(movie,director);
//    }
//
//    public Movie getMovies (String movie) {return movieRepository.findMovies(movie);}
//
//    public Director getDirectors (String director) {return movieRepository.findDirector(director);}
//
//    public List<String> getListOfMoviesFromDirector (String director) {
//        return movieRepository.findMoviesByDirector(director);
//    }
//
//    public List<String> getAllMovies () {return movieRepository.findAllMovies();}
//
//    public void deleteDirectors (String director) {movieRepository.deleteDirector(director);}
//
//    public void deleteAllDirectors() {movieRepository.deleteAllDirector();}
//}
package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    public Movie findMovie(String movieName){
        return movieRepository.findMovie(movieName);
    }

    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }

    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }
}

//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MovieService {
//    @Autowired
//    MovieRepository movieRepository;
//    public String addMovie(Movie movie) {
//        return movieRepository.addMovie(movie);
//    }
//    public String addDirector(Director director) {
//        return movieRepository.addDirector(director);
//    }
//    public Movie getMovie(String name) {
//        return movieRepository.getMovie(name);
//    }
//    public Director getDirector(String name) {
//        return movieRepository.getDirector(name);
//    }
//    public String delete_director(String name) {
//        return movieRepository.deleteDirector(name);
//    }
//    public List<String> findMoviesByDirector(String director) {
//        return movieRepository.findMoviesByDirector(director);
//    }
//    public List<String> findAllMovies() {
//        return movieRepository.findAllMovies();
//    }
//    public String pair(String movieName, String directorName) {
//        return movieRepository.pair_name(movieName , directorName);
//    }
//    public void deleteDirectors() {
//        movieRepository.delete_allDirectors();
//    }
//}