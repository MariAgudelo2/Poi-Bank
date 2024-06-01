<%@ page contentType="text/html; charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Poi-Bank</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/icon.PNG" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
  </head>

  <body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container px-5">
        <a class="navbar-brand" href="#!">Poi Bank</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="banco.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="crearCuenta.jsp"
                >Abre una cuenta nueva</a
              >
            </li>
            <li class="nav-item">
              <form class="tuCuentaBtn" action="tuCuenta" method="Get">
                <button type="submit" class="nav-link" href="tuCuenta.jsp">
                  Tu cuenta
                </button>
              </form>
            </li>
            <li class="nav-item">
              <a
                class="nav-link active"
                aria-current="page"
                href="sobreNosotros.jsp"
                >Sobre nosotros</a
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Features section-->
    <section class="cuerpo">
      <div class="centrar">
        <img src="assets/iconBlack.png" />
      </div>
      <br />
      <div class="centrar">
        <h1>Somos Poi-Bank*</h1>
        <h3>Más que un banco, somos tu hogar</h3>
      </div>

      <br />
      <h2>Quiénes somos</h2>
      <p>
        Somos Poi-Bank, una institución financiera colombiana con presencia a
        nivel nacional e internacional (Argentina, México y Ecuador). Nuestra
        misión es promover la inclusión a través de las microfinanzas y otros
        productos y servicios financieros. Desde nuestra fundación, hemos estado
        comprometidos con el crecimiento económico y el bienestar de nuestros
        clientes. Valoramos la transparencia, la confianza y la responsabilidad
        en todas nuestras operaciones. Nuestro equipo está formado por
        profesionales apasionados que trabajan incansablemente para brindar
        soluciones únicas y personalizadas a las necesidades financieras de las
        personas y las empresas. En Poi-Bank, creemos en el poder transformador
        del acceso a servicios financieros y estamos comprometidos con el
        desarrollo sostenible de nuestras comunidades.
      </p>
      <p id="tyc">Conoce nuestros términos y condiciones</p>
      <iframe
        src="assets/terminos_y_condiciones_poi-bank.pdf"
        style="width: 100%; height: 700px"
        >Conoce nuestros</iframe
      >

      <br />
      <br />
      <h6>*Perteneciente al proyecto Hoi-Poi, banco e inmobiliaria</h6>
    </section>

    <!-- Footer-->
    <footer class="py-5 bg-dark">
      <div class="container px-5">
        <p class="m-0 text-center text-white">Copyright &copy; Poi-Bank 2024</p>
      </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               SB Forms JS                               * *-->
    <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
  </body>
  <style>
    .centrar {
      justify-content: center;
      align-items: center;
    }
    .cuerpo {
      padding-top: 60px;
      padding-left: 50px;
      padding-bottom: 100px;
      padding-right: 50px;
    }
    button {
      margin-bottom: 10px;
      border: 1px solid #aaaa7b;
      border-radius: 5px;
      box-sizing: border-box;
    }
    button:hover {
      background-color: #322d2c;
      color: #fff;
    }
    #tyc {
      font-weight: 700;
    }
    body img {
      height: 160px;
    }
  </style>
</html>
