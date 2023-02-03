package shop.mtcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping(value = "/board/writeForm")
    public String writeForm() {
        return "/frontend/board/writeForm";
    }

    @GetMapping(value = "/board/updateForm")
    public String boardUpdateForm() {
        return "/frontend/board/boardUpdateForm";
    }

    @GetMapping(value = "/board/detail")
    public String detail() {
        return "/frontend/board/detail";
    }

}
