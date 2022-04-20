package com.example.directors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorController {
    @Autowired
    DirectorRepository repository;

    @GetMapping("/directors")
    public List<Director> getDirectors(){
        return repository.findAll();
    }

    @PostMapping("/director")
    public String addDirector(@RequestBody Director director){
        for(Movie movie: director.getMovies()){
            movie.setDirector(director);
        }
        repository.save(director);
        return "success";
    }
}
