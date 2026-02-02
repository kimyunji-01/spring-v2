package com.example.boardv1.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import; //import한번에 하는법 alt shift O

import jakarta.persistence.EntityManager;

@Import(BoardRepository.class) // 단위테스트 : 내가 필요한거만 띄워서 테스트 해보는것
@DataJpaTest // EntityManager가 ioc에 등록됨

public class BoardRepositoryTest {

    @Autowired // 어노테이션 DI기법
    private BoardRepository boardRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void save_test() {
        // given
        Board board = new Board();
        board.setTitle("title7");
        board.setContent("content7");
        System.out.println("===before persist");
        System.out.println(board.toString());
        // when
        boardRepository.save(board);

        // eye (Board객체가 DB와 동기화 됌)
        System.out.println("===after persist");
        System.out.println(board.toString());
    }

    @Test
    public void findById_test() {
        // given
        int id = 1;
        // when
        Board board = boardRepository.findById(id);
        // boardRepository.findById(1);
        // eye
        System.out.println(board);
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<Board> list = boardRepository.findAll();
        // eye
        for (Board board : list) {
            System.out.println(board);
        }
    }

    @Test
    public void findAllV2_test() {
        // given

        // when
        boardRepository.findAllV2();
        // eye
    }

    @Test
    public void Delete_test() {
        // given
        Board board = boardRepository.findById(1);

       
        // when
        boardRepository.delete(board); 

        // eye
        em.flush(); //예약된 쿼리를 만드는거

    }
    @Test
    public void update_test() {
        // given
        Board board = boardRepository.findById(1);

        // when
        board.setTitle("title1-update");

        // eye
        em.flush();

        List<Board> list = boardRepository.findAll();

        // eye
        for (Board b : list) {
            System.out.println(b);
        }
    }
    @Test
    public void findByIdV2_test(){
        //given
        int id = 1;
        //when
        boardRepository.findById(id);
        em.clear(); 
        boardRepository.findById(id);
        //eye
       
    }
}
