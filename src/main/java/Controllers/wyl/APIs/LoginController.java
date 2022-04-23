package Controllers.wyl.APIs;

import Beans.potatob6.User;
import Services.yywl5.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 星包客
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    private String check;
    //生成验证码
    private String createCheck(){
        String chars = "0123456789ABCDEFJHIJKLMPOPQRSTUVWXYZ";
        char[] rands = new char[4];
        for(int i=0;i<4;i++){
            int rand = (int)(Math.random()*36);
            rands[i]=chars.charAt(rand);
        }
        this.check = new String(rands);
        return this.check;
    }

    //页面初始化
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request){
        request.setAttribute("check",this.createCheck());
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            request.setAttribute("userName",user.getUserName());
        }
        return "yywl5/login";
    }

    //更新验证码
    @ResponseBody
    @RequestMapping("/toLogin/updateCheck")
    public String updateCheck(HttpServletRequest request){
        return this.createCheck();
    }

    //处理登录功能
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String check = request.getParameter("check");
        if(check==null){
            request.setAttribute("check",this.createCheck());
            return "yywl5/login";
        }

        User user = userService.queryByuserName(userName);

        if(this.check.equals(check)&&user!=null&&userPassword.equals(user.getUserPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            Cookie cookie = new Cookie("username",user.getUserName());
            cookie.setMaxAge(100);
            cookie.setPath("/");
            response.addCookie(cookie);

            request.setAttribute("user",user);
            return "yywl5/LoginMainPage";
        }

        if(!this.check.equals(check)){
            request.setAttribute("msg","验证码错误!");
        }else if(user==null){
            request.setAttribute("err_user","用户不存在!");
        }else if(!userPassword.equals(user.getUserPassword())){
            request.setAttribute("err_pw","密码错误!");
        }
        request.setAttribute("check",this.createCheck());
        request.setAttribute("userName",userName);
        request.setAttribute("userPassword",userPassword);

        return "yywl5/login";
    }


    @RequestMapping("/freeLogin")
    public String main(HttpServletRequest request){
        Cookie []cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("username".equals(cookie.getName())){
                HttpSession session = request.getSession();
                User user = (User)session.getAttribute("user");
                request.setAttribute("user",user);
                return "yywl5/LoginMainPage";
            }
        }
        return "yywl5/login";
    }
}
