$(“#mycustomhtml“).load(“customhtml.txt”, function (response, status, xhr) {

if status == “error”) {

var msg = “Error: “;

alert(msg + xhr.status + ” “ + xhr.statusText);

}

});

window.onload = function () {
   alert("cargado...");
}

$(document).ready(function(){
   $("a").click(function(evento){
      alert("Has pulsado el enlace...nAhora serás enviado a DesarrolloWeb.com");
   });
});