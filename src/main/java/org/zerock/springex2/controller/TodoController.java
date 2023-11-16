package org.zerock.springex2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex2.dto.PageRequestDTO;
import org.zerock.springex2.service.TodoService;
import org.zerock.springex2.dto.TodoDTO;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2

public class TodoController {

    @Autowired
    private TodoService todoService;

    //글 전체 조회(페이징 전)
//    @RequestMapping("/list")
//    public void list(Model model){
//        log.info("todo list ......");
//        model.addAttribute("dtoList", todoService.getAll());
//    })


    // 페이징 후 글 조회
    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info(" paging list ......");

        log.info("요청된 페이징 관련 정보 " + pageRequestDTO) ;
//        model.addAttribute("dtoList", todoService.getAll());

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void registerGet(){
        log.info("GET todo register");}

 
    @PostMapping ("/register")
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
   // @RequestMapping 함수는 RedirectAttributes 타입의 메소드를 선언하여 Flash Attribute 를 추가할 수 있다. < addFlashAttribute() > .
    // 이 메서드를 사용하여 Redirect 시에 Attribute 를 필요에 따라 제어할 수 있다.
    // BindingResult 데이터 유효성 검사를 위한 객체를 만들어 주고 @Valid 어노테이션이 처리해줌
    // RedirectAttributes redirect를 처리해주는 객체
    // addFlashAttribute() 를 이용하면 URL에 보이지는 않지만, JSP에서는 일회용으로 사용할수 있다
        //addAttribute()로 데이터를 추가하면 리다이렉트할 url에 쿼리 스트링으로 추가된다.
     log.info("Post todo register ......");
        log.info("매개변수로 들어온 TodoDTO : "+ todoDTO );

        if(bindingResult.hasErrors()){
            log.info("유효하지 않은 데이터가 들어옴");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }
        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    // 글 하나 읽기

    @GetMapping("/read")
    public  void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto",todoDTO);
    }
    // 글 하나 수정 서버에 반영

    @GetMapping("/modify")
    public void modify(Long tno, Model model){
        TodoDTO todoDTO =todoService.getOne(tno);
        log.info(todoDTO);
        model.addAttribute("dto", todoDTO);
    }
    @PostMapping String modify(@Valid TodoDTO todoDTO,BindingResult bindingResult,RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors())
        // hasErrors = ture
        {
            log.info("데이터 유효하지 않음");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors() );
            redirectAttributes.addAttribute("tno", todoDTO.getTno() );
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("tno", todoDTO.getTno() );

        return "redirect:/todo/list";
    }
    //글 하나 삭제
    @PostMapping("/remove")
    public String remove(Long tno, RedirectAttributes redirectAttributes) {

        log.info("-------------remove------------------");
        log.info("tno: " + tno);
        todoService.remove(tno);

        return "redirect:/todo/list";


    }
    }