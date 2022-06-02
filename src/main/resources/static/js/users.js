$(document).ready(function() {
    cargarUsuarios();
  $('#users').DataTable();
});

async function cargarUsuarios(){
  const request = await fetch('API/REST/user/getUsers', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const users = await request.json();

  let listadoHtml ='';
  for(let User of users){
    let botonEliminar = '<a href="#" onclick="eliminarUser('+User.id+')" class="btn btn-warning" btn-circle btn-sn><i class="far fa-trash-alt"></i></a>';
    let usuarioHtml  =  '<tr> <td>'+User.id+'</td><td>'+ User.name +'</td><td>'+User.lastName+'</td><td>'+User.telephone
                        +'</td><td>'+User.email +'</td><td>'+User.identification+'</td><td>'+botonEliminar+'</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#users tbody').outerHTML=listadoHtml;


}


async function eliminarUser(id){
    if(!confirm('¿ Desea Eliminar El Usuario Del Sistema ?')){
        return;
    }

  const request = await fetch('API/REST/user/deleteUser/'+ id ,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload()
}