package main.application;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlPage {

    @GetMapping("/index")
    public String getPage(@RequestParam(name = "name", required = false, defaultValue = "Hi")
                                      String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
