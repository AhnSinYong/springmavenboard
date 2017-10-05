package spring.maven.board.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.maven.board.common.PagingUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board.do")
    public ModelAndView boardSelectList(Map<String, Object> map) {
        ModelMap model = new ModelMap();
        List<BoardDTO> boardSelectList = boardService.boardSelectList(map);

        int totalCnt = boardSelectList.size();
        int searchNo = 10;
        int searchCntPerPage = 10;
        int searchUnitPage = 10;
        if (totalCnt > 0) {
            PagingUtil.setPageInfo(map, 10);
            model.addAttribute("page", PagingUtil.getPageObject(totalCnt, searchNo, searchCntPerPage, searchUnitPage));
        } else {
            model.addAttribute("page", PagingUtil.getPageObject(totalCnt, 0));
        }

        log.info("run boardSelectList");
        model.addAttribute("boardSelectList", boardSelectList);
        return new ModelAndView("board", model);
    }
}
