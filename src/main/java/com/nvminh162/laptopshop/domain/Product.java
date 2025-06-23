package com.nvminh162.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "products")
public class Product {    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @NotNull
    @Size(min = 1, message = "Tên sản phẩm không được để trống")
    private String name;
    
    @DecimalMin(value = "0", message = "Giá sản phẩm phải lớn hơn 0")
    private double price;
    
    private String image;
    
    @Size(min = 1, message = "Mô tả chi tiết không được để trống")
    private String detailDesc;
    
    @Size(min = 1, message = "Mô tả ngắn không được để trống")  
    private String shortDesc;
    
    @Min(value = 1, message = "Số lượng phải lớn hơn 0")
    private long quantity;
    
    private long sold;
    
    @NotNull
    @Size(min = 1, message = "Nhà sản xuất không được để trống")
    private String factory;
    
    @NotNull
    @Size(min = 1, message = "Đối tượng sử dụng không được để trống")
    private String target;
}
