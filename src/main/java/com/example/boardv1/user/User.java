package com.example.boardv1.user;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

//리플렉션은 세터가 없어도 프라이베이트 객체에 접근이 가능함
@Data
@NoArgsConstructor // object mapping을 hibernate가 할때 디폴트 생성자를 new한다.
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true) //테이블에 제약조건을 건다 pk,유니크일때 인덱스를 만들어준다
    private String username;
    @Column(nullable = false, length = 100 ) // 비번은 필수! 글고 비번은 해시하면 6~80지로 늘껀데 그럼 터져서 낭낭하게 100자로 만들기
    private String password;
    private String email;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}

