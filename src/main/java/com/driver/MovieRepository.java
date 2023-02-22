package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository
{
    HashMap<String, Movie> movieMap;
    HashMap<String, Director> directorMap;

    public MovieRepository() {
    }
}
