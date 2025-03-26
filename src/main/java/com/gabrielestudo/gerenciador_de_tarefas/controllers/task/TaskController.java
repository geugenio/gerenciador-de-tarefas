package com.gabrielestudo.gerenciador_de_tarefas.controllers.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gabrielestudo.gerenciador_de_tarefas.model.Task;
import com.gabrielestudo.gerenciador_de_tarefas.model.TaskStatus;
import com.gabrielestudo.gerenciador_de_tarefas.services.TaskService;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tasks");
		List<Task> tasks = taskService.findAll();
		mv.addObject("tasks", tasks);
		return mv;
	}

	@GetMapping("/formulario")
	public String form(Model model) {
		Task task = new Task();
		model.addAttribute("task", task);
		return "formulario";
	}

	@PostMapping("/formulario")
	public String save(Task task) {
		task.setStatus(TaskStatus.EM_ANDAMENTO);
		taskService.save(task);
		return "redirect:/formularios";
	}

	@GetMapping("/formularios")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tasks");
		List<Task> tasks = taskService.findAll();
		mv.addObject("tasks", tasks);
		return mv;
	}

	@GetMapping("/formulario/delete/{id}")
	public String deleteTask(@PathVariable Long id) {
		taskService.delete(taskService.getReferenceById(id));
		return "redirect:/";
	}

	@GetMapping("/formulario/edit/{id}")
	public String openFormEdit(@PathVariable Long id, Model model) {
		Task task = taskService.findById(id).orElse(null);
		model.addAttribute("task", task);
		return "formulario-edit";
	}

	@PutMapping("/formulario/edit/{id}")
	public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
		Task taskExist = taskService.findById(id).orElse(null);
		if (taskExist != null) {
			taskExist.setDescription(task.getDescription());
			taskExist.setTitle(task.getTitle());
			taskExist.setDueDate(task.getDueDate());
			taskExist.setCreationTimestamp(task.getCreationTimestamp());
			taskExist.setId(task.getId());
			taskService.save(taskExist);
		}
		return "redirect:/";
	}

	@GetMapping("/formulario/edit/status/concluido/{id}")
	public String updateStatusToConcluido(@PathVariable Long id, @ModelAttribute Task task) {
		Task taskExist = taskService.findById(id).orElse(null);
		if (taskExist != null) {
			taskExist.setStatus(TaskStatus.CONCLUIDO);
			taskService.save(taskExist);
		}
		return "redirect:/";
	}

	@GetMapping("/formulario/edit/status/andamento/{id}")
	public String updateStatusToAndamento(@PathVariable Long id, @ModelAttribute Task task) {
		Task taskExist = taskService.findById(id).orElse(null);
		if (taskExist != null) {
			taskExist.setStatus(TaskStatus.EM_ANDAMENTO);
			taskService.save(taskExist);
		}
		return "redirect:/";
	}

	@GetMapping("/formulario/edit/status/desistiu/{id}")
	public String updateStatusToDesistiu(@PathVariable Long id, @ModelAttribute Task task) {
		Task taskExist = taskService.findById(id).orElse(null);
		if (taskExist != null) {
			taskExist.setStatus(TaskStatus.DESISTIU);
			taskService.save(taskExist);
		}
		return "redirect:/";
	}

	@GetMapping("/formulario/deleteall")
	public String deleteAll() {
		taskService.deleteAll();
		return "redirect:/";
	}
}
