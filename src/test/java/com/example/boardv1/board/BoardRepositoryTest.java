package com.example.boardv1.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import; //import한번에 하는법 alt shift O

@Import(BoardRepository.class) // 단위테스트 : 내가 필요한거만 띄워서 테스트 해보는것
@DataJpaTest // EntityManager가 ioc에 등록됨

public class BoardRepositoryTest {

    @Autowired // 어노테이션 DI기법
    private BoardRepository boardRepository;

    @Test
    public void save_test(){
Board board = new Board();
board.setTitle("title7");
board.setContent("content7");
boardRepository.save(board);
    }
}
