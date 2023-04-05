package com.crudPost.Post.Service;

import com.crudPost.Post.Dao.BoardDao;
import com.crudPost.Post.Dto.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao boardDao;

    @Transactional
    public void addBoard(int userId, String title, String content) {
        boardDao.addBoard(userId, title, content);
    }

    @Transactional
    public int getTotalCount(){
        return boardDao.getTotalCount();
    }

    @Transactional
    public List<Board> getBoards(int page){
        return boardDao.getBoards(page);
    }


}
