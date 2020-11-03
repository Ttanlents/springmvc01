package com.yjf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.media.jfxmedia.Media;
import com.yjf.entity.Pojo;
import com.yjf.entity.User;
import com.yjf.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 余俊锋
 * @date 2020/10/13 10:41
 * @Description
 */
@Controller
@SessionAttributes(names = "sessionKey",types = {User.class})
public class HellowController {

    @RequestMapping(value = "/{name}/{password}/hello.form",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, @PathVariable("name") String name,
                        @PathVariable("password") String password){
        System.out.println(name);
        System.out.println(password);
        OutputStream os = null;
        try {
             os = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
           os.write(name.getBytes("UTF-8"));
           os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/demo.form",method = RequestMethod.POST)
    public void getArr(User user){
        System.out.println(user);
    }

    @RequestMapping(value = "/demo2.form",method = RequestMethod.POST)
    public void getArr(Pojo map){
        System.out.println(map);
    }

    @RequestMapping("/demo3.form")
    public void demo3(@CookieValue("JSESSIONID") String sessionId){
        System.out.println(sessionId);
    }

    @RequestMapping("/demo4.form")
    public void demo4(@RequestHeader("Content-Type") String value){
        System.out.println(value);
    }

    @RequestMapping("/demo5.form")
    public String demo5(Model model, Map<String,String> map){
        User user = new User();
        user.setName("马云");
        model.addAttribute("user",user);
        map.put("abc","abc");
        return "/hello.jsp";
    }

    @RequestMapping("/demo6.form")
    public void demo6(@SessionAttribute("user") User user){
        System.out.println(user);
    }

    @RequestMapping(value = "/demo7.form",method = RequestMethod.POST)
    public void demo7( User user){
        System.out.println(user);
    }

    @RequestMapping(value = "/demo8",method = RequestMethod.GET)
    public String demo8( ){

        return "hello";
    }

    @RequestMapping(path = "/demo9",produces = "application/json;charset=utf8")
    //表示对象以json对象写出到前端 并修改contentType:'application/json;charset=utf8'
    //默认`text/plain;charset=ISO-8859-1`
    @ResponseBody
    public String demo9(User user,@RequestHeader("Content-Type") String value){
        System.out.println(value);
        System.out.println(user);
        Map<String,Object> map=new HashMap<>();
        map.put("code","200");
        map.put("user",user);
        String json = JsonUtils.pojoToJson(map);
        // new ObjectMapper().readValue("",User.class);
        //new ObjectMapper().writeValueAsString(map)
        return json;
    }

    /**
     *@Description TODO:上传单个文件
     *@author 余俊锋
     *@date 2020/10/14 19:52
     *@params file
     *@return java.lang.String
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String path = this.getClass().getResource("/").getPath()+"img";
        System.out.println(path);
        String filePath=path+"/"+originalFilename;
        File file1=new File(filePath);
        try {
            BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
            FileOutputStream os = new FileOutputStream(file1);
            byte[] flush=new byte[1024*8];
            int len;
            while ((len=bis.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
            os.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public String uploadFiles(MultipartFile[] files){
        for (int i = 0; i < files.length; i++) {
            String originalFilename = files[i].getOriginalFilename();
            String path = this.getClass().getResource("/").getPath()+"img";
            String filePath=path+"/"+originalFilename;
            File file=new File(filePath);
            try {
                files[i].transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
