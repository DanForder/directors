package com.example.directors;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;
    private String name;
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movie> movies = new ArrayList<>();

    public Director(){

    }

    public Director(String name, List<Movie> movies){
        this.name = name;
        this.movies = movies;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
