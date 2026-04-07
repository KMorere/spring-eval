package fr.fms.Boardle.web;

import fr.fms.Boardle.dao.TagRepository;
import fr.fms.Boardle.dao.TaskRepository;
import fr.fms.Boardle.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TagRepository tagRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<Task> tasks = taskRepository.findAll();

        model.addAttribute("tasks", tasks);

        return "board";
    }

    @PostMapping("/complete_task")
    public String complete_task(Task task) {
        Task newTask = taskRepository.findById(task.getId()).get();
        newTask.setCompleted(!newTask.isCompleted());
        taskRepository.save(newTask);
        return "redirect:/index";
    }

    @GetMapping("/add_task")
    public String add_task(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tags", tagRepository.findAll());
        return "add_task";
    }

    @PostMapping("/save")
    public String save(@Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/add_task";
        taskRepository.save(task);
        return "redirect:/index";
    }

    @GetMapping("/edit_task")
    public String edit_task(Model model, @RequestParam(name="id") long id) {
        Task task = taskRepository.getById(id);
        model.addAttribute("id", id);
        model.addAttribute("task", task);
        model.addAttribute("tags", tagRepository.findAll());
        System.out.println(task);
        return "edit_task";
    }

    @PostMapping("/update")
    public String update(Task task) {
        System.out.println(task);
        taskRepository.save(task);
        return "redirect:/index";
    }
}
