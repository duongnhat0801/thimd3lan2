package com.codegym.baithi_md3.repositories.product;

import com.codegym.baithi_md3.models.Product;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IProductRepo {
    List<Product> selectAll() throws SQLException;

    void createProduct(Product product) throws SQLException;

    List<Product> getTopSellingProducts(int topCount) throws SQLException;

    List<Product> getProductsOrderedBetween(Date startDate, Date endDate) throws SQLException;
}
