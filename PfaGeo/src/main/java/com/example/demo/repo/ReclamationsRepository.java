package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Reclamations;

public interface ReclamationsRepository extends CrudRepository<Reclamations, Integer> {
	   List<Reclamations> findByLocalisation(String localisation);
}