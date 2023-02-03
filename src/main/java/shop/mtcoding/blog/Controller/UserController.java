package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blog.dto.ResponseDto;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping(value = "/loginForm")
    public String loginForm() {
        return "/frontend/user/loginForm";
    }

    @PostMapping(value = "/login")
    public String login(String username, String password) {
        User user = userRepository.login(username, password);
        if (user == null) {
            return "redirect:/loginForm";
        }
        session.setAttribute("principal", user);
        return "redirect:/";
    }

    @GetMapping(value = "/joinForm")
    public String joinForm() {
        return "/frontend/user/joinForm";
    }

    @PostMapping(value = "/join")
    public String insertUser(String username, String password, String email) {
        int result = userRepository.insertUser(username, password, email);
        if (result != 1) {
            return "redirect:/joinForm";
        }
        return "redirect:/loginForm";
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

    @GetMapping(value = "/user/username-samecheck")
    public @ResponseBody ResponseDto<?> check(String username) {
        // 입력확인 (존재하지 않을경우 500 오류)
        // 200 응답을 통해 제어함
        if (username == null || username.isEmpty()) {
            return new ResponseDto<>(-1, "insert username", null);
        }
        // 중복확인
        if (username.equals("ssar")) {
            return new ResponseDto<>(-1, "already has exit", false);
        } else {
            return new ResponseDto<>(1, "can use this one", true);
        }
    }
}
