package com.gabrielestudo.gerenciador_de_tarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gabrielestudo.gerenciador_de_tarefas.model.Task;

@EnableJpaRepositories
public interface TaskRepository extends JpaRepository<Task, Long>{
	public List<Task> findAll();
}
