package pl.piotrpestka.bestCars.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public String showNewUserForm(){
        return "user/newUserForm";
    }

    @PostMapping("/users")
    public String addNewUser(@RequestParam String name, @RequestParam String lastName,
                            @RequestParam String email, @RequestParam String password,
                            @RequestParam String city, @RequestParam String street,
                            @RequestParam int number, Model model) {

        try {


            boolean result = userService.addNewUser(name, lastName, email,password , city, street, number);
            model.addAttribute("addedUser", result);
            // mod.addAttribute("allMyCars",listOfCars);
            return "user/userInfo";

        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getLocalizedMessage());
            return "user/newUserForm";
        }



    }
}
