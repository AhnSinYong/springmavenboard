package spring.maven.board.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Service
public class BoardService {

    @Autowired
    private BoardDAO boardDAO;

    public List<BoardDTO> boardSelectList(Map<String, Object> map) {
        return boardDAO.boardSelectList(map);
    }
}
