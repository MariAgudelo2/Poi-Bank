<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inmobiliaria</title>
    <style>
        body {
            background-color: #d1d0d0;
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 300px;
            padding: 16px;
            background-color: #6e5740;
            color: white;
            margin: 0 auto;
            margin-top: 100px;
            border-radius: 4px;
        }
        .form-container input[type=text], .form-container input[type=number] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #f1f1f1;
        }
        .form-container input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
        .form-container input[type=submit]:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <form action="/submit-property" method="post">
            <label for="sqm">Metros cuadrados:</label>
            <input type="number" id="sqm" name="sqm" placeholder="Ej. 100">

            <label for="price">Precio:</label>
            <input type="number" id="price" name="price" placeholder="Ej. 200000">

            <label for="country">País:</label>
            <input type="text" id="country" name="country" placeholder="Ej. España">

            <label for="city">Ciudad:</label>
            <input type="text" id="city" name="city" placeholder="Ej. Madrid">

            <input type="submit" value="Guardar información">
        </form>
    </div>
</body>
</html>