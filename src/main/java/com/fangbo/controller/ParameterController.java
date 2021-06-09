package com.fangbo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     @PathVariable Map<String,Object> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,Object> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,Object> params
                                    ){
        Map<String,Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("username",username);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);

        return map;
    }

    @PostMapping("/save")
    public Map<String,Object> postMetod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;

    }
  //  /car/sell;low=34;brand=byd,33,442
  //stringboot默认禁用矩阵变量，需要手动开启
    //矩阵变量必须要url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsell(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("path") String path
                       ) {

        Map<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

}
