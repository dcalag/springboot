var lista;
var usuario;
var vista;

var ViewLista = Backbone.View.extend({
    el: '#listaUsuarios',
    template: Handlebars.compile($("#templateListaUsuarios").html()),
    render: function () {
        this.$el.html(this.template({usuarios: this.model.toJSON()}));
    },
    events: {
        'click [id^=btnVer]': 'ver',
        'click [id^=btnEliminar]': 'proponeEliminar'
    },
    ver: function (event) {
        var id = $(event.target).data('id-ver');
        //console.debug(id);
        location.href = path + "/admin/pageUsuario?id=" + id;
    },
    proponeEliminar: function (event) {
        var id = $(event.target).data('id-eliminar');
        this.idEliminar = id;
    },
    eliminar: function () {
        var modDel = lista.get(this.idEliminar);
        modDel.destroy({
            contentType: 'application/json',
            dataType: 'text',
            success: function (model, response) {
                mensaje("Registro eliminado correctamente.");
            },
            error: function (model, response) {
                var responseObj = $.parseJSON(response.responseText);
                error('Error al eliminar el registro: ' + responseObj.error);
            }
        });
        vista.render();
    }
});

var Usuario = Backbone.Model.extend({
    urlRoot: path + '/admin/usuario',
    initialize: function () {
    },
    idAttribute: 'id'
});

var UsuariosCollection = Backbone.Collection.extend({
    model: Usuario,
    url: path + '/admin/usuarios'
});

$(document).ready(function () {
    $('#mensajeOk').hide();
    $('#mensajeError').hide();
    
    $('#btnConfEliminar').click( function() {
       vista.eliminar(); 
    });

    document.getElementById("btnNuevo").onclick = function () {
        location.href = path + "/admin/pageUsuario";
    };

    lista = new UsuariosCollection();
    lista.fetch({
        success: function () {
            vista = new ViewLista({
                model: lista
            });
            vista.render();
        },
        error: function () {
            error('Error al obtener la lista de usuarios.');
        }
    });
});

function mensaje(mensaje) {
    $('#mensajeOk').show();
    $('#mensaje').html(mensaje);
}

function error(mensaje) {
    $('#mensajeError').show();
    $('#error').html(mensaje);
}
