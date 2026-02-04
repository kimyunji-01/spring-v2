package com.example.boardv1.board;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.example.boardv1.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 데이터베이스 세상의 데이터를 자바 세상에 모델링한 결과 : 엔티티
 */

@Getter // getter/setter/toString
@Setter
@Entity // 해당 어노테이션을 보고, 컴포넌트 스캔 후, 데이터 베이스를 생성한다
@Table(name = "board_tb")
public class Board { // user 1,board N

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String title;

    private String content;

    // private Integer userId;
    @ManyToOne(fetch = FetchType.EAGER) // 포린키 만들기 디폴트는 Eager
    private User user;

    @CreationTimestamp
    private Timestamp createdAt;

    @Override
    public String toString() {
        return "Board [Id=" + Id + ", title=" + title + ", content=" + content + ", user=" + user + ", createdAt="
                + createdAt + "]";
    }

}
