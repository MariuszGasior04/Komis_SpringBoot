
package pl.altkom.komis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mgasior
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String viewHomePage() {

        return "index";

    }
}
