package com.example.boardv1.reply;

import lombok.Data;

public class ReplyRequest {
 
    @Data
    public static class SaveDTO {
    private Integer boardId; // 어느 게시글에 쓰는지
    private String comment; // 댓글 내용
    
    }
    
}
