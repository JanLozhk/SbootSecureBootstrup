package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String helloPage() {
        return "/mainpage";
    }

    @GetMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
            User user = userService.findUserById(id);
        System.out.println(user.toString());
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
        return "redirect:user/all";
    }

    @PostMapping("/{id}")
    public String postEdit(@ModelAttribute() User user) {
        userService.update(user);
        return "redirect:all";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:all";
    }
}
/*Условие:
Перейдем к созданию рабочего web-приложения. Все ключевые моменты были рассмотрены в предыдущих задачах. Теперь вам требуется их сопоставить и связать в один проект.
Используя наработки по mvc и hibernate соберите CRUD-приложение.
Задание:
1. Написать CRUD-приложение. Использовать Spring MVC + Hibernate.
 3. В приложении должна быть страница, на которую выводятся все юзеры с возможностью добавлять, удалять и изменять юзера.
4. Конфигурация Spring через JavaConfig и аннотации, по аналогии с предыдущими проектами. Без использования xml. Без Spring Boot.
5. Внесите изменения в конфигурацию для работы с базой данных. Вместо SessionFactory должен использоваться EntityManager.
*/