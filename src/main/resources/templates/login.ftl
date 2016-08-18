<!DOCTYPE html>
<head lang="en">
    <title>Login</title>
    <#include "includes.ftl">    
    <script src="${path}/js/login.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <span class="navbar-brand">Login</span>      
            </div>   
        </div>
    </nav>
    <div class="container">                                             
        <form action="${path}/login" method="post">            
            <h2>Login:</h2> 
            <#if RequestParameters.error??>
            <div class="alert alert-danger" id="mensajeError" style="margin-top:10px">
                <span id="error">Verifique su usuario y contraseña.</span>
                <button type="button" id="btnCloseErr" class="btn btn-danger">
                    <span class="glyphicon glyphicon-remove"></span> Ok
                </button>
            </div>            
            </#if>
            <div class="form-group">
                <label for="username">Usuario:</label>        
                <input type="text"  
                       id="username" class="form-control" name="username"/>     
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" 
                       id="password" class="form-control" name="password"/>            
            </div>
            <input id="btnLogin" type="submit" class="btn btn-success" value="Login" />
            <input id="btnCancel" type="submit" class="btn btn-default" value="Cancelar" onclick="location.href = '${path}/'; return false;" />
        </form>
    </div>
</body>