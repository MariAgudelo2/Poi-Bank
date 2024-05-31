<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subasta de Propiedad</title>
    <style>
        body {
            background-color: #F7F7F7;
            font-family: Arial, sans-serif;
        }
       .form-container {
            width: 300px;
            padding: 16px;
            background-color: #FFFFFF;
            border: 1px solid #CCCCCC;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin: 0 auto;
            margin-top: 100px;
            border-radius: 4px;
        }
       .form-container label {
            display: block;
            margin-bottom: 10px;
        }
       .form-container input[type=text],.form-container input[type=number],.form-container input[type=date] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            border: none;
            background: #F7F7F7;
        }
       .form-container input[type=submit] {
            background-color: #3E8E41;
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
       .back-button {
            background-color: #3E8E41;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            margin-top: 20px;
        }
       .back-button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Subasta de Propiedad</h2>
        <form action="subasta" method="post">
            <label for="date-limit">Fecha límite:</label>
            <input type="date" id="date-limit" name="fechaLimite"/>

            <label for="initial-bid">Monto inicial:</label>
            <input type="text" id="initial-bid" name="monto" placeholder="Ingrese el monto inicial"/>

            <label for="mts">Área:</label>
            <input type="text" id="meters" name="mts" placeholder="Ej. 75mts"/>

            <label for="country">País:</label>
            <input type="text" id="country" name="pais" placeholder="Ej. España"/>

            <label for="city">Ciudad:</label>
            <input type="text" id="city" name="ciudad" placeholder="Madrid" />
            <label for="desc">Descripción:</label>
            <input type="text" id="desc" name="desc" placeholder="Subasta Lujoso Apartamento " />
            <button type="submit"  >Enviar</button>
        </form>
        
    </div>
</body>
</html>