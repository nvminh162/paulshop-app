package com.nvminh162.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.nvminh162.laptopshop.domain.Product;
import com.nvminh162.laptopshop.service.ProductService;
import com.nvminh162.laptopshop.service.UploadService;

import jakarta.validation.Valid;
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

    // Create
    @GetMapping("/admin/product/create")
    public String getCreatePage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "/admin/product/create";
    }    @PostMapping("/admin/product/create")
    public String createPage(
            Model model,
            @ModelAttribute("newProduct") @Valid Product product,
            BindingResult newProductBindingResult,
            @RequestParam("productFile") MultipartFile file) {
        
        // validate
        if (newProductBindingResult.hasErrors()) {
            List<FieldError> errors = newProductBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println("Validation Error: " + error.getField() + " - " + error.getDefaultMessage());
            }
            return "admin/product/create";
        }

        String productImgName = this.uploadService.handleSaveUploadFile(file, "product");
        product.setImage(productImgName);
        this.productService.saveAProduct(product);
        return "redirect:/admin/product";
    }

    // Delete
    @GetMapping("/admin/product/delete/{id}")
    public String getDeletePage(Model model, @PathVariable long id) {
        model.addAttribute("deleteProduct", new Product());
        model.addAttribute("id", id);
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String deletePage(Model model, @ModelAttribute("deleteProduct") Product product) {
        this.productService.deleteAProduct(product.getId());
        return "redirect:/admin/product";
    }

    // Detail
    @GetMapping("/admin/product/{id}")
    public String getDetailPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id).get();
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "admin/product/detail";
    }

    // Update
    @GetMapping("/admin/product/update/{id}")
    public String getUpdatePage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id).get();
        model.addAttribute("updateProduct", product);
        model.addAttribute("id", id);
        return "admin/product/update";
    }    @PostMapping("/admin/product/update")
    public String postMethodName(
            Model model,
            @ModelAttribute("updateProduct") @Valid Product product,
            BindingResult updateProductBindingResult,
            @RequestParam("productFile") MultipartFile file) {
        
        if (updateProductBindingResult.hasErrors()) {
            List<FieldError> errors = updateProductBindingResult.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println("Validation Error: " + error.getField() + " - " + error.getDefaultMessage());
            }
            model.addAttribute("id", product.getId());
            return "admin/product/update";
        }

        Product pr = this.productService.getProductById(product.getId()).get();

        if (pr != null) {
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                pr.setImage(img);
            }
        }

        pr.setName(product.getName());
        pr.setPrice(product.getPrice());
        pr.setDetailDesc(product.getDetailDesc());
        pr.setShortDesc(product.getShortDesc());
        pr.setQuantity(product.getQuantity());
        pr.setFactory(product.getFactory());
        pr.setTarget(product.getTarget());

        this.productService.saveAProduct(pr);

        return "redirect:/admin/product";
    }

}
