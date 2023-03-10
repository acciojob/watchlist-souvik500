package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService
{
    @Autowired
    MovieRepository movieRepository;
    public void addMovie (Movie movie) {movieRepository.saveMovies(movie);}

    public void addDirector (Director director) { movieRepository.saveDirector(director); }

    public void addDirectorCreatMovie (String movie, String director) {
        movieRepository.saveDirectorMoviePair(movie,director);
    }

    public Movie getMovies (String movie) {return movieRepository.findMovies(movie);}

    public Director getDirectors (String director) {return movieRepository.findDirector(director);}

    public List<String> getListOfMoviesFromDirector (String director) {
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> getAllMovies () {return movieRepository.findAllMovies();}

    public void deleteDirectors (String director) {movieRepository.deleteDirector(director);}

    public void deleteAllDirectors() {movieRepository.deleteAllDirector();}
}
//package com.driver;
//
//import java.util.*;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MovieService {
//
//    @Autowired
//    MovieRepository movieRepository;
//
//    public void addMovie(Movie movie){
//        movieRepository.saveMovie(movie);
//    }
//
//    public void addDirector(Director director){
//        movieRepository.saveDirector(director);
//    }
//
//    public void createMovieDirectorPair(String movie, String director){
//        movieRepository.saveMovieDirectorPair(movie, director);
//    }
//
//    public Movie findMovie(String movieName){
//        return movieRepository.findMovie(movieName);
//    }
//
//    public Director findDirector(String directorName){
//        return movieRepository.findDirector(directorName);
//    }
//
//    public List<String> findMoviesFromDirector(String director){
//        return movieRepository.findMoviesFromDirector(director);
//    }
//
//    public List<String> findAllMovies(){
//        return movieRepository.findAllMovies();
//    }
//
//    public void deleteDirector(String director){
//        movieRepository.deleteDirector(director);
//    }
//
//    public void deleteAllDirectors(){
//        movieRepository.deleteAllDirector();
//    }
//}
