function validateExito(input) {
	
	const alertaExito = document.querySelector('.alert-exito');
	alertaExito.style.animation = 'none';

	setTimeout(function() {
		alertaExito.style.animation = '';
	}, 20);

	setTimeout(function() {
		alertaExito.style.display = 'none';
	}, 10000);
	
	showRows();
}

function validateDelete(input) {
	showRows();
    const alertaDelete = document.querySelector('.alert-delete');
    alertaDelete.style.animation = 'none';

    setTimeout(function() {
        alertaDelete.style.animation = '';
    }, 20);

    setTimeout(function() {
        alertaDelete.style.display = 'none';
    }, 10000);
    showRows();
}




function buscarProducto() {
	const textoBusqueda = document.getElementById('buscarInput').value;

	const filas = document.querySelectorAll('#mainTableBody tr');
	filas.forEach((fila) => {
		const nombreItemInput = fila.querySelector('.editable-cell.nombreItem');
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

	var precioInput = fila.find(".valorUnitario");
	var baseInput = fila.find(".valorBase");
	var incInput = fila.find(".impoconsumo");

	precioInput.val(precioInput.val().replace("$ ", ""));
	baseInput.val(baseInput.val().replace("$ ", ""));
	incInput.val(incInput.val().replace("$ ", ""));

	fila.find(".editable-cell").prop("readonly", false);

	fila.find(".btn-primary").hide();
	fila.find(".btn-success").show();
}

function validarNombre(nombre) {
	var regex = /^[a-zA-Z\u00C0-\u017F ]*$/;
	return regex.test(nombre);
}

function validarPrecio(precio) {
	if (isNaN(precio)) {
		return false;
	}
	var precioNumero = parseFloat(precio);
	var regex = /^\$?[0-9]+(\.[0-9]{1,2})?$/;
	return regex.test(precioNumero);
}

function guardarFila(button) {
	var fila = $(button).closest("tr");
	var id = fila.find(".id").val();
	var nombreItem = fila.find(".nombreItem").val();
	var valorUnitario = fila.find(".valorUnitario").val();
	var descripcion = fila.find(".descripcion").val();

	mostrarModal();

	document.getElementById("btn-aceptar").addEventListener("click", function() {

		if (!validarNombre(nombreItem)) {
			var alerta = document.createElement("div");
			alerta.innerHTML =
				'<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
				'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
				'</svg>' +
				' Nombre de Producto Invalido.<br><br>El nombre solo debe tener letras.<br> (Se permiten las tíldes).<br><br>Ejemplo: Trucha Especial Sisga <br><br>'
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
			fila.find(".btn-editar").show();
			fila.find(".btn-guardar").hide();
			fila.find(".editable-cell").prop("readonly", true);
			return;
		}

		const nombre = nombreItem.trim();
		if (nombre.length > 0) {
			const palabras = nombre.split(" ");
			const palabrasCapitalizadas = palabras.map(function(palabra) {
				return palabra.charAt(0).toUpperCase() + palabra.slice(1).toLowerCase();
			});
			const nombreFormateado = palabrasCapitalizadas.join(" ");
			nombreItem = nombreFormateado;
		}

		if (!validarPrecio(valorUnitario)) {
			var alerta = document.createElement("div");
			alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
				'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
				'</svg>' +
				" Precio de Producto Invalido!.<br><br>El precio del artículo solo debe tener números. (No caracteres especiales).<br><br>Ejemplo: 25000";
			alerta.className = "alert-precio alert";
			alerta.style.color = "rgb(0, 0, 64)";
			document.body.appendChild(alerta);
			setTimeout(function() {
				alerta.style.display = 'none';
			}, 10000);
			setTimeout(function() {
				alertaExito.style.animation = '';
			}, 20);
			ocultarModal();
			fila.find(".btn-editar").show();
			fila.find(".btn-guardar").hide();
			fila.find(".editable-cell").prop("readonly", true);
			return;
		}

		var impoconsumo = parseFloat(valorUnitario) * 0.08;
		var valorBase = parseFloat(valorUnitario) - impoconsumo;

		var form = document.createElement("form");
		form.method = "POST";
		form.action = "/editarProducto";

		var idInput = document.createElement("input");
		idInput.type = "hidden";
		idInput.name = "id";
		idInput.value = id;

		var nombreItemInput = document.createElement("input");
		nombreItemInput.type = "hidden";
		nombreItemInput.name = "nombreItem";
		nombreItemInput.value = nombreItem;

		var valorUnitarioInput = document.createElement("input");
		valorUnitarioInput.type = "hidden";
		valorUnitarioInput.name = "valorUnitario";
		valorUnitarioInput.value = valorUnitario;

		var descripcionInput = document.createElement("input");
		descripcionInput.type = "hidden";
		descripcionInput.name = "descripcion";
		descripcionInput.value = descripcion;

		var valorBaseInput = document.createElement("input");
		valorBaseInput.type = "hidden";
		valorBaseInput.name = "valorBase";
		valorBaseInput.value = valorBase;

		var impoconsumoInput = document.createElement("input");
		impoconsumoInput.type = "hidden";
		impoconsumoInput.name = "impoconsumo";
		impoconsumoInput.value = impoconsumo;

		form.appendChild(idInput);
		form.appendChild(nombreItemInput);
		form.appendChild(valorUnitarioInput);
		form.appendChild(descripcionInput);
		form.appendChild(valorBaseInput);
		form.appendChild(impoconsumoInput);

		document.body.appendChild(form);
		form.submit();
		ocultarModal();
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

function eliminarProducto(button) {
	
	var fila = $(button).closest("tr");
	var id = fila.find(".id").val();
		    
	mostrarModalEliminar();
	
	document.getElementById("btn-aceptarF").addEventListener("click", function() {
        $.ajax({
            type: "POST",
            url: "/eliminarProducto",
            data: { id: id },
            success: function (data) {
                fila.remove();
                window.location.href = "/ConfiguracionDeProductos?delete";
            },
            error: function (error) {
                console.error("Error al eliminar el producto: " + error);
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
		document.getElementsByClassName("arrow-button")[0].style.display = "none";
	} else {
		document.getElementsByClassName("arrow-button")[0].style.display = "";
	}
	if (currentIndex + numRowsPerPage >= numRows) {
		document.getElementsByClassName("arrow-button")[1].style.display = "none";
	} else {
		document.getElementsByClassName("arrow-button")[1].style.display = "";
	}
	
    // Actualizar texto que muestra la vista actual y el total de vistas
    const currentView = Math.floor(currentIndex / numRowsPerPage) + 1; // Calcular la vista actual
    document.querySelector(".current-view").innerText = `Vista ${currentView} de ${totalViews}`; // Actualizar el texto
}

showRows();
