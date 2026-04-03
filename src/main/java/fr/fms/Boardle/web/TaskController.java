package fr.fms.Boardle.web;

import fr.fms.Boardle.dao.TaskRepository;
import fr.fms.Boardle.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<Task> tasks = taskRepository.findAll();

        model.addAttribute("tasks", tasks);

        return "board";
    }
}
