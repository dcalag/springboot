<nav class="navbar navbar-inverse ">
<div class="navbar-inner">
  <div class="container-fluid">
    <div class="navbar-header">
      
         <!-- Agregar boton del Menú cuando esta collapsado -->
         <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
         </button>
         <a class="navbar-brand" href="${path}/">Inicio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="dropdown">
           <a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin<span class="caret"></span></a>
           <ul class="dropdown-menu">
              <li><a href="${path}/admin/pageUsuarios">Usuarios</a></li>     
           </ul>
        </li>
        <li><a href="${path}/about">Acerca de</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${path}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</div>
</nav>