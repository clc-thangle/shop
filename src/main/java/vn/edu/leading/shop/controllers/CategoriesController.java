package vn.edu.leading.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.leading.shop.models.CategoriesModel;
import vn.edu.leading.shop.services.CategoriesService;


import javax.validation.Valid;

@Controller
public class CategoriesController {
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public String list(Model model)
    {
        model.addAttribute("categories",categoriesService.findAll());
        return "categories/list";
    }

    @GetMapping("categories/search")
    public String search(@RequestParam("term") String term,Model model)
    {
        if(StringUtils.isEmpty(term))
        {
            return "redirect:/categories";
        }
        model.addAttribute("categories",categoriesService.search(term));
        return "categories/list";
    }

    @GetMapping("/categories/add")
    public String add(Model model)
    {
        model.addAttribute("categoriesModel",new CategoriesModel());
        return "categories/form";
    }

    @GetMapping("/categories/{id}/edit")
    public String edit(@PathVariable("id") Long id,Model model)
    {
        model.addAttribute("categoriesModel",categoriesService.findByAId(id));
        return "categories/form";
    }

    @PostMapping("/categories/save")
    public String save(@Valid CategoriesModel category, BindingResult result, RedirectAttributes redirect)
    {
        if(result.hasErrors())
        {
            return "categories/form";
        }
        categoriesService.save(category);
        redirect.addFlashAttribute("successMessage","Saved categories successfully!");
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/delete")
    public String detele(@PathVariable Long id, RedirectAttributes redirect)
    {
        if (categoriesService.delete(id))
        {
            redirect.addFlashAttribute("successMessage","Delete categories successfully!");
            return "redirect:/categories";
        }
        else
        {
            redirect.addFlashAttribute("successMessage","Not found!!!");
            return "redirect:/categories";
        }
    }
}
