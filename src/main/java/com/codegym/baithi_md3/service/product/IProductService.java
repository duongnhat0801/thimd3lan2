package com.codegym.baithi_md3.service.product;

import com.codegym.baithi_md3.models.Product;

import java.sql.Date;
import java.util.List;

public interface IProductService {
    List<Product> selectAll();

    void createProduct(Product product);

    List<Product> getTopSellingProducts(int topCount);

    List<Product> getProductsOrderedBetween(Date startDate, Date endDate);
}
