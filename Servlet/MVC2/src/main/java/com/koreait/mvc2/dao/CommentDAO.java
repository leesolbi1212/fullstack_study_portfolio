package com.koreait.mvc2.dao;

import com.koreait.mvc2.dto.CommentDTO;
import org.apache.ibatis.session.SqlSession;

import javax.xml.stream.events.Comment;
import java.util.List;

public class CommentDAO {
    private final SqlSession sqlSession;
    public CommentDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertComment(CommentDTO dto) {
        sqlSession.insert("comment.insertComment", dto);
    }

    public List<CommentDTO> getCommentByBoardIdx(int boardIdx) {
        return sqlSession.selectList("comment.getCommentByBoardIdx", boardIdx);
    }

    public void updateComment(CommentDTO dto) {
        sqlSession.update("comment.updateComment", dto);
    }

    public void deleteComment(CommentDTO dto) {
        sqlSession.delete("comment.deleteComment", dto);
    }

} // class
