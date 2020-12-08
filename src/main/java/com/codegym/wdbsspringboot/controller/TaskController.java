package com.codegym.wdbsspringboot.controller;

import com.codegym.wdbsspringboot.model.AppUser;
import com.codegym.wdbsspringboot.model.Task;
import com.codegym.wdbsspringboot.model.TaskForm;
import com.codegym.wdbsspringboot.service.taskservice.ITaskService;
import com.codegym.wdbsspringboot.service.userservice.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    @Autowired
    private IAppUserService appUserService;

    @Autowired
    Environment env;


    @ModelAttribute("user")
    public AppUser user() {
        return appUserService.getCurrentUser();
    }

    @GetMapping()
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/task/list");
        List<Task> tasks = (List<Task>) taskService.findAll();
        modelAndView.addObject("tasks", tasks);
        modelAndView.addObject("mess", "Xin chao");
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("task", new TaskForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView creatTask(@ModelAttribute TaskForm task){
        Task task1 = new Task(task.getName(), task.getDescription());
        MultipartFile multipartFile = task.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(task.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        task1.setAvatar(fileName);
        taskService.save(task1);
        System.out.println(user().getUsername());
        return new RedirectView("");
    }
}
