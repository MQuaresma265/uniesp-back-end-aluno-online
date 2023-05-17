package com.alunoonline.api.service;

import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create(Professor professor) { return repository.save(professor);
    }

    public List<Professor> findAll() {
        return repository.findAll();
    }

    public Optional<Professor> findById(Long id){
        return repository.findById(id);

    }

    public void delete(Long id){
        repository.deleteById(id);

    }
    public Professor update(Professor professor) {
        Optional<Professor> professorOptional = repository.findById(professor.getId());
        if (professorOptional.isPresent()) {
            Professor professorExistente = professorOptional.get();
            professorExistente.setNome(professor.getNome());
            professorExistente.setEmail(professor.getEmail());
            return repository.save(professorExistente);
        } else {
            throw new IllegalArgumentException("Professor não encontrado");
        }
    }

}
