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

function buscarContrato() {
	const textoBusqueda = document.getElementById('buscarInput').value;

	const filas = document.querySelectorAll('#mainTableBody tr');
	filas.forEach((fila) => {
		const nombreItemInput = fila.querySelector('.editable-cell.tipoDeContrato');
		const nombreItem = nombreItemInput.value;

		if (textoBusqueda === "") {
			showRows();
		} else if (nombreItem.toLowerCase().includes(textoBusqueda.toLowerCase())) {
			fila.style.display = '';
		} else {
			fila.style.display = 'none';
		}
	});
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

function guardarFila(button) {
	var fila = $(button).closest("tr");
	var id = fila.find(".id").val();
	var tipoDeContrato = fila.find(".tipoDeContrato").val();
	var descripcion = fila.find(".descripcion").val();

	mostrarModal();

	document.getElementById("btn-aceptar").addEventListener("click", function() {

		if (!validarNombre(tipoDeContrato)) {
			var alerta = document.createElement("div");
			alerta.innerHTML =
				'<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
				'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
				'</svg>' +
				' Nombre de Contrato Invalido.<br><br>El nombre del Contrato solo debe tener letras.<br> (Se permiten las tíldes).<br><br>Ejemplo: Termino Indefinido <br><br>'
				;

			alerta.className = "alert-nombre alert";
			document.body.appendChild(alerta);
			setTimeout(function() {
				alerta.style.display = 'none';
			}, 10000);
			setTimeout(function() {
				alertaExito.style.animation = '';
			}, 20);
			alerta.style.color = "rgb(0, 0, 64)";
			ocultarModal();
			fila.find(".btn-primary").show();
			fila.find(".btn-success").hide();
			fila.find(".editable-cell").prop("readonly", true);
			return;
			
		
		}

		const tipo = tipoDeContrato.trim();
		if (tipo.length > 0) {
			const palabras = tipo.split(" "); 
			const palabrasCapitalizadas = palabras.map(function(palabra) {
				return palabra.charAt(0).toUpperCase() + palabra.slice(1).toLowerCase();
			});
			const nombreFormateado = palabrasCapitalizadas.join(" ");
			tipoDeContrato = nombreFormateado;
		}

		var form = document.createElement("form");
		form.method = "POST";
		form.action = "/editarContrato";

		var idInput = document.createElement("input");
		idInput.type = "hidden";
		idInput.name = "id";
		idInput.value = id;

		var tipoDeContratoInput = document.createElement("input");
		tipoDeContratoInput.type = "hidden";
		tipoDeContratoInput.name = "tipoDeContrato";
		tipoDeContratoInput.value = tipoDeContrato;

		var descripcionInput = document.createElement("input");
		descripcionInput.type = "hidden";
		descripcionInput.name = "descripcion";
		descripcionInput.value = descripcion;

		form.appendChild(idInput);
		form.appendChild(tipoDeContratoInput);
		form.appendChild(descripcionInput);

		document.body.appendChild(form);
		form.submit();
		ocultarModal();
		
		fila.find(".tipoDeDocumentoSelect").hide();
		
	});

	document.getElementById("btn-cancelar").addEventListener("click", function() {
		fila.find(".btn-primary").show();
		fila.find(".btn-success").hide();
		fila.find(".editable-cell").prop("readonly", true);
		ocultarModal();
	});

	document.getElementById("btn-close").addEventListener("click", function() {
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
            url: "/eliminarContrato",
            data: { id: id },
            success: function (data) {
                fila.remove();
                window.location.href = "/ConfiguracionDeContratos?delete";
            },
            error: function (error) {
                console.error("Error al eliminar el contrato: " + error);
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
    const numRowsPerPage = 9; // Número de filas por página
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
