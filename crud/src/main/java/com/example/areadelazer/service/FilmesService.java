package com.example.areadelazer.service;


import com.example.areadelazer.model.Filmes;
import com.example.areadelazer.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;


    public Filmes salvar(Filmes filmes) {
        return filmesRepository.save(filmes);
    }

    public List<Filmes> listarTodos() {
        return filmesRepository.findAll();
    }

    public Filmes atualizarProduto(Integer id, Filmes filmesDetalhes) {
        return filmesRepository.findById(id)
                .map(filmeExistente -> {
                    filmeExistente.setTitulo(filmesDetalhes.getTitulo());
                    filmeExistente.setGenero(filmesDetalhes.getGenero());
                    filmeExistente.setDuracao(filmeExistente.getDuracao());
                    return filmesRepository.save(filmeExistente);
                }).orElseThrow(() -> new RuntimeException("Filme não encontrado com id: " + id));
    }

    public void deletarFilme(Integer id) {
        filmesRepository.deleteById(id);
    }

}
