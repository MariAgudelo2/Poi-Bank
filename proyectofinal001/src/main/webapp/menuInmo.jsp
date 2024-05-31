<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú de Inmobiliaria</title>
    <style>
        body {
            background-color: #F7F7F7;
            font-family: Arial, sans-serif;
        }
       .menu-container {
            width: 300px;
            padding: 16px;
            background-color: #FFFFFF;
            border: 1px solid #CCCCCC;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 0 auto;
            margin-top: 100px;
            border-radius: 4px;
        }
       .menu-container button {
            background-color: #3E8E41;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
       .menu-container button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <h2>Menú de Inmobiliaria</h2>
        <button onclick="location.href='propiedad.jsp'">Publicar Venta</button>
        <button onclick="location.href='subasta.jsp'">Publicar Subasta</button>
    </div>
</body>
</html>