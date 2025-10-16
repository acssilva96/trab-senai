package com.example.areadelazer.controller;


import com.example.areadelazer.model.Filmes;
import com.example.areadelazer.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmesController {


    private FilmesService filmesService;

    @Autowired
    public FilmesController(FilmesService filmesService) {
        this.filmesService = filmesService;
    }

    @GetMapping
    public List<Filmes> listarTodos() {
        return filmesService.listarTodos();
    }


}
