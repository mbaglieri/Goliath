
function doExpandCollapse(id){
  var b = document.getElementById(id);
  if (b.style.display=='none'){
    b.style.display='';
    document.getElementById("btn").value='Ocultar Filtros';
  }
  else{
    b.style.display='none';
    document.getElementById("btn").value='Mostrar Filtros';
  }
}
  function validarStruct(){
    if (document.getElementById('fecDesafd_value').value!=""){
      document.getElementById('fecDesafd').value="struct";
    }
    if (document.getElementById('fecDesafh_value').value!=""){
      document.getElementById('fecDesafh').value="struct";
    }
    if (document.getElementById('fechAfecd_value').value!=""){
      document.getElementById('fechAfecd').value="struct";
    }
    if (document.getElementById('fechAfech_value').value!=""){
      document.getElementById('fechAfech').value="struct";
    }
  }
