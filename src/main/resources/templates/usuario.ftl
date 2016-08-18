
<html>
    <head>
        <title>Usuario nuevo</title>          
        <#include "includes.ftl">

        <script type="text/template" id="templateUsuario">                          
            <div>
                <div class="form-group">
                    <label for="username">Usuario:</label>
                    <input id="username" type="text" class="clickable" value="{{ usuario.username }}" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input id="password" type="password" class="clickable" value="{{ usuario.password }}" />
                </div>
                <div class="form-group">
                    <label for="checkEnabled">Enabled:</label>            
                    {{#if usuario.enabled}}
                        <input type="checkbox" id="checkEnabled" checked>
                    {{else}}
                        <input type="checkbox" id="checkEnabled">
                    {{/if}}                
                </div>
                <div class="form-group">
                    <label for="adminRole">admin_role:</label>
                    {{#if usuario.adminRole}}
                        <input type="checkbox" id="adminRole" checked>
                    {{else}}
                        <input type="checkbox" id="adminRole">
                    {{/if}}
                </div>
                <div class="form-group">
                    <label for="userRole">user_role:</label>
                    {{#if usuario.userRole}}
                        <input type="checkbox" id="userRole" checked>
                    {{else}}
                        <input type="checkbox" id="userRole">
                    {{/if}}
                 </div>
                <button class="btn btn-default" id="btnGuardar">Guardar</button>
                <button class="btn btn-default" id="btnCancelar">Canclear</button>
            </div>
        </script>
        <script src="${path}/js/usuario.js"></script>	        
    </head>
    <body>
        <#include "header.ftl">        
        <div class="container">
            <#include "mensajes.ftl">
            <h3>Usuario nuevo</h3>
            <div class="panel panel-default">
                <div class="panel-body">
                    <div id="divUsuarioNuevo"></div>
                </div>
            </div>
        </div>
    </body>
</html>
