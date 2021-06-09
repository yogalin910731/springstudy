package com.fangbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    //写controller就是跳转，如果restcontroller就直接返回字符串了
    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","成功了！");
        request.setAttribute("code",200);
        return "success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                          @RequestAttribute("code") Integer code,
                          HttpServletRequest request
    ) {
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        map.put("reqmsg", msg1);
        map.put("getmsg", msg);
        return map;
    }
}
