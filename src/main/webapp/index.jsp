<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/bootstrap.css">
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
    <title>Fintech</title>
</head>
<body class="d-flex flex-column">
    <header>
        <img src="images/637.jpg" alt="logo-fintech" class="img-fluid">
    </header>
    <div class="container d-flex justify-content-center">
        <div class="login-form">
            <form action="login" method="post" class="d-flex flex-column">
                <div class="mb-3">
                    <label for="idlogin" class="form-label">Login</label>
                    <input type="text" id="idlogin" name="email" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="idsenha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="idsenha" name="senha">
                </div>
                <div class="mb-3 d-flex justify-content-around">
                    <a href="https://accounts.google.com/v3/signin/identifier?hl=pt-br&ifkv=ASKXGp2zaOfMHvyt7qNF0Qw0b6gTDvL65F96kP659WhsqBom6oWXTudI0RVQxFc49BayRcnf_1ixbQ&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S134622708%3A1702475180672434&theme=glif"><img class="icon" width="30" height="30" src="https://img.icons8.com/color/48/google-logo.png" alt="google-logo"/></a>
                    <a href="https://m.facebook.com/login/?locale=pt_BR"><img class="icon" width="30" height="30" src="https://img.icons8.com/fluency/48/facebook-new.png" alt="facebook-new"/></a>
                    <a href="https://www.icloud.com/"><img class="icon" width="30" height="30" src="https://img.icons8.com/ios-filled/50/FFFFFF/mac-os.png" alt="mac-os"/></a>
                </div>
                <div class="mb-1">
                    <a class="link-underline-light d-flex justify-content-center" href="recuperarSenha.jsp">Esqueci a senha</a>
                </div>
                <div class="d-flex d-flex justify-content-between mt-4">
                    <button type="submit" class="btn btn-primary">Login</button>
                    <a href="cadastro.jsp" class="btn btn-primary">Cadastre-se</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
