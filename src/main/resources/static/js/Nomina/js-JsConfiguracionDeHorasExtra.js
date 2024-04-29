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

function mostrarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "block";
	return false;
}

function ocultarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "none";
}

function mostrarModal() {
	var modal = document.getElementById("modal");
	modal.style.display = "block";
}

function ocultarModal() {
	var modal = document.getElementById("modal");
	modal.style.display = "none";
}

function editarFila(button) {
        var fila = $(button).closest("tr");
        fila.find(".editable-cell").prop("readonly", false);
        fila.find(".btn-primary").hide();
        fila.find(".btn-success").show();
    }

function validarNombre(nombre) {
	var regex = /^[a-zA-Z\u00C0-\u017F ]*$/;
	return regex.test(nombre);
}

function validarIDCliente(numeroDeDocumento) {
	if (isNaN(numeroDeDocumento)) {
		return false;
	}

	var numeroDeDocumento = parseFloat(numeroDeDocumento);
	var regex = /^[0-9]*$/;

	if (!regex.test(numeroDeDocumento)) {
		return false;
	}

	if (numeroDeDocumento.toString().length > 12) {
		return false;
	}

	return true;
}


function validarcorreoElectronico(correoElectronico) {
	var regex = /^[\w\.-]+@[\w\.-]+\.\w+$/;
	return regex.test(correoElectronico);
}

function validarnumeroDeContacto(numeroDeContacto) {
	var regex = /^[0-9]*$/;
	return regex.test(numeroDeContacto);
}


function guardarFila(button) {
	mostrarModal();
    var fila = $(button).closest("tr");
    var id = fila.find(".id").val();
    var fechaDeRegistroNomina = fila.find(".fechaDeRegistroNomina").val();
    var horaDeIngreso = fila.find(".horaDeIngreso").val();
    var horaDeSalida = fila.find(".horaDeSalida").val();

    // Calcular las horas extra
    var entrada = new Date("01/01/2000 " + horaDeIngreso);
    var salida = new Date("01/01/2000 " + horaDeSalida);
    var diffMillis = salida.getTime() - entrada.getTime();
    var diffHours = (diffMillis / (1000 * 60 * 60)) - 9;

    // Actualizar el campo de totalHoraExtra
    var totalHoraExtra = diffHours.toFixed(2);
    fila.find(".totalHoraExtra").val(totalHoraExtra);
    
	mostrarModal();
	
	document.getElementById("btn-aceptar").addEventListener("click", function() {
		// Crear y enviar el formulario
	    var form = document.createElement("form");
	    form.method = "POST";
	    form.action = "/editarHorasExtra";
	
	    var idInput = document.createElement("input");
	    idInput.type = "hidden";
	    idInput.name = "id";
	    idInput.value = id;
	
	    var fechaDeRegistroNominaInput = document.createElement("input");
	    fechaDeRegistroNominaInput.type = "hidden";
	    fechaDeRegistroNominaInput.name = "fechaDeRegistroNomina";
	    fechaDeRegistroNominaInput.value = fechaDeRegistroNomina;
	
	    var horaDeIngresoInput = document.createElement("input");
	    horaDeIngresoInput.type = "hidden";
	    horaDeIngresoInput.name = "horaDeIngreso";
	    horaDeIngresoInput.value = horaDeIngreso;
	
	    var horaDeSalidaInput = document.createElement("input");
	    horaDeSalidaInput.type = "hidden";
	    horaDeSalidaInput.name = "horaDeSalida";
	    horaDeSalidaInput.value = horaDeSalida;
	
	    var totalHoraExtraInput = document.createElement("input");
	    totalHoraExtraInput.type = "hidden";
	    totalHoraExtraInput.name = "totalHoraExtra";
	    totalHoraExtraInput.value = totalHoraExtra;
	
	    form.appendChild(idInput);
	    form.appendChild(fechaDeRegistroNominaInput);
	    form.appendChild(horaDeIngresoInput);
	    form.appendChild(horaDeSalidaInput);
	    form.appendChild(totalHoraExtraInput);
	
	    document.body.appendChild(form);
	    form.submit();
	    ocultarModal();
	
	    fila.find(".tipoDeDocumentoSelect").hide();
    
	});
    
    // Event listeners para botones de cancelar y cerrar modal
    document.getElementById("btn-cancelar").addEventListener("click", function () {
        fila.find(".btn-primary").show();
        fila.find(".btn-success").hide();
        fila.find(".editable-cell").prop("readonly", true);
        ocultarModal();
    });

    document.getElementById("btn-close").addEventListener("click", function () {
        fila.find(".btn-primary").show();
        fila.find(".btn-success").hide();
        fila.find(".editable-cell").prop("readonly", true);
        ocultarModal();
    });
}


function eliminarCliente(button) {
	var fila = $(button).closest("tr");
	var id = fila.find(".id").val();
		    
	mostrarModalEliminar();
	
	document.getElementById("btn-aceptarF").addEventListener("click", function() {
        $.ajax({
            type: "POST",
            url: "/eliminarHorasExtra",
            data: { id: id },
            success: function (data) {
                fila.remove();
                window.location.href = "/ConfiguracionNominaHorasExtra?delete";
            },
            error: function (error) {
                console.error("Error al eliminar el cliente: " + error);
            }
        });

        ocultarModalEliminar();
    });
	
	document.getElementById("btn-cancelarF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
	
	document.getElementById("btn-closeF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
}

var currentIndex = 0;
var tableRows = document.getElementById("mainTableBody").getElementsByTagName("tr");
var numRows = tableRows.length;

function showNext() {
	var nextIndex = currentIndex + 9;
	if (nextIndex >= numRows) {
		nextIndex = numRows;
		document.getElementsByClassName("arrow-button")[1].style.display = "none";
	}
	currentIndex = nextIndex;
	showRows();
}

function showPrevious() {
	var previousIndex = currentIndex - 9;
	if (previousIndex < 0) {
		previousIndex = 0;
		document.getElementsByClassName("arrow-button")[0].style.display = "none";
	}
	currentIndex = previousIndex;
	showRows();
}

function showRows() {
    const numRowsPerPage = 8; // Número de filas por página
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

function buscarColaboradorYFecha() {
    var filterColaborador = document.getElementById("buscarColaboradorInput").value.toUpperCase();
    var filterFecha = document.getElementById("buscarFechaInput").value.toUpperCase();
    
    var tabla = document.getElementsByTagName("table")[0];
    var filas = tabla.getElementsByTagName("tr");

    for (var i = 0; i < filas.length; i++) {
        var celdaColaborador = filas[i].getElementsByTagName("td")[4];
        var celdaFecha = filas[i].getElementsByTagName("td")[3];

        if (celdaColaborador && celdaFecha) {
            var textoColaborador = celdaColaborador.textContent || celdaColaborador.innerText;
            var textoFecha = celdaFecha.textContent || celdaFecha.innerText;

            if ((filterColaborador === "" || textoColaborador.toUpperCase().indexOf(filterColaborador) > -1) &&
                (filterFecha === "" || textoFecha.toUpperCase().indexOf(filterFecha) > -1)) {
                filas[i].style.display = "";
            } else {
                filas[i].style.display = "none";
            }
        }
    }
}

function buscarColaborador() {
    var filter = document.getElementById("buscarColaboradorInput").value.toUpperCase();
    var tabla = document.getElementsByTagName("table")[0];
    var filas = tabla.getElementsByTagName("tr");

    for (var i = 0; i < filas.length; i++) {
        var celda = filas[i].getElementsByTagName("td")[4];
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

function buscarPorFecha() {
    var filter = document.getElementById("buscarFechaInput").value.toUpperCase();
    var tabla = document.getElementsByTagName("table")[0];
    var filas = tabla.getElementsByTagName("tr");

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

showRows();
