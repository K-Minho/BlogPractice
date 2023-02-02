package shop.mtcoding.blog.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.blog.Model.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping(value = { "/", "/main" })
    public String main() {
        return "/frontend/user/main";
    }

    @GetMapping(value = "/loginForm")
    public String loginForm() {
        return "/frontend/user/loginForm";
    }

    @GetMapping(value = "/joinForm")
    public String joinForm() {
        return "/frontend/user/joinForm";
    }

    @GetMapping(value = "/user/updateForm")
    public String updateForm() {
        return "/frontend/user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}
