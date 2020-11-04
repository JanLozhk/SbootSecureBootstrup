package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

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

    @GetMapping//("/users")
    public String helloPage(){//Model model){
   //     model.addAttribute("allUsers", userServiceImpl.readAllUsers());
        return "/mainpage";
    }

    @GetMapping("/getall")//("")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userServiceImpl.getAllUsers());
        return "/users";
    }


    @GetMapping(value = "/{id}")
    public String findUserById(@PathVariable("id") long id, Model model) {
        User user = userServiceImpl.findUserById(id);
        model.addAttribute("user", user);
        return "/user";
    }

   /* @GetMapping(value = "/add")
    public String addPage(User user, ModelMap model) {
        model.addAttribute("user", user);
        return "addPage";
    }
*/
    @PostMapping//(value = "/edit") //post request for edit.html
    public String createUser(@ModelAttribute User user) {
        userServiceImpl.create(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable ("id") long id) {
        userServiceImpl.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userServiceImpl.delete(id);
        return "redirect:/users";
    }
/*    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userServiceImpl.create(user);//add(user);//save(user);//add(user);
        return "/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id){
        model.addAttribute("user", userServiceImpl.update(id));//getById(id));//show(id));//);
        return "edit";
    }

    @PatchMapping("/{id}")
    public String udgate(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userServiceImpl.update(id, user);//update(id, user);//edit(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userServiceImpl.delete(id);
        return "redirect:/users";
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