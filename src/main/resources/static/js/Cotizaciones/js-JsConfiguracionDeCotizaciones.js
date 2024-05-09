function validateExito(input) {

	const alertaExito = document.querySelector('.alert-exito');
	alertaExito.style.animation = 'none';

	setTimeout(function() {
		alertaExito.style.animation = '';
	}, 20);

	setTimeout(function() {
		alertaExito.style.display = 'none';
	}, 10000);
}

function validateDelete(input) {

	const alertaDelete = document.querySelector('.alert-delete');
	alertaDelete.style.animation = 'none';

	setTimeout(function() {
		alertaDelete.style.animation = '';
	}, 20);

	setTimeout(function() {
		alertaDelete.style.display = 'none';
	}, 10000);
}

function buscarCliente() {
    var input = document.getElementById("buscarInput");
    var filter = input.value.toUpperCase();
    var tabla = document.getElementById("tableContenido");
    var filas = tabla.getElementsByTagName("tr");

    if (filter === "") {
        showRows();
    } else {
        for (var i = 0; i < filas.length; i++) {
            var celda = filas[i].getElementsByTagName("td")[3];
            if (celda) {
                var textoCelda = celda.textContent || celda.innerText;
                if (textoCelda.toUpperCase().indexOf(filter) > -1) {
                    filas[i].style.display = "";
                } else {
                    filas[i].style.display = "none";
                }
            }
        }
    }
}



function mostrarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "block";
	return false;
}

function ocultarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "none";
}

function eliminarCliente(button) {
	var fila = $(button).closest("tr");
	var id = fila.find(".id").val();
	
	console.log("id " + id)
		    
	mostrarModalEliminar();
	
	document.getElementById("btn-aceptarF").addEventListener("click", function() {
        $.ajax({
            type: "POST",
            url: "/eliminarCotizacion",
            data: { id: id },
            success: function (data) {
                fila.remove();
                window.location.href = "/CotizacionesRegistradas?delete";
            },
            error: function (error) {
                console.error("Error al eliminar el cliente: " + error);
            }
        });

        ocultarModalEliminar();
    });
	
	document.getElementById("btn-cancelarF").addEventListener("click", function() {
		ocultarModalEliminar();
		showRows();
	});
	
	document.getElementById("btn-closeF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
	
	validateDelete();
	showRows();
}

var currentIndex = 0;
var tableRows = document.getElementById("mainTableBody").getElementsByTagName("tr");
var numRows = tableRows.length;

function showNext() {
	var nextIndex = currentIndex + 7;
	if (nextIndex >= numRows) {
		nextIndex = numRows;
		document.getElementsByClassName("arrow-button")[1].style.display = "none";
	}
	currentIndex = nextIndex;
	showRows();
}

function showPrevious() {
	var previousIndex = currentIndex - 7;
	if (previousIndex < 0) {
		previousIndex = 0;
		document.getElementsByClassName("arrow-button")[0].style.display = "none";
	}
	currentIndex = previousIndex;
	showRows();
}

function showRows() {
    const numRowsPerPage = 7; // Número de filas por página
    const totalViews = Math.ceil(numRows / numRowsPerPage); // Calcular el total de vistas

    for (let i = 0; i < numRows; i++) {
        if (i >= currentIndex && i < currentIndex + numRowsPerPage) {
            tableRows[i].style.display = "";
        } else {
            tableRows[i].style.display = "none";
        }
    }

    if (currentIndex === 0) {
        document.getElementsByClassName("arrow-button")[0].style.display = "none"; // Ocultar botón anterior si estamos en la primera vista
    } else {
        document.getElementsByClassName("arrow-button")[0].style.display = ""; // Mostrar botón anterior si no estamos en la primera vista
    }
    if (currentIndex + numRowsPerPage >= numRows) {
        document.getElementsByClassName("arrow-button")[1].style.display = "none"; // Ocultar botón siguiente si estamos en la última vista
    } else {
        document.getElementsByClassName("arrow-button")[1].style.display = ""; // Mostrar botón siguiente si no estamos en la última vista
    }

    // Actualizar texto que muestra la vista actual y el total de vistas
    const currentView = Math.floor(currentIndex / numRowsPerPage) + 1; // Calcular la vista actual
    document.querySelector(".current-view").innerText = `Vista ${currentView} de ${totalViews}`; // Actualizar el texto
}

showRows();
