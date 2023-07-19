package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        return "Get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get / post / put / delete
    public String hi(){
        return "hi";
    }

    // http://localhost:8080/api/get/path-variable/{spring-boot}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable : " + name);
        return "Jinwon " + name;
    }

    @GetMapping("/path-variable2/{name2}")
    public String pathVariable2(@PathVariable(name = "name2") String pathName){
        System.out.println("PathVariable : " + pathName);
        return "Jinwon " + pathName;
    }


    // 구글에 intellij를 검색하였을 때 주소
    // /search?q=intellij
    // &sxsrf=AB5stBjJQMfR7PdWgn8feYuDPZTkYoEp5A%3A1689744584903&source=hp
    // &ei=yHS3ZJCJNY7_wAOthYvgDQ
    // &iflsig=AD69kcEAAAAAZLeC2MSNZXnIOXtjLPxocXrUldXUh3WV
    // &oq=in
    // &gs_lp=Egdnd3Mtd2l6IgJpbioCCAAyBxAjGIoFGCcyBxAjGIoFGCcyBxAjGIoFGCcyCxAAGIAEGLEDGIMBMgsQABiABBixAxiDATILEAAYgAQYsQMYgwEyCxAAGIAEGLEDGIMBMgsQABiABBixAxiDATILEAAYgAQYsQMYgwEyDhAuGIAEGLEDGMcBGNEDSPQPUABYlQdwAXgAkAEAmAF9oAHKAqoBAzEuMrgBA8gBAPgBAagCCsICBBAjGCfCAhEQLhiABBixAxiDARjHARjRA8ICCxAuGIAEGLEDGIMBwgIHECMY6gIYJ8ICBxAuGOoCGCfCAggQABiABBixAw
    // &sclient=gws-wiz

    // http://localhost:8080/api/get/query-param?user=steve&email=steve@gmail.com&age=30

    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    // query-param03 많이쓰는 방법
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
