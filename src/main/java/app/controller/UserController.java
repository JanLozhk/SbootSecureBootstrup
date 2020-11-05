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

   /* public UserController() {
        System.out.println("!!!");
    }*/

/*    @GetMapping("")
    public String findUser(ModelMap user, @RequestParam(required = false) User user) {
//        cars(ModelMap model, @RequestParam(required = false) Integer count) {

        List<User> usersList = userServiceImpl.findUser();
        user.addAttribute("usersList", usersList);
        return "users";
    }*/

    @GetMapping
    public String helloPage() {
        return "/mainpage";
    }

    @GetMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        System.out.println("GetMapping_AllUsers" + userService.getAllUsers());
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
        userService.create(user);//add(user);//save(user);//add(user);
        return "/users";
    }

    @PostMapping("/{id}")
    public String postEdit(/*@PathVariable Long id,*/ @ModelAttribute() User user) {
        userService.update(user);
        return "redirect:all";//"users"; ВЫВОДИТ ОГРЫЗОК СТРАНИЦЫ USERS
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.delete(id);
        return "/users";
    }
/*    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userServiceImpl.create(user);//add(user);//save(user);//add(user);
        return "/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userServiceImpl.update(id));//getById(id));//show(id));//);
        return "edit";
    }

    @PatchMapping("/{id}")
    public String udgate(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userServiceImpl.update(id, user);//update(id, user);//edit(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userServiceImpl.delete(id);
        return "redirect:/user";
    }*/
// public create(){

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