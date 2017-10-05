package spring.maven.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ahnsy on 2017-10-04.
 */
@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index(Model model) {
        return "home";
    }

    @RequestMapping("/main.do")
    public String main() {
        LOGGER.info("Success /main.do");
        return "home";
    }
}
