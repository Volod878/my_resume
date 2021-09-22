package ru.volod878.my_resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.volod878.my_resume.repository.MyStack;
import ru.volod878.my_resume.repository.StackRepository;
import ru.volod878.my_resume.repository.User;
import ru.volod878.my_resume.repository.UserRepository;

import java.security.Principal;

@Controller
public class MainController {

    StackRepository repository;
    UserRepository userRepository;

    @Autowired
    public MainController(StackRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String resumePage(Model model, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).get();

        model.addAttribute("realName", user.getRealName());

        model.addAttribute("allLevelHigh", repository.findByUserIdAndLevel(user.getId(), "High"));
        model.addAttribute("levelHigh", new MyStack());
        model.addAttribute("allLevelLow", repository.findByUserIdAndLevel(user.getId(), "Low"));
        model.addAttribute("levelLow", new MyStack());
        return "show_resume";
    }
}
