package shop.mtcoding.blog.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {

    public int insertBoard(@Param("title") String title, @Param("content") String content, @Param("userId") int userId);

    public List<Board> findAllBoard();

    public List<Board> findBoardById(int id);

    public int updateBoard(@Param("id") int id, @Param("title") String title, @Param("content") String content);

    public int deleteBoard(int id);

}
