package com.example.boardv1.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 붙은 애들을 자동으로 new해준다
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> 게시글목록() {
        return boardRepository.findAll();
    }

    public Board 상세보기(int id) {
        return boardRepository.findById(id);
    }

    @Transactional // update,delete,insert 할때 붙이기. 고립이 되어잇어야 함 중간에 누가 정보를 끼워 넣으면 우짬
    public void 게시글수정(int id, String title, String content) {
        Board board = boardRepository.findById(id);
        board.setTitle(title);
        board.setContent(content);
    }

    @Transactional // 원자성 (모든게 다 되면 commit, 하나라도 실패하면 rollback)
    // 트랜잭션 종료시 flush 됨.
    public void 게시글쓰기(String title, String content) {
        // 1.비영속 개체
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);

        System.out.println("before persist" + board.getId());

        // 2.persist
        boardRepository.save(board);

        System.out.println("after persist" + board.getId());

    }

    @Transactional
    public void 게시글삭제(int id) {
        Board board = boardRepository.findById(id); // 영속화

        boardRepository.delete(null);
    }// commit 되면서 자동 flush

}
