
<html>
    <head>
        <title>Usuarios</title>          
        <#include "includes.ftl">

        <script type="text/template" id="templateListaUsuarios">              
            <table class="table table-bordered">
            <thead>
              <tr>
                <th>Username</th>
                <th>Enabled</th>
                <th>&nbsp;</th>
              </tr>
            </thead>
            <tbody>
            {{#each usuarios}}  
                  <tr>                    
                    <td>{{username}}</td>
                    <td>{{enabled}}</td>
                    <td><button type="button" id="btnVer{{id}}"
                        data-id-ver="{{id}}" class="btn btn-default">Ver</button>
                    <button type="button" data-toggle="modal" data-target="#modalDelete" id="btnEliminar{{id}}"
                        data-id-eliminar="{{id}}" class="btn btn-danger">Eliminar</button>
                    </td>
                  </tr>
            {{/each}}
            </tbody>
            </table>
               
        </script>
        <script src="${path}/js/usuarios.js"></script>	        
    </head>
    <body>
        <#include "header.ftl">
        <div class="container">
            <#include "mensajes.ftl">
            <h3>Lista de usuarios</h3>
            <button type="button" id="btnNuevo" class="btn btn-primary">Nuevo usuario</button>
            <div class="panel panel-default espacio-arriba">
                <div class="panel-body">
                    <div id="listaUsuarios"></div>
                </div>
            </div>
            
            <!-- ventana modal -->
            <div id="modalDelete" class="modal fade" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Confirmar eliminación</h4>
                        </div>
                        <div class="modal-body">
                            <p>¿Realmente desea eliminar el usuario?</p>
                        </div>
                         <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal" id="btnConfEliminar">Si</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>        
    </body>
</html>
