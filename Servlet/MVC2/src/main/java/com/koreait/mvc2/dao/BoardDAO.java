package com.koreait.mvc2.dao;

import com.koreait.mvc2.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BoardDAO {
    private final SqlSession sqlSession;

    public BoardDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void insertBoard(BoardDTO dto) {
        //mapper 전달: sqlsession이 그 역할을 함
        //sqlSession.insert(nameSpace.id, 파라미터이름)
        sqlSession.insert("board.insertBoard", dto);
    }

    public List<BoardDTO> getBoardList(Map<String, Object> paramMap) {
        // selectList: select 해서 list로 반환할 수 있는 메소드
        return sqlSession.selectList("board.getBoardList", paramMap);
    }

    public int getTotalCount() {
        // selectOne: 하나만 select 해서 반환하는 메소드
        return sqlSession.selectOne("board.getTotalCount");
    }

    public BoardDTO getBoard(int idx) {
        return sqlSession.selectOne("board.getBoard", idx);
    }

    public void increaseViewCount(int idx) {
        sqlSession.update("board.increaseViewCount", idx);
    }

    public void updateBoard(BoardDTO dto) {
        sqlSession.update("board.updateBoard", dto);
    }

    public void deleteBoard(int idx) {
        sqlSession.delete("board.deleteBoard", idx);
    }


} // class
