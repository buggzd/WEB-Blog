package com.junto.blog2.web;

import com.junto.blog2.NotFoundException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){

        return  "blog.html";
    }
}
