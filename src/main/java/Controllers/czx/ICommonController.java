package Controllers.czx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 星包客
 */
@Controller
public class ICommonController {
    @RequestMapping(value="/top.action",method= RequestMethod.GET)
    public String top(){
        return "czx/Itop";
    }
    @RequestMapping(value="/left.action",method=RequestMethod.GET)
    public String left(){
        return "czx/Ileft";
    }
    @RequestMapping(value="/right.action",method=RequestMethod.GET)
    public String right(){
        return "czx/Iright";
    }
}
