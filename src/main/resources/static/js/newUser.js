$(document).ready(function() {


});


async function registrarUser(){
    let datos={};
    datos.name= document.getElementById('txtNombre').value;
    datos.lastName= document.getElementById('txtApellido').value;
    datos.identification= document.getElementById('txtIdentificacion').value;
    datos.telephone= document.getElementById('txtTelefono').value;
    datos.email= document.getElementById('txtEmail').value;

  const request = await fetch('API/REST/user/newUser', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
      body: JSON.stringify(datos)
  });


  window.location.href='user-new.html'

}