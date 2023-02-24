//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class MovieController
//{
//    @Autowired
//    MovieService movieService;
//
//    @PostMapping("/movies/add-movie")
//    public ResponseEntity<String> addMovie (@RequestBody Movie movies)
//    {
//        movieService.addMovie(movies);
//        return new ResponseEntity<>("New Movie Added Successfully", HttpStatus.CREATED);
//    }
//
//    @PostMapping("/movies/add-director")
//    public ResponseEntity<String> addDirector (@RequestBody Director director)
//    {
//        movieService.addDirector(director);
//
//        return new ResponseEntity<>("NEW DIRECTOR ADDED SUCCESSFULLY", HttpStatus.CREATED);
//    }
//
//    @PutMapping("/movies/add-movie-director-pair")
//    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("q") String movies, @RequestParam("q1") String director)
//    {
//        movieService.addDirectorCreatMovie(movies,director);
//
//        return new ResponseEntity<>("Movie Director Pair Successfully Created", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/movies/get-movie-by-name/{name}")
//    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie)
//    {
//        Movie movieList = movieService.getMovies(movie);
//
//        return new ResponseEntity<>(movieList, HttpStatus.OK);
//    }
//
//    @GetMapping("/movies/get-director-by-name/{name}")
//    public ResponseEntity<Director> getDirectorByName (@PathVariable String director)
//    {
//        Director directorList = movieService.getDirectors(director);
//
//        return new ResponseEntity<>(directorList, HttpStatus.OK);
//    }
//
//    @GetMapping("/movies/get-movies-by-director-name/{director}")
//    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
//    {
//        List<String> movieList_director = movieService.getListOfMoviesFromDirector(director);
//
//        return new ResponseEntity<>(movieList_director, HttpStatus.OK);
//    }
//
//
//    @GetMapping("/movies/get-all-movies")
//    public ResponseEntity<List<String>> findAllMovies()
//    {
//        List<String> movies = movieService.getAllMovies();
//        return new ResponseEntity<>(movies, HttpStatus.OK);
//    }
//
//
//    @DeleteMapping("/movies/delete-director-by-name")
//    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director)
//    {
//        movieService.deleteDirectors(director);
//
//        return new ResponseEntity<>(director + "deleted Successfully", HttpStatus.OK);
//    }
//
//    @DeleteMapping("/movies/delete-all-directors")
//    public ResponseEntity<String> deleteAllDirectors()
//    {
//        movieService.deleteAllDirectors();
//
//        return new ResponseEntity<>("All Directors Deleted Successfully", HttpStatus.OK);
//    }
//}
package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.createMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        Movie movie = movieService.findMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director + " removed successfully", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }
}



//package com.driver;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class MovieController  {
//    @Autowired
//    MovieService movieServices;
//
//
//    @PostMapping("/add-movie")
//    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
//
//        movieServices.addMovie(movie);
//        return new ResponseEntity<>("success", HttpStatus.CREATED);
//    }
//
//    @PostMapping("/add-director")
//    public ResponseEntity<String> addDirector(@RequestBody() Director director){
//
//        movieServices.addDirector(director);
//        return new ResponseEntity<>("success", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/movies/get-movie-by-name/{name}")
//    public ResponseEntity  getMovieByName(@RequestParam("name") String name){
//        Movie movie= movieServices.getMovie(name);
//        return new ResponseEntity<>(movie, HttpStatus.FOUND);
//    }
//
//    @GetMapping("/movies/get_director_by_name/{name}")
//    public ResponseEntity  getDirectorByName(@RequestParam("name") String name){
//        Director director= movieServices.getDirector(name);
//        return new ResponseEntity<>(director, HttpStatus.FOUND);
//    }
//
//    @DeleteMapping("/movies/delete-director-by-name/{name}")
//    public ResponseEntity deleteDirectorByName(@PathVariable("name") String name){
//        String responce = movieServices.delete_director(name);
//        if(responce == "Invalid name"){
//            return new ResponseEntity(responce , HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(responce , HttpStatus.FOUND);
//    }
//
//    @DeleteMapping("/movies/delete-all-directors")
//    public ResponseEntity deleteAllDirectors(){
//        movieServices.deleteDirectors();
//        return new ResponseEntity<>("success" , HttpStatus.FOUND);
//    }
//
//
//    @GetMapping("/get_movies_by_director_name/{director}")
//    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
//        List<String> movies = movieServices.findMoviesByDirector(director);
//
//        return new ResponseEntity<>(movies , HttpStatus.OK);
//    }
//
//    @GetMapping("/get_all_movies")
//    public ResponseEntity<List<String>> findAllMovies(){
//        List<String> movies = movieServices.findAllMovies();
//        return new ResponseEntity<>(movies , HttpStatus.OK);
//    }
//
//
//    //3
//    @PutMapping("/movies/add-movie-director-pair")
//    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("a") String movieName ,@RequestParam("b") String directorName){
//        movieServices.pair(movieName,directorName);
//        return new ResponseEntity<>("success" , HttpStatus.OK);
//
//    }
//
//
//
//}
