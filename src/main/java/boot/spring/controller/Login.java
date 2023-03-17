package boot.spring.controller;

import javax.servlet.http.HttpSession;
import boot.spring.po.Staff;
import com.alibaba.druid.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import boot.spring.po.User;
import boot.spring.service.LoginService;

@Slf4j
@Controller
public class Login {

    @Autowired
    LoginService loginservice;

    /**
     * 登录页面跳转
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 注册页面跳转
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     * 退出登录
     * @param httpSession
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("uid");
        return "login";
    }

    /**
     * 创建用户
     */
    @RequestMapping("/createUser")
    public String createUser(Staff staff) {
        Boolean aBoolean = loginservice.insertUser(staff);
        if (aBoolean){
            return "login";
        }
        return "创建用户失败";
    }

    /**
     * 登录验证
     * @param username
     * @param pwd
     * @param httpSession
     * @return
     */
    @RequestMapping("/loginvalidate")
    public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession) {
        if (StringUtils.isEmpty(username))
            return "login";
        String realpwd = loginservice.getpwdbyname(username);
        if (!StringUtils.isEmpty(realpwd) && pwd.equals(realpwd)) {
            long uid = loginservice.getUidbyname(username);
            httpSession.setAttribute("uid", uid);
            return "chatroom";
        } else
            return "fail";
    }

    /**
     * 获取当前用户
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    @ResponseBody
    public User currentuser(HttpSession httpSession) {
        Long uid = (Long) httpSession.getAttribute("uid");
        String name = loginservice.getnamebyid(uid);
        return new User(uid, name);
    }
}