<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="css/divs.css" rel="stylesheet" />
    <title>Poi-Bank</title>
  </head>

  <body>
    <script>
      var aciertos = 0;

      function main(divAbrir, divCerrar, idInput) {
        confirmarRespuesta(idInput);
        mostrar(divAbrir, divCerrar);
      }
      function final(divCerrar, idInput) {
        confirmarRespuesta(idInput);
        mostrar(permitirDenegar(), divCerrar);
      }
      function mostrar(divAbrir, divCerrar) {
        document.getElementById(divAbrir).style.display = "block";
        document.getElementById(divCerrar).style.display = "none";
      }
      function confirmarRespuesta(idInput) {
        const respuesta = obtenerValorInput(idInput);

        switch (idInput) {
          case "rBlanco":
            if (
              respuesta == "blanco" ||
              respuesta == "Blanco" ||
              respuesta == "BLANCO"
            ) {
              aciertos += 1;
            }
            break;

          case "rJuan":
            if (
              respuesta == "juan" ||
              respuesta == "Juan" ||
              respuesta == "JUAN"
            ) {
              aciertos += 1;
            }
            break;

          case "rN":
            if (respuesta == "n" || respuesta == "N") {
              aciertos += 1;
            }
            break;
        }
      }
      function obtenerValorInput(idInput) {
        const inputTexto = document.getElementById(idInput);
        const valorInput = inputTexto.value;
        return valorInput;
      }
      function permitirDenegar() {
        if (aciertos >= 2) {
          return "exitoso";
        } else {
          return "fallido";
        }
      }
    </script>
    <div id="alerta">
      <div>
        <img src="assets/iconBlack.png" />
      </div>
      <h2>¡Alerta! Superas el valor permitido para retirar</h2>
      <p>
        Te haremos unas preguntas para asegurarnos de que tu dinero no está en
        peligro:
      </p>
      <button onclick="mostrar('pregunta1', 'alerta')">Ok!</button>
    </div>
    <div id="pregunta1">
      <label
        >¿De qué color es el caballo blanco en el que iba Simón Bolívar?</label
      >
      <input id="rBlanco" />
      <button onclick="main('pregunta2','pregunta1','rBlanco')">
        Siguiente
      </button>
    </div>
    <div id="pregunta2">
      <label
        >El padre de Juan tiene 4 hijos: Lucas, Sandra, Ana y… ¿quién es el
        cuarto?</label
      >
      <input id="rJuan" />
      <button onclick="main('pregunta3','pregunta2','rJuan')">Siguiente</button>
    </div>
    <div id="pregunta3">
      <label
        >¿Qué letra pasa de ser una consonante a una vocal con tan solo darle la
        vuelta?</label
      >
      <input id="rN" />
      <button onclick="final('pregunta3','rN')">Finalizar</button>
    </div>
    <form action="confirmarRetiro" method="post">
      <div id="exitoso">
        <label>Hemos confirmado que eres tú :D</label>
        <button name="confirmar" type="submit">Continuar</button>
      </div>
    </form>
    <div id="fallido">
      <label>¿Eres tú? No estamos seguros... inténtalo de nuevo en 24h</label>
      <button type="submit" href="banco.jsp">Volver</button>
    </div>
  </body>
  <style>
    body {
      text-align: center;
      display: flex;
      font-family: Arial, sans-serif;
      color: #322d2c;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    body img {
      height: 120px;
    }
  </style>
</html>
