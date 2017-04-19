package twindy.org.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：
 *
 * @author twindy
 * @time 2017-04-19
 */
@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping(value = {"/", "/home"}, method = {RequestMethod.GET}, produces = "application/json")
    public JSONObject doAction() {
        JSONObject json = new JSONObject();
        json.put("a", "1");
        json.put("b", "2");
        json.put("c", "3");
        json.put("d", "4");
        System.out.print(json);
        return json;
    }
}
