package com.ryle_tech.materialdesign.data;

/**
 * Created by muus on 6/20/2016.
 */
public class Movies {

    String movieName;
    String movieDescription;






public Movies(){
}

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    @Override
    public String toString() {
        return "Movie = "+getMovieName()+" and Desc= "+getMovieDescription();
    }
}
