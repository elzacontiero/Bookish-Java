package org.softwire.training.bookish.controllers;
import org.softwire.training.bookish.models.database.Book;
import org.softwire.training.bookish.models.database.User;
import org.softwire.training.bookish.models.page.UsersModel;
import org.softwire.training.bookish.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    //constructor below
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    ModelAndView allUsers() {

        List<User> allUsers = userService.getAllUsers();

        UsersModel model = new UsersModel();
        model.setUsers(allUsers);

        return new ModelAndView("users", "model", model);
    }

    @RequestMapping("/add-user")
    RedirectView addUser(@ModelAttribute User user) {

        userService.addUser(user);

        return new RedirectView("/users");
    }

    @RequestMapping("/delete-user")
    RedirectView deleteUser(@RequestParam int userId) {

        userService.deleteUser(userId);

        return new RedirectView("/users");
    }

}


