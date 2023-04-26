package com.example.products.controllers;

import com.example.products.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.products.models.Product;

@Controller
public class ProductControllers {
    private final ProductService productService;

    public ProductControllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String index(Model model){
        model.addAttribute("product", productService.getAllProduct());
        return "product";
    }
    @GetMapping("/product/{id}")
    public String infoProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "product_info";

    }

    @GetMapping("/product/add")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/product/add")
    public String newProduct(@ModelAttribute("product") @Valid Product newProduct, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        productService.newProduct(newProduct);
        return "redirect:/product";

    }

    @GetMapping("/product/edit/{id}")
    public String productEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("edit_product", productService.getProductId(id));
        return "edit_product";
    }

    @PostMapping("/product/edit/{id}")
    public String edit_Product(@ModelAttribute("edit_product") @Valid Product product, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()) {
            return "edit_product";
        }
        productService.productEdit(id,product);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "redirect:/product";
    }

}
