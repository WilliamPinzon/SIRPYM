function validateExito(input) {

	const alertaExito = document.querySelector('.alert-exito');
	alertaExito.style.animation = 'none';

	setTimeout(function() {
		alertaExito.style.animation = '';
	}, 20);

	// Ocultar el alert después de 30 segundos
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

	// Ocultar el alert después de 30 segundos
	setTimeout(function() {
		alertaDelete.style.display = 'none';
	}, 10000);
}

function buscarProducto() {
	// Obtiene el texto ingresado en el input.
	const textoBusqueda = document.getElementById('buscarInput').value;

	// Filtra la tabla en función del texto de búsqueda.
	const filas = document.querySelectorAll('#mainTableBody tr');
	filas.forEach((fila) => {
		const nombreProductoInput = fila.querySelector('.editable-cell.nombreProducto');
		const nombreProducto = nombreProductoInput.value;

		// Compara el texto de la fila con el texto de búsqueda, ignorando las mayúsculas y minúsculas.
		if (textoBusqueda === "") {
			// Si el texto de búsqueda está vacío, muestra todas las filas.
			showRows();
		} else if (nombreProducto.toLowerCase().includes(textoBusqueda.toLowerCase())) {
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

document.getElementById("btn-aceptarF").addEventListener("click", function() {
	var formularioEliminar = document.querySelector('form');
	formularioEliminar.submit();
	ocultarModalEliminar(); // Cierra el modal después de enviar el formulario.
});

document.getElementById("btn-cancelarF").addEventListener("click", function() {
	ocultarModalEliminar(); // Cierra el modal al hacer clic en "Cancelar"
});

document.getElementById("btn-closeF").addEventListener("click", function() {
	ocultarModalEliminar(); // Cierra el modal al hacer clic en la "x"
});


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

	var precioInput = fila.find(".precioProducto");
	var baseInput = fila.find(".baseProducto");
	var incInput = fila.find(".incProducto");

	precioInput.val(precioInput.val().replace("$ ", ""));
	baseInput.val(baseInput.val().replace("$ ", ""));
	incInput.val(incInput.val().replace("$ ", ""));

	fila.find(".editable-cell").prop("readonly", false);

	fila.find(".btn-editar").hide();
	fila.find(".btn-guardar").show();
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
	var nombreProducto = fila.find(".nombreProducto").val();
	var precioProducto = fila.find(".precioProducto").val();
	var descripcionProducto = fila.find(".descripcionProducto").val();

	mostrarModal();

	document.getElementById("btn-aceptar").addEventListener("click", function() {

		if (!validarNombre(nombreProducto)) {
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

		const nombre = nombreProducto.trim(); // Obtener el valor y eliminar espacios en blanco al principio y al final
		if (nombre.length > 0) {
			const palabras = nombre.split(" "); // Dividir la cadena en palabras
			const palabrasCapitalizadas = palabras.map(function(palabra) {
				return palabra.charAt(0).toUpperCase() + palabra.slice(1).toLowerCase();
			});
			const nombreFormateado = palabrasCapitalizadas.join(" "); // Unir las palabras nuevamente
			nombreProducto = nombreFormateado; // Establecer el valor formateado en el campo de entrada
		}

		if (!validarPrecio(precioProducto)) {
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

		// Calcular los valores de baseProducto e incProducto
		var incProducto = parseFloat(precioProducto) * 0.08;  // El triple del precio
		var baseProducto = parseFloat(precioProducto) - incProducto; // El doble del precio


		// Crear un formulario oculto
		var form = document.createElement("form");
		form.method = "POST";
		form.action = "/editarProducto";

		// Crear campos de entrada ocultos para enviar los valores editados
		var idInput = document.createElement("input");
		idInput.type = "hidden";
		idInput.name = "id";
		idInput.value = id;

		var nombreProductoInput = document.createElement("input");
		nombreProductoInput.type = "hidden";
		nombreProductoInput.name = "nombreProducto";
		nombreProductoInput.value = nombreProducto;

		var precioProductoInput = document.createElement("input");
		precioProductoInput.type = "hidden";
		precioProductoInput.name = "precioProducto";
		precioProductoInput.value = precioProducto;

		var descripcionProductoInput = document.createElement("input");
		descripcionProductoInput.type = "hidden";
		descripcionProductoInput.name = "descripcionProducto";
		descripcionProductoInput.value = descripcionProducto;

		var baseProductoInput = document.createElement("input");
		baseProductoInput.type = "hidden";
		baseProductoInput.name = "baseProducto";
		baseProductoInput.value = baseProducto;

		var incProductoInput = document.createElement("input");
		incProductoInput.type = "hidden";
		incProductoInput.name = "incProducto";
		incProductoInput.value = incProducto;

		// Agregar los campos de entrada al formulario
		form.appendChild(idInput);
		form.appendChild(nombreProductoInput);
		form.appendChild(precioProductoInput);
		form.appendChild(descripcionProductoInput);
		form.appendChild(baseProductoInput);
		form.appendChild(incProductoInput);

		// Agregar el formulario al documento y enviarlo
		document.body.appendChild(form);
		form.submit();
		ocultarModal();
	});

	document.getElementById("btn-cancelar").addEventListener("click", function() {
		fila.find(".btn-editar").show();
		fila.find(".btn-guardar").hide();
		fila.find(".editable-cell").prop("readonly", true);
		ocultarModal();
	});

	document.getElementById("btn-close").addEventListener("click", function() {
		fila.find(".btn-editar").show();
		fila.find(".btn-guardar").hide();
		fila.find(".editable-cell").prop("readonly", true);
		ocultarModal();
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
	for (var i = 0; i < numRows; i++) {
		if (i >= currentIndex && i < currentIndex + 9) {
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
	if (currentIndex + 5 >= numRows) {
		document.getElementsByClassName("arrow-button")[1].style.display = "none";
	} else {
		document.getElementsByClassName("arrow-button")[1].style.display = "";
	}
}
showRows();
