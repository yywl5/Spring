package Controllers.dqy;

import Beans.dqy.NewsAndType;
import Services.dqy.impl.NewsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping("toAdminNews")
    public String toAdminNews(Model model){
        List list = newsService.getNewsLimitAndOrder();
        if(list != null){
            model.addAttribute("news", list);
            return "dqy/AdminNews";
        } else {
            model.addAttribute("errorMsg", "查询不到新闻");
            return "dqy/Error";
        }
    }

    @RequestMapping("toAdminNewsByType")
    public String toAdminNewsByType(Model model, int typeId){
        List list = newsService.getNewsByType(typeId);
        if(list != null){
            model.addAttribute("news", list);
            return "dqy/AdminNews";
        } else {
            model.addAttribute("errorMsg", "查询不到新闻");
            return "dqy/Error";
        }
    }

    @RequestMapping("toEditNews")
    public String toEditNews(Model model, int newsId){
        NewsAndType news = newsService.getNewsAndTypeById(newsId);
        if(news != null){
            model.addAttribute("news", news);
            return "dqy/EditNews";
        } else {
            model.addAttribute("errorMsg", "查询不到新闻");
            return "dqy/Error";
        }
    }
}
