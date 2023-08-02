package memozy.momozy.controller;

import memozy.momozy.domain.Memo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

//    @GetMapping("home")
//    public String home(Model model){
//        model.addAttribute("title", "Dog!");
//        return "home";
//    }

//    @GetMapping("home")
//    @ResponseBody
//    public Memo home(@RequestParam(value = "title") String title){
////        model.addAttribute("title","HOME!");
//        Memo memo = new Memo();
//        memo.setTitle(title);
//        return memo;
//    }
}
