package ru.volod878.my_resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volod878.my_resume.exception_handling.exception.NoSuchUserException;
import ru.volod878.my_resume.repository.MyStack;
import ru.volod878.my_resume.repository.StackRepository;
import ru.volod878.my_resume.repository.User;
import ru.volod878.my_resume.repository.UserRepository;

import java.util.Optional;

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
    public String resumePage(Model model) {
        Optional<User> optionalUser = userRepository.findById(1L);
        if (!optionalUser.isPresent()) throw new NoSuchUserException("Пользователь не найден");

        User user = optionalUser.get();

        model.addAttribute("user", optionalUser.get());
        model.addAttribute("allLevelHigh", repository.findByUserIdAndLevel(user.getId(), "high"));
        model.addAttribute("levelHigh", new MyStack());
        model.addAttribute("allLevelLow", repository.findByUserIdAndLevel(user.getId(), "low"));
        model.addAttribute("levelLow", new MyStack());
        return "show_resume";
    }

    @GetMapping("/editor/{id}")
    public String editResumePage(@PathVariable(value = "id") long id,
                             Model model) {

        User user = userRepository.getById(id);

        model.addAttribute("user", user);
        model.addAttribute("allLevelHigh", repository.findByUserIdAndLevel(user.getId(), "high"));
        model.addAttribute("levelHigh", new MyStack());
        model.addAttribute("allLevelLow", repository.findByUserIdAndLevel(user.getId(), "low"));
        model.addAttribute("levelLow", new MyStack());
        model.addAttribute("nameStack");
        model.addAttribute("level");
        return "editor_resume";
    }

    @PutMapping("/editor/{id}")
    public String editResumePage(@PathVariable(value = "id") long id,
                                 @RequestParam(value = "realName") String realName,
                                 @RequestParam(value = "fullText") String fullText) {

        User user = userRepository.getById(id);

        user.setRealName(realName);
        user.setFullText(fullText);

        userRepository.save(user);

        return "redirect:/editor/" + id;
    }

    @PostMapping("/editor/{id}/stack")
    public String addStackForResumePage(@PathVariable(value = "id") long id,
                                        @RequestParam String nameStack,
                                        @RequestParam String level) {

        System.out.println(nameStack);
        System.out.println(level);

        MyStack stack = new MyStack();
        stack.setLevel(level);
        stack.setName(nameStack);
        stack.setUser(userRepository.getById(id));

        repository.save(stack);

        return "redirect:/editor/" + id;
    }

    @PutMapping("/editor/{id}/stack")
    public String editResumePage(@PathVariable(value = "id") long id,
                                 @RequestParam long idStack,
                                 @RequestParam String name) {

        User user = userRepository.getById(id);

        MyStack stack = repository.getById(idStack);
        stack.setName(name);
        stack.setUser(user);

        System.out.println(stack.getName() + " " + stack.getLevel() + " " + stack.getUser().getUsername());

        repository.save(stack);

        return "redirect:/editor/" + id;
    }

    @DeleteMapping("/editor/{id}/stack")
    public String deleteStack(@PathVariable(value = "id") long id,
                              @RequestParam long idStack) {

        MyStack stack = repository.getById(idStack);

        repository.delete(stack);

        return "redirect:/editor/" + id;
    }
}
