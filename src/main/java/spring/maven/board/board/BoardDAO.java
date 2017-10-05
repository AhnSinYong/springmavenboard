package spring.maven.board.board;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Repository
public class BoardDAO {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public List<BoardDTO> boardSelectList(Map<String, Object> map) {
        return sessionTemplate.selectList("boardSelectList", map);
    }
}
