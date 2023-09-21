package org.zerock.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.zerock.ajax.entity.Memo;
import org.zerock.ajax.repository.MemoRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class TestController {
    @Autowired
    MemoRepository memoRepository;

    @GetMapping("/ajax")
    public String ajax1() {
        return "ajaxTest";
    }

    @GetMapping("/ajax2")
    public String ajax2() {
        return "ajaxTest2";
    }

    @GetMapping("/list/{page}")
    public String list(@PathVariable int page, Model model) {
        Sort sort1 = Sort.by("mno").descending();
        PageRequest pageRequest = PageRequest.of(page, 10, sort1);
       Page<Memo> list = memoRepository.findAll(pageRequest);
        model.addAttribute("list", list.getContent());
        return "page";

    }
    @GetMapping("/update/{mno}/{memoText}")
    public Memo update1(@PathVariable Long mno, @PathVariable String memoText, Model model) {
        memoRepository.updateMenoText(mno,memoText);
        Optional<Memo> memo = memoRepository.findById(mno);
        return memo.get();
    }
}
