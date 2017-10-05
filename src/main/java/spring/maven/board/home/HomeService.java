package spring.maven.board.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Service
public class HomeService {

    @Autowired
    private HomeDAO homeDAO;

    public List<HomeDTO> homeSelectList(Map<String, Object> map) {
        return homeDAO.homeSelectList(map);
    }
}
