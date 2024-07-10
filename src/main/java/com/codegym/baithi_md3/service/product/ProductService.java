package com.codegym.baithi_md3.service.product;

import com.codegym.baithi_md3.models.Product;
import com.codegym.baithi_md3.repositories.product.IProductRepo;
import com.codegym.baithi_md3.repositories.product.ProductRepo;

import java.sql.Date;
import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    IProductRepo productRepo = new ProductRepo();
    @Override
    public List<Product> selectAll() {
        try {
            return  productRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createProduct(Product product) {
        try {
            productRepo.createProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getTopSellingProducts(int topCount) {
        try {
            return productRepo.getTopSellingProducts(topCount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductsOrderedBetween(Date startDate, Date endDate) {
        try {
            return productRepo.getProductsOrderedBetween(startDate, endDate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }}
