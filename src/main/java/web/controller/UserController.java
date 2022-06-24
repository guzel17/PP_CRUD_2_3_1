package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(User user) {
        return "new";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user, Long id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
