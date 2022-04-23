package Controllers.dqy;

import Beans.dqy.News;
import Services.dqy.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsServiceImpl newsService;

    @RequestMapping("/")
    public String News(Model model){
        List list1 = newsService.getNewsByTypeOrderByTime(1);
        List list2 = newsService.getNewsByTypeOrderByTime(2);
        List list3 = newsService.getNewsByTypeOrderByTime(3);
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        return "dqy/News";
    }

    @RequestMapping("showNewsDetail")
    public String showNews(int newsId,Model model){
        News news = newsService.getNewsById(newsId);
        model.addAttribute("news", news);
        return "dqy/ShowNews";
    }

    @RequestMapping("showAllNewsByTypeId")
    public String showAllNews(int TypeId,Model model){
        List list = newsService.getNewsByType(TypeId);
        model.addAttribute("list", list);
        return "dqy/ShowNews";
    }

}
