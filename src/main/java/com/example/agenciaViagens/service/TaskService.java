package com.example.agenciaViagens.service;

import com.example.agenciaViagens.entity.Task;
import com.example.agenciaViagens.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllDestinations() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> getTaskByDestinyName(String destinyName) {
        return taskRepository.findByDestinyNameContainingIgnoreCase(destinyName);
    }

    public Optional<Task> getTaskByLocation(String location) {
        return taskRepository.findByLocationContainingIgnoreCase(location);
    }

    public Optional<Task> getTaskByDestinyNameOrLocation(String termo) {
        return taskRepository.findByDestinyNameContainingIgnoreCase(termo)
                .isEmpty() ? taskRepository.findByLocationContainingIgnoreCase(termo)
                : taskRepository.findByDestinyNameContainingIgnoreCase(termo);
    }

    public Task createTask(Task task) {
        taskRepository.save(task);
        return task;
    }

    public Task updateTask(Long id, Task task) {
        task.setId(id);
        taskRepository.save(task);
        return task;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task rateDestination(Long id, Double nota) {
        Optional<Task> taskRepo = getTaskById(id);
        double totalNotas = Task.getNotaMedia() * Task.getTotalAvaliation();
        totalNotas += nota;
        Task.setTotalAvaliation(Task.getTotalAvaliation() + 1);
        Task.setNotaMedia(totalNotas / Task.getTotalAvaliation());
        return taskRepository.save(taskRepo.get());
    }
}
