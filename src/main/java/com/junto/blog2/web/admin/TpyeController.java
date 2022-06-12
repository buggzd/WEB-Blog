package com.junto.blog2.web.admin;

import com.junto.blog2.po.Type;
import com.junto.blog2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
@RequestMapping("/admin")
public class TpyeController {
    @Autowired
    private TypeService typeService;
    @GetMapping("/types")
    public String types(@PageableDefault(size =5,sort={"id"},direction = Sort.Direction.DESC)Pageable pageable, Model model){

        model.addAttribute("page",typeService.ListType(pageable));

        return "/admin/types";
    }
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "/admin/types-creat";
    }
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("type",typeService.getType(id));
        return "/admin/types-creat";
    }
    @PostMapping("/types")
    public String post(Type type,RedirectAttributes attributes){
//        if(result.hasErrors()){
//            return "/admin/types-creat";
//        }
        Type t=typeService.saveType(type);
        if(t==null){
            attributes.addFlashAttribute("message","添加失败");
        }else {
            attributes.addFlashAttribute("message","添加成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editpost(Type type,RedirectAttributes attributes,@PathVariable Long id){
//        if(result.hasErrors()){
//            return "/admin/types-creat";
//        }
        Type t=typeService.updateType(id,type);
        if(t==null){
            attributes.addFlashAttribute("message","修改失败");
        }else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/types";
    }
    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
//        if(result.hasErrors()){
//            return "/admin/types-creat";
//        }
        typeService.deletType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/types";
    }
}
