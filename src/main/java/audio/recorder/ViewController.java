package audio.recorder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Sriya on 6/17/16.
 */
@Controller
public class ViewController {
    @RequestMapping("/play")
    public String index(Model model){
        model.addAttribute("datetime",new Date());
        model.addAttribute("username","Cool Hacker");
        model.addAttribute("mode","development");
        //model.addAttribute("mode","production");
        return "player";
    }
}
