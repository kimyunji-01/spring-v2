package com.example.boardv1.board;

import java.util.List;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(BoardNativeRepository.class) // 단위테스트 : 내가 필요한거만 띄워서 테스트 해보는것
@DataJpaTest // EntityManager가 ioc에 등록됨
public class BoardNativeRepositoryTest {

    @Autowired // 어노테이션 DI기법
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void findById_test() {
        // given
        int id = 1;
        // when
       Board board = boardNativeRepository.findById(id);
        // eye
        System.out.println(board);

    }

    @Test
    public void findAll_test() {
        //when
        List<Board> list = boardNativeRepository.findAll();
        for (Board board : list) {
            //eye
            System.out.println(board);
        }

    }
@Test
    public void save_test() {

        // given
        String title = "a";
        String content = "b";
        
        //when
        boardNativeRepository.save(title,content);
        // eye
        List<Board> list = boardNativeRepository.findAll();
        for (Board board : list) {
          
            System.out.println(board);
        }

        
    }
@Test
    public void deleteById_test() {
        
        // given
        int id = 1;
        //when
        boardNativeRepository.deleteById(id);
        // eye
        List<Board> list = boardNativeRepository.findAll();
        for (Board board : list) {
          
            System.out.println(board);
        }
    }
@Test
    public void updateById_test() {
  // given
  int id = 3;
  String title = "a";
  String content = "b";
  //when
  boardNativeRepository.updateById(id,title,content);
  // eye
  List<Board> list = boardNativeRepository.findAll();
  for (Board board : list) {
    
      System.out.println(board);
  }
    }
}
