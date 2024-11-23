package com.example.agenciaViagens.repository;

import com.example.agenciaViagens.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


    Optional<Task> findByDestinyNameContainingIgnoreCase(String destinyName);
    Optional<Task> findByLocationContainingIgnoreCase(String location);

    String location(String location);
}
