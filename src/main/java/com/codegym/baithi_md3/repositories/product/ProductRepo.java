package com.codegym.baithi_md3.repositories.product;

import com.codegym.baithi_md3.database.DBConnection;
import com.codegym.baithi_md3.models.Product;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class ProductRepo implements IProductRepo {
    @Override
    public List<Product> selectAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select id, name, price, discount, stock from products";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setStock(rs.getInt("stock"));
            products.add(product);
        }
        return products;
    }

    @Override
    public void createProduct(Product product) throws SQLException {
        Connection connection = new DBConnection().getConnection();
        String sql = "insert into products (name, price, discount, stock) values (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getName());
        ps.setDouble(2, product.getPrice());
        ps.setDouble(3, product.getDiscount());
        ps.setInt(4, product.getStock());
        ps.executeUpdate();
    }


    @Override
    public List<Product> getTopSellingProducts(int topCount) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select p.id, p.name, p.price, p.discount, p.stock, count(o.products_id) as order_count " +
                "from productsp " +
                "left join orders o on p.id = o.product_id " +
                "group by p.id " +
                "order by order_count desc " +
                "limit ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, topCount);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setStock(rs.getInt("stock"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getProductsOrderedBetween(Date startDate, Date endDate) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select distinct p.id, p.name, p.price, p.discount, p.stock " +
                "from products p " +
                "join orders o on p.id = o.product_id " +
                "where o.order_date between ? and ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, startDate);
        ps.setDate(2, endDate);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setDiscount(rs.getDouble("discount"));
            product.setStock(rs.getInt("stock"));
            products.add(product);
        }
        return products;
    }
}


