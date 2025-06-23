package com.nvminh162.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nvminh162.laptopshop.domain.Product;
import com.nvminh162.laptopshop.service.ProductService;
import com.nvminh162.laptopshop.service.UploadService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {
    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getDashboard(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "/admin/product/show"; 
    }

    @GetMapping("/admin/product/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "/admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProductPage(
        Model model,
        @ModelAttribute("newProduct") Product product,
        @RequestParam("productFile") MultipartFile file
    ) {
        String productImgName = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(productImgName);
        this.productService.saveAProduct(product);
        return "redirect:/admin/product";
    }
    
}
