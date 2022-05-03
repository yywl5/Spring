package Controllers.czx;

import Beans.czx.ICategory;
import Beans.czx.INews;
import Others.czx.IPageBean;
import Services.czx.ICategoryService;
import Services.czx.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class INewsController {
    //依赖注入
    @Autowired
    private INewsService newsService;
    @Autowired
    private ICategoryService categoryService;
    //查询文章分页
    @RequestMapping(value="/findNewsByPage.action")
    public String findNewsByPage(String keywords, Integer newsListCategoryId, @RequestParam(defaultValue="1")Integer currentPage, @RequestParam(defaultValue="10")Integer pageSize, Model model){
        // 获取角色列表
        List<ICategory> categoryList = categoryService.findCategoryList();
        model.addAttribute("categoryList", categoryList);
        // 获取用户PageBean实例
        IPageBean<INews> pb=newsService.findNewsByPage(keywords,newsListCategoryId,currentPage,pageSize);
        model.addAttribute("pb", pb);
        model.addAttribute("keywords", keywords);
        model.addAttribute("newsListCategoryId", newsListCategoryId);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", pageSize);
        return "czx/Inews_list";
    }
    //设置文章的状态（publishStatus：1：发布；2：撤稿）
    @RequestMapping(value = "/setNewsPublishStatus.action")
    @ResponseBody
    public INews setNewsPublishStatus(@RequestBody INews news, Model model) {
        int rows = newsService.setNewsPublishStatus(news);
        if (rows>0) {
            return news;
        }else{
            news.setNewsId(0);
            return news;
        }
    }
    //转向添加文章
    @RequestMapping(value = "/toAddNews.action")
    public String toAddNews(Model model) {
        // 获取文章类别列表
        List<ICategory> categoryList = categoryService.findCategoryList();
        model.addAttribute("categoryList", categoryList);
        return "czx/Iadd_news";
    }
    // 添加文章
    @RequestMapping(value = "/addNews.action", method = RequestMethod.POST)
    public String addNews(INews news, Model model) {
        Date date = new Date();
        news.setPublishTime(date);
        news.setPublishStatus("1");// 默认设置文章为已发布状态
        int rows = newsService.addNews(news);
        // 添加成功，转向用户列表页面
        if (rows > 0) {
            return "redirect:findNewsByPage.action";
        } else {
            // 获取文章类别列表
            List<ICategory> categoryList = categoryService.findCategoryList();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("news", news);
            // 添加失败，转回添加用户页面
            return "czx/Iadd_news";
        }
    }
    // 修改文章
    @RequestMapping(value = "/editNews.action", method = RequestMethod.POST)
    public String editNews(INews news, Model model) {
        Date date = new Date();
        news.setPublishTime(date);
        news.setPublishStatus("1");// 默认设置文章为已发布状态
        int rows = newsService.editNews(news);
        // 添加成功，转向用户列表页面
        if (rows > 0) {
            return "redirect:findNewsByPage.action";
        } else {
            // 获取文章类别列表
            List<ICategory> categoryList = categoryService.findCategoryList();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("news", news);
            // 添加失败，转回添加用户页面
            return "czx/Iedit_news";
        }
    }
    // 转向修改文章页面
    @RequestMapping(value = "/toEditNews.action")
    public String toEditNews(Integer newsId, Model model) {
        INews news = newsService.getNewsByNewsId(newsId);
        if (news != null) {
            model.addAttribute("news", news);
            // 获取文章类别列表
            List<ICategory> categoryList = categoryService.findCategoryList();
            model.addAttribute("categoryList", categoryList);
        }
        return "czx/Iedit_news";
    }
    //删除文章
    @RequestMapping(value = "/delNews.action")
    @ResponseBody
    public INews delNews(@RequestBody INews news, Model model) {
        int rows = newsService.delNews(news.getNewsId());
        if (rows>0) {
            return news;
        }else{
            news.setNewsId(0);
            return news;
        }
    }
    //根据文章类别ID查询文章分页（用于前台首页）
    @RequestMapping(value = "/index.action")
    public String index(HttpServletRequest request, HttpServletResponse response, String keywords, Integer newsListCategoryId, @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize, Model model) throws ServletException, IOException {
        // 获取用户PageBean实例
        IPageBean<INews> pb1 = newsService.findNewsByPage(keywords, 1, currentPage, pageSize);
        model.addAttribute("pb1", pb1);
        IPageBean<INews> pb2 = newsService.findNewsByPage(keywords, 2, currentPage, pageSize);
        model.addAttribute("pb2", pb2);
        return "czx/Ifirst";
    }
    //根据文章类别ID查询文章分页（用于前台文章列表页）
    @RequestMapping(value = "/findNewsByCategoryIdPage.action")
    public String findNewsByCategoryIdPage(HttpServletRequest request, HttpServletResponse response, String keywords, Integer newsListCategoryId,	@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "1") Integer pageSize,	Model model){
        // 获取角色列表
        ICategory category = categoryService.findCategoryById(newsListCategoryId);
        model.addAttribute("category", category);
        // 获取用户PageBean实例
        IPageBean<INews> pb = newsService.findNewsByPage(keywords, newsListCategoryId, currentPage, pageSize);
        model.addAttribute("pb", pb);
        model.addAttribute("newsListCategoryId", newsListCategoryId);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageSize", pageSize);
        return "czx/Ilist";
    }
    //查询文章（用于前台文章内容页）
    @RequestMapping(value = "/findFrontNewsByNewsId.action")
    public String findFrontNewsByNewsId(Integer newsId,Model model) {
        INews news = newsService.getNewsByNewsId(newsId);
        if (news != null) {
            model.addAttribute("news", news);
        }
        return "czx/Idetail";
    }
}