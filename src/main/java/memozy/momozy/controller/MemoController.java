package memozy.momozy.controller;
import memozy.momozy.domain.Memo;
import memozy.momozy.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MemoController {
    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/memo")
    public String list(Model model){
        List<Memo> memo = memoService.findMemo();
        model.addAttribute("memo",memo);
        return "memo/memoList";
    }

    @GetMapping("/memo/new")
    public String createForm(){
        return "memo/createMemoForm";
    }
    @PostMapping("/memo/new")
    public String createMemo(MemoForm form){
        Memo memo = new Memo();
        memo.setTitle(form.getTitle());
        memo.setContent(form.getContent());
        memoService.write(memo);
        return "redirect:/";
    }

//    @GetMapping("/memo/{id}")
//    public String updateForm() {
//        return "memo/updateMemoForm";
//    }
    @GetMapping("/memo/{id}")
    public String updateForm(@PathVariable Long id) {
        System.out.println("edit get in!!!");
//        Optional<Memo> memo = memoService.findMemoId(id);
//        model.addAttribute("memo", memo);
        System.out.println(id);
        return "memo/updateMemoForm";
    }
    @PutMapping("/memo/{id}")
    public String updateMemo(@PathVariable("id") Long id, MemoForm form) {
        Optional<Memo> memoOptional = memoService.findMemoId(id);
        if (memoOptional.isPresent()){
            Memo memo = memoOptional.get();
            memo.setTitle(form.getTitle());
            memo.setContent(form.getContent());
            memoService.write(memo);
        }
        else {
            System.out.println("memoOptional not isPresent");
        }
        return "redirect:/memo";
    }

    @DeleteMapping("/memo/deleteMemo/{id}") // Correct the path to include the {id} parameter
    public String deleteMemo(@PathVariable Long id){
        System.out.println("delete in !");
        memoService.delete(id);
        return "redirect:/memo";
    }


}
