package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user.getId(), user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}