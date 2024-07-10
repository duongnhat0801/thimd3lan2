<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .form-container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-top: 50px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<div class="container">
    <div class="form-container">
        <h1 class="text-center">Tạo Sản Phẩm</h1>
        <form action="/products/create" method="post">
            <div class="form-group">
                <label for="name">Name :</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="price">Price :</label>
                <input type="text" class="form-control" id="price" name="price" required min="101">
            </div>
            <div class="form-group">
                <label for="discount">Discount:</label>
                <select class="form-control" id="discount" name="discount">
                    <option value="0.05">5%</option>
                    <option value="0.10">10%</option>
                    <option value="0.15">15%</option>
                    <option value="0.20">20%</option>
                </select>
            </div>

            <div class="form-group">
                <label for="stock">Stock :</label>
                <input type="text" class="form-control" id="stock" name="stock" required min="11">
            </div>
            <div class="mt-2">
                <button type="submit" class="btn btn-outline-primary">Tạo</button>
                <a href="/products/list" class="btn btn-outline-danger">Huỷ</a>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
