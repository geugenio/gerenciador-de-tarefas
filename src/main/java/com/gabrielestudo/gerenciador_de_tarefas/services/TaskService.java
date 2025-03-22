package com.gabrielestudo.gerenciador_de_tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielestudo.gerenciador_de_tarefas.model.Task;
import com.gabrielestudo.gerenciador_de_tarefas.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	public void save(Task task) {
		taskRepository.save(task);
	}

	public void delete(Task task) {
		taskRepository.delete(task);
	}

	public Task getReferenceById(Long id) {
		return taskRepository.getReferenceById(id);
	}

	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);

	}

	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public void deleteAll() {
		taskRepository.deleteAll();
	}
}
