package com.example.boardv1.reply;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.boardv1.board.Board;
import com.example.boardv1.user.User;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final EntityManager em;

    @Transactional
    public void 댓글쓰기(Integer sessionUserId, int boardId, String comment) {

        Board board = em.getReference(Board.class, boardId);

        User user = em.getReference(User.class, sessionUserId);
        Reply reply = new Reply();
        reply.setBoard(board);
        reply.setComment(comment);
        reply.setUser(user);

        replyRepository.save(reply);

    }

    @Transactional
    public void 댓글삭제(int id, Integer sessionUserId) {
        // 댓글찾고
        Reply reply = replyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("댓글을 찾을 수 없습니다."));
        replyRepository.delete(reply);

        // 권한 체크
        if (reply.getUser().getId() != sessionUserId) {
            throw new RuntimeException("댓글을 삭제할 권한이 없습니다.");
        }

        //댓글 삭제
        replyRepository.delete(reply);

    }

    // 댓글 쓰기 메서드

}
