package twindy.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 *
 * @author twindy
 * @time 2017-04-19
 */
@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping(value = {"/aa"})
    public String doAction() {
        return "欢迎光临";
    }

    @RequestMapping(value = {"/home"})
    public String homePage(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }

}
