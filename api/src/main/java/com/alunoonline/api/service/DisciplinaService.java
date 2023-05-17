package com.alunoonline.api.service;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina create(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    public Optional<Disciplina> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Disciplina update(Long id, Disciplina disciplinaAtualizada) {
        Optional<Disciplina> disciplinaOptional = repository.findById(id);
        if (disciplinaOptional.isPresent()) {
            Disciplina disciplina = disciplinaOptional.get();
            disciplina.setNome(disciplinaAtualizada.getNome());
            disciplina.setProfessor(disciplinaAtualizada.getProfessor());
            return repository.save(disciplina);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada");
        }
    }
}