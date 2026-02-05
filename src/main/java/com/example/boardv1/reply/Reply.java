package com.example.boardv1.reply;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.example.boardv1.board.Board;
import com.example.boardv1.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/*게시글 1 댓글 N
* 유저 1 댓글 N
*/


@NoArgsConstructor
@Data
@Entity
@Table (name = "reply_tb")

public class Reply { //파일의 목적 : 댓글은 이렇게 생겼어! (내용, 게시글 번호, 작성자)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    @ManyToOne
    private Board board;

    @ManyToOne
    private User user;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
