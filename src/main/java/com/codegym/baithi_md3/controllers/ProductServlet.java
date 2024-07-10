package com.codegym.baithi_md3.controllers;
import com.codegym.baithi_md3.models.Product;
import com.codegym.baithi_md3.service.product.IProductService;
import com.codegym.baithi_md3.service.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {
    IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                showListProduct(req, resp);
                break;
            case "/create":
                showFormCreateProduct(req, resp);
                break;
            case "/top":
                showTopSellingProducts(req, resp);
                break;
            case "/order":
                showOrderedProducts(req, resp);
                break;
        }
    }

    private void showOrderedProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDateStr = req.getParameter("start_date");
        String endDateStr = req.getParameter("end_date");
        java.sql.Date startDate = java.sql.Date.valueOf(startDateStr);
        java.sql.Date endDate = java.sql.Date.valueOf(endDateStr);
        List<Product> orderedProducts;
        orderedProducts = productService.getProductsOrderedBetween(startDate, endDate);
        req.setAttribute("products", orderedProducts);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }


    private void showTopSellingProducts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topCountStr = req.getParameter("topProduct");
        int topCount = Integer.parseInt(topCountStr);
        List<Product> topProducts;
        topProducts = productService.getTopSellingProducts(topCount);
        req.setAttribute("products", topProducts);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }


    private void showFormCreateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
    }

    private void showListProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                createProduct(req, resp);
                break;
        }

    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        double discount = Double.parseDouble(req.getParameter("discount"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setStock(stock);
        productService.createProduct(product);
        resp.sendRedirect("/products/list");
    }
}
