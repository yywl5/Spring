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
    /***
     *  更新验证码
     */
    @RequestMapping("/toLogining")
    public String toLogining(HttpServletRequest request){
        return "yywl5/login";
    }
    @ResponseBody
    @RequestMapping("/toLogin/updateCheck")
    public String updateCheck(HttpServletRequest request){
        return this.createCheck();
    }

    /***
     * 处理登录功能
     */

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

    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request){
        return "yywl5/register";
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
    /***
     * 修改名称
     */
    @ResponseBody
    @RequestMapping(value = "/toLogin/updateUserName",produces = "text/html; charset=utf-8")
    public String updateUserName(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String username = request.getParameter("username");
        System.out.println(username);
        if(username==null){
            request.setAttribute("check",this.createCheck());
            return "yywl5/login";
        }

        if(user==null){
            return  "{\"status\":0,\"data\":\"登录超时，请重新登录!\"}";
        }

        user.setUserLogin(username);
        userService.update(user);
        System.out.println("用户更改:"+user.getUserLogin());
        session.setAttribute("user",userService.queryByuserName(user.getUserName()));
        Cookie cookie = new Cookie("username",user.getUserName());
        cookie.setMaxAge(100);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "{\"status\":true,\"data\":\"修改成功，点击刷新页面\"}";
    }

    /***
     * 注销用户
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toLogin/logoutUser",produces = "text/html; charset=utf-8")
    public String logoutUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println(user.getUserName()+user.getUserId());
        if(user!=null){
            /*userService.deleteById(user.getUserId());*/

            session.removeAttribute("user");
        }
        Cookie []cookies = request.getCookies();
        for(Cookie cookie:cookies){
            if("username".equals(cookie.getName())){
                cookie.setMaxAge(-1);
            }
        }
        System.out.println(user.getUserName()+user.getUserId()+"TEST");
        return "{\"status\":true,\"data\":\"/toLogin\"}";
    }

    /****
     * 注册用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/toLogin/register",produces = "text/html; charset=utf-8")
    public String register(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String pw = request.getParameter("userPassword");
        String userLogin = request.getParameter("userLogin");
        String check = request.getParameter("check");
        if(check==null){
            request.setAttribute("check",this.createCheck());
            return "yywl5/register";
        }
        if(!check.equals(this.check)){
            return "{\"status\":0,\"data\":\"验证码错误!\"}";
        }
        User user = userService.queryByuserName(userName);

        if(user!=null){
            return "{\"status\":1,\"data\":\"该用户已存在，去登录!\"}";
        }
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setUserPassword(pw);
        newUser.setUserLogin(userLogin);

        userService.insert(newUser);

        HttpSession session = request.getSession();
        session.setAttribute("user",userService.queryByuserName(userName));
        Cookie cookie = new Cookie("username",newUser.getUserName());
        cookie.setMaxAge(100);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "yywl5/login";
    }

    /***
     * 修改密码
     */

    @ResponseBody
    @RequestMapping(value = "/toLogin/updatePw",produces = "text/html; charset=utf-8")
    public String updatePw(HttpServletRequest request,HttpServletResponse response){
        String pw = request.getParameter("userPassword");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        user.setUserPassword(pw);
        userService.update(user);
        session.setAttribute("user",userService.queryByuserName(user.getUserName()));
        Cookie cookie = new Cookie("username",user.getUserName());
        cookie.setMaxAge(100);
        cookie.setPath("/");
        response.addCookie(cookie);

        return "{\"status\":true,\"data\":\"修改成功，点击前往主页面\"}";
    }
}
