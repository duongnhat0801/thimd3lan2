<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Sản Phẩm</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="bg-body-tertiary">
<div class="container">
    <div class="p-3 bg-white shadow-sm rounded">
        <div class="d-flex align-items-center justify-content-between">
            <a href="/products/list" class="text-decoration-none"><h1 class="text-dark">Danh Sách Sản Phẩm</h1></a>
            <a class="btn btn-outline-success" href="/products/create">Thêm mới Sản Phẩm <i class="fa-solid fa-plus"></i></a>
        </div>
        <form action="/products/top" method="get">
            <label for="topProduct">Danh sách top:</label>
            <select name="topProduct" id="topProduct" >
                <option value="3">Top 3</option>
                <option value="5">Top 5</option>
                <option value="10">Top 10</option>
            </select>
            <button type="submit" class="btn btn-primary">Xem</button>
        </form>
        <form action="/products/orders" method="get">
            <label for="start_date">Từ ngày:</label>
            <input type="date" id="start_date" name="start_date">

            <label for="end_date">Đến ngày:</label>
            <input type="date" id="end_date" name="end_date">

            <button type="submit" class="btn btn-primary">Xem</button>
        </form>

        <table class="table table-hover table-bordered">
            <thead class="thead-dark">
            <tr>
                <th class="bg-secondary text-white">STT</th>
                <th class="bg-secondary text-white">Name</th>
                <th class="bg-secondary text-white">Price</th>
                <th class="bg-secondary text-white">Discount</th>
                <th class="bg-secondary text-white">Stock</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}" varStatus="stt">
                <tr>
                    <td>${stt.index + 1}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.discount}</td>
                    <td>${product.stock}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
