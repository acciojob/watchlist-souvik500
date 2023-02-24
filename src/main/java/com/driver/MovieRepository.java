//package com.driver;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//
//@Repository
//public class MovieRepository
//{
//    private HashMap<String, Movie> movieMap;
//    private HashMap<String, Director> directorMap;
//    private HashMap<String, ArrayList<String>> directorMovieMap;
//
//    //Pair is : DirectorName, List of Movie Names
//
//
//    //Initialization is very important :
//
//    public MovieRepository() {
//        this.movieMap = new HashMap<String, Movie>() ;
//        this.directorMap = new HashMap<String, Director>();
//        this.directorMovieMap = new HashMap<String, ArrayList<String>>();
//    }
//
//    /**
//     *
//     * @param movie
//     */
//    public void saveMovies (Movie movie)
//    {
//        movieMap.put(movie.getName(), movie);
//    }
//
//    /**
//     *
//     * @param director
//     */
//    public void saveDirectory (Director director)
//    {
//        directorMap.put(director.getName(), director);
//    }
//
//    /**
//     *
//     * @param movie
//     * @param director
//     */
//    public void saveDirectorMoviePair (String movie, String director)
//    {
//        if (movieMap.containsKey(movie) && directorMap.containsKey(director))
//        {
//            ArrayList<String> moviesCreatedByDirector = new ArrayList<>();
//
//            if (directorMovieMap.containsKey(director)) moviesCreatedByDirector = directorMovieMap.get(director);
//
//            moviesCreatedByDirector.add(movie);
//
//            directorMovieMap.put(director, moviesCreatedByDirector);
//        }
//    }
//
//    public Movie findMovies (String movie) { return movieMap.get(movie); }
//
//    public Director findDirector (String director) { return directorMap.get(director); }
//
//    public ArrayList<String> findMoviesByDirector (String director)
//    {
//        ArrayList<String> movieList = new ArrayList<>();
//
//        if (directorMovieMap.containsKey(director)) movieList = directorMovieMap.get(director);
//
//        return movieList;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public ArrayList<String> findAllMovies() { return new ArrayList<>(movieMap.keySet()); }
//
//    /**
//     *
//     * @param director
//     */
//    public void deleteDirector (String director)
//    {
//        //1. Find the movie names by director from the pair
//        if (directorMovieMap.containsKey(director))
//        {
//            ArrayList<String> movieDeleted = new ArrayList<>(directorMovieMap.get(director));
//
//            //2. Deleting all the movies from movieDb by using movieName
//            for (String deleteMovieList : movieDeleted)
//            {
//                if (movieMap.containsKey(movieDeleted)) movieMap.remove(movieDeleted);
//            }
//
//            // 3. remove Director from Pair
//            directorMovieMap.remove(director);
//        }
//
//        // 4. Remove Director from only Director Database
//        if (directorMap.containsKey(director)) directorMap.remove(director);
//
//    }
//
//    /**
//     * Delete all director with his Movies !!
//     */
//    public void deleteAllDirector()
//    {
//        HashSet<String> movieSet = new HashSet<>();
//
//        // Finding out all the movies by all the directors combined
//        for (String director : directorMovieMap.keySet())
//        {
//            //Iterating in the list of movies by a director.
//            for (String movie : directorMovieMap.get(director)) movieSet.add(movie);
//        }
//
//        //Deleting the movie from the movieDb.
//        for (String movie : movieSet)
//        {
//            if (movieMap.containsKey(movie)) movieMap.remove(movie);
//        }
//    }
//}
package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    //Pair is : DirectorName, List of Movie Names


    //Initialization is very important :

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director){

        //1. Add the movie into Datbase ---> WRONG bcz I dont have te movie object

        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){

            List<String> currentMoviesByDirector = new ArrayList<>();

            if(directorMovieMapping.containsKey(director))
                currentMoviesByDirector = directorMovieMapping.get(director);

            currentMoviesByDirector.add(movie);

            directorMovieMapping.put(director,currentMoviesByDirector);

        }

    }

    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)) moviesList = directorMovieMapping.get(director);
        return moviesList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){

        List<String> movies = new ArrayList<String>();
        if(directorMovieMapping.containsKey(director)){
            //1. Find the movie names by director from the pair
            movies = directorMovieMapping.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for(String movie: movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }

            //3. Deleteing the pair
            directorMovieMapping.remove(director);
        }

        //4. Delete the director from directorDb.
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }

    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        //directorMap = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: directorMovieMapping.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        //clearing the pair.
        //directorMovieMapping = new HashMap<>();
    }
}

//package com.driver;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class MovieRepository {
//
//    Map<String , Movie> db = new HashMap<>();
//    Map<String , Director> db_D = new HashMap<>();
//
//    Map<String , String> pair = new HashMap<>();
//
//
//
//    public String addMovie(Movie movie){
//        String name = movie.getName();
//        db.put(name,movie);
//        return "Movie Added succesfully";
//    }
//
//    public Movie getMovie(String name){
//        return db.get(name);
//    }
//
//    public String addDirector(Director director) {
//        String name = director.getName();
//        db_D.put(name,director);
//        return "Director Added succesfully";
//    }
//
//    public Director getDirector(String name) {
//        return db_D.get(name);
//    }
//
//    public String deleteDirector(String name) {
//        if(!db_D.containsKey(name)){
//            return "Invalid name";
//        }
//        db_D.remove(name);
//        return "Director removed succesfully";
//    }
//
//    public String deleteMovie(String name) {
//        if(!db.containsKey(name)){
//            return "Invalid name";
//        }
//        db.remove(name);
//        return "Movie  removed succesfully";
//    }
//
//
//    public List<String> findMoviesByDirector(String director) {
//        List<String> movies = new ArrayList<>();
//        for(String specific_director : pair.keySet()){
//            if(specific_director.equals(director)){
//                movies.add(pair.get(director));
//            }
//
//        }
//        return movies;
//    }
//
//    public List<String> findAllMovies() {
//        List<String> allMovies = new ArrayList<>();
//        for(String eachMovie : db.keySet()){
//            allMovies.add(eachMovie);
//        }
//        return allMovies;
//    }
//
//    public String pair_name(String movieName, String directorName) {
//        pair.put(directorName ,movieName );
//        return "Pair made";
//    }
//
//
//
//    public void delete_allDirectors() {
//        db_D.clear();
//    }
//}