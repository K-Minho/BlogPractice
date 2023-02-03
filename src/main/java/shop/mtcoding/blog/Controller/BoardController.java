package shop.mtcoding.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.model.Board;
import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;

@Controller
public class BoardController {

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping(value = { "/", "/main" })
    public String main(Model model) {
        List<Board> boardList = boardRepository.findAllBoard();
        model.addAttribute("boardList", boardList);
        return "/frontend/board/main";
    }

    @GetMapping(value = "/board/writeForm")
    public String writeForm() {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/user/loginForm";
        }
        return "/frontend/board/writeForm";
    }

    @PostMapping(value = "/board/write")
    public String write(String title, String content) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/user/loginForm";
        }
        int result = boardRepository.insertBoard(title, content, principal.getId());
        if (result != 1) {
            return "redirect:/board/writeForm";
        }
        return "/frontend/board/detail";
    }

    @GetMapping(value = "/board/updateForm/{id}")
    public String boardUpdateForm(@PathVariable int id, Model model) {
        List<Board> board = boardRepository.findBoardById(id);
        model.addAttribute("boardDetail", board);
        return "/frontend/board/boardUpdateForm";
    }

    @PostMapping(value = "/board/update")
    public String boardUpdate(String title, String content) {
        User principal = (User) session.getAttribute("principal");
        if (principal == null) {
            return "redirect:/user/loginForm";
        }
        int result = boardRepository.updateBoard(0, title, content);
        if (result != 1) {
            return "redirect:/board/writeForm";
        }
        return "/frontend/board/detail";
    }

    @GetMapping(value = "/board/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        List<Board> board = boardRepository.findBoardById(id);
        model.addAttribute("boardDetail", board);
        return "/frontend/board/detail";
    }

}
