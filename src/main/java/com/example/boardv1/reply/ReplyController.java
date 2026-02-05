package com.example.boardv1.reply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.boardv1.user.User;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final HttpSession session; 


    @PostMapping("/replies/save")
    public String replySave(ReplyRequest.SaveDTO reqDTO){


        // 인증 블록
        User sessionUser = (User) session.getAttribute("sessionUser");

        if (sessionUser == null)
            throw new RuntimeException("인증되지 않았습니다."); 
        
        Integer sessionUserId = sessionUser.getId(); //userId를 가져옴
        replyService.댓글쓰기(sessionUserId, reqDTO.getBoardId(), reqDTO.getComment());

        return "redirect:/boards/"+reqDTO.getBoardId(); 
    }

    @PostMapping("/replies/{id}/delete")
    public String delete(@PathVariable("id") int id, @RequestParam("boardId") int boardId){
        // 인증
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) 
            throw new RuntimeException("인증되지 않았습니다.");

        replyService.댓글삭제(id, sessionUser.getId());

        return "redirect:/boards/" + boardId; 
    }

    
}



