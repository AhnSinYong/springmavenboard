package spring.maven.board.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Controller
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public String homeSelectList(Locale locale, Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("usr_id", "kim");
        map.put("usr_lv", 1);

        List<HomeDTO> homeSelectList = homeService.homeSelectList(map);

        homeSelectList.forEach(homeDTO -> LOGGER.info(homeDTO.toString()));
        //for (HomeDTO homeDTO : homeSelectList) {
        //    LOGGER.info(homeDTO.toString());
        //}
        model.addAttribute(homeSelectList);
        return "home";
    }
}
