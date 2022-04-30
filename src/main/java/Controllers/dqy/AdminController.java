package Controllers.dqy;

import Beans.dqy.News;
import Beans.dqy.NewsAndType;
import Services.dqy.impl.NewsServiceImpl;

import Services.dqy.impl.NewsTypeServiceImpl;
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

    @Autowired
    private NewsTypeServiceImpl newsTypeService;

    /**
     * 跳转新闻后台界面，不分类别显示最新的8条新闻
     * @param model
     * @return
     */
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

    /**
     * 按类别显示所有新闻
     * @param model
     * @param typeId
     * @return
     */
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

    /**
     * 跳转编辑新闻界面
     * @param model
     * @param newsId
     * @return
     */
    @RequestMapping("toEditNews")
    public String toEditNews(Model model, int newsId){
        List list = newsTypeService.getAllNewsType();
        NewsAndType news = newsService.getNewsAndTypeById(newsId);
        if(news != null && list != null ){
            model.addAttribute("news", news);
            model.addAttribute("list", list);
            return "dqy/EditNews";
        } else {
            model.addAttribute("errorMsg", "查询不到新闻或新闻类别");
            return "dqy/Error";
        }
    }

    /**
     * 跳转发布新闻界面
     * @return
     */
    @RequestMapping("toAddNews")
    public String toAddNews(Model model) {
        List list = newsTypeService.getAllNewsType();
        model.addAttribute("list", list);
        return "dqy/AddNews";
    }

    /**
     * 发布新闻
     * @param news
     * @param model
     * @return
     */
    @RequestMapping("addNews")
    public String addNews(News news, Model model) {
        boolean result = newsService.addNews(news);
        if(result) {
            model.addAttribute("message", "发布新闻成功");
            return "dqy/Other";
        } else {
            model.addAttribute("errorMsg", "发布新闻失败");
            return "dqy/Error";
        }
    }

    /**
     * 修改新闻
     * @param news
     * @param model
     * @return
     */
    @RequestMapping("editNews")
    public String editNews(News news, Model model) {
        boolean result = newsService.modifyNews(news);
        if( result ) {
            model.addAttribute("message", "修改新闻成功");
            return "dqy/Other";
        } else {
            model.addAttribute("errorMsg", "修改新闻失败");
            return "dqy/Error";
        }
    }

    @RequestMapping("deleteNews")
    public String deleteNews(Model model, int newsId) {
        boolean result = newsService.deleteNews(newsId);
        if( result ) {
            model.addAttribute("message", "删除新闻成功");
            return "dqy/Other";
        } else {
            model.addAttribute("errorMsg", "删除新闻失败");
            return "dqy/Error";
        }
    }
}
