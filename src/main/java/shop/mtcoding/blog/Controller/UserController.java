package shop.mtcoding.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

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
}
