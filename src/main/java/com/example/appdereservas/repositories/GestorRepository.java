package com.example.appdereservas.repositories;

import com.example.appdereservas.entities.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Long> {
}
