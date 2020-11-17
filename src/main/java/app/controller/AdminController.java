package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;
    //начиная с версии Framework Spring 4.3 помечать конструктор аннотацией @Autowered не обязательно,
    // если целевой компонент определяет только один конструктор.
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String helloPage() {
        return "/mainpage";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
//        model.addAttribute("roles", userService.getAllRoles)

        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @GetMapping("/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        User user = userService.findUserById(id);
        System.out.println(user);
        System.out.println("model" + model);
        model.addAttribute("user", user);
        return "/edit";
    }

    @GetMapping("/new")
    public String openPageNew(@ModelAttribute ("user") User user){
        return "/create";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/admin/all";
    }

    @PostMapping("/{id}")
    public String postEdit(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:all";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/admin/all"; // return "redirect: /all" не редиректится по RequesеMapping, даже по абсолютному пути
    }
}
