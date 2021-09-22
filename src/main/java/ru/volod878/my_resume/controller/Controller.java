package ru.volod878.my_resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.volod878.my_resume.repository.MyStack;
import ru.volod878.my_resume.repository.StackRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    StackRepository repository;

    @Autowired
    public Controller(StackRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<MyStack>> getAllStacks(@PathVariable(value = "id") Long id) {
        List<MyStack> list = repository.findByUserId(id);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
