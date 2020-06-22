package com.codegym.wdbsspringboot.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

public class TaskForm {
    private Long id;

    private String name;

    private String description;

    private MultipartFile avatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }

    public TaskForm() {
    }

    public TaskForm(Long id, String name, String description, MultipartFile avatar) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.avatar = avatar;
    }

    public TaskForm(String name, String description, MultipartFile avatar) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
    }
}
