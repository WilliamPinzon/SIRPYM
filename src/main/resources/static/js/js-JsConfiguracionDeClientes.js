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

function buscarCliente() {
	// Obtiene el texto ingresado en el input.
	const textoBusqueda = document.getElementById('buscarInput').value;

	// Filtra la tabla en función del texto de búsqueda.
	const filas = document.querySelectorAll('#mainTableBody tr');
	filas.forEach((fila) => {
		const numeroIDClienteInput = fila.querySelector('.editable-cell.numeroIDCliente');
		const numeroIDCliente = numeroIDClienteInput.value;

		// Compara el texto de la fila con el texto de búsqueda, ignorando las mayúsculas y minúsculas.
		if (textoBusqueda === "") {
			// Si el texto de búsqueda está vacío, muestra todas las filas.
			showRows();
		} else if (numeroIDCliente.toLowerCase().includes(textoBusqueda.toLowerCase())) {
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
	fila.find(".editable-cell").prop("readonly", false);

	// Ocultar el campo de texto
	fila.find(".tipoIDCliente").hide();

	// Mostrar el select existente
	fila.find(".tipoIDClienteSelect").show();

	// Ocultar el botón 'Editar' y mostrar el botón 'Guardar'
	fila.find(".btn-editar").hide();
	fila.find(".btn-guardar").show();
}

function validarNombre(nombre) {
	var regex = /^[a-zA-Z\u00C0-\u017F ]*$/;
	return regex.test(nombre);
}

function validarIDCliente(numeroIDCliente) {
	if (isNaN(numeroIDCliente)) {
		return false;
	}

	var numeroIDCliente = parseFloat(numeroIDCliente);
	var regex = /^[0-9]*$/;

	if (!regex.test(numeroIDCliente)) {
		return false;
	}

	// Verificar que no pase de 12 dígitos
	if (numeroIDCliente.toString().length > 12) {
		return false;
	}

	return true;
}


function validarCorreoElectronicoCliente(correoElectronicoCliente) {
	var regex = /^[\w\.-]+@[\w\.-]+\.\w+$/;
	return regex.test(correoElectronicoCliente);
}

function validarNumeroDeContactoCliente(numeroDeContactoCliente) {
	var regex = /^[0-9]*$/;
	return regex.test(numeroDeContactoCliente);
}


function guardarFila(button) {
	var fila = $(button).closest("tr");
	var id = fila.find(".id").val();
	var nombreCliente = fila.find(".nombreCliente").val();
	var tipoIDCliente = fila.find(".tipoIDClienteSelect").val();
	var numeroIDCliente = fila.find(".numeroIDCliente").val();
	var correoElectronicoCliente = fila.find(".correoElectronicoCliente").val();
	var numeroDeContactoCliente = fila.find(".numeroDeContactoCliente").val();
	var direccionCliente = fila.find(".direccionCliente").val();
	var adicionalCliente = fila.find(".adicionalCliente").val();


	mostrarModal();

	document.getElementById("btn-aceptar").addEventListener("click", function() {

		if (!validarNombre(nombreCliente)) {
			var alerta = document.createElement("div");
			alerta.innerHTML =
				'<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
				'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
				'</svg>' +
				' Nombre de Cliente Invalido.<br><br>El nombre del cliente solo debe tener letras.<br> (Se permiten las tíldes).<br><br>Ejemplo: William Orlando Pinzón <br><br>'
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
		} else {
			if (!validarIDCliente(numeroIDCliente)) {
				var alerta = document.createElement("div");
				alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
					'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
					'</svg>' +
					" Número de Documento Invalido!.<br><br>El número de documento solo debe <br>tener números. (Maximo 12 caracteres <br> sin caracteres especiales).<br><br>Ejemplo: 123456789";
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
			} else {
				if (!validarCorreoElectronicoCliente(correoElectronicoCliente)) {
					var alerta = document.createElement("div");
					alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
						'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
						'</svg>' +
						" Correo electronico Invalido!.<br><br>El correo electronico debe ser en<br> formato email. (No caracteres especiales).<br><br>Ejemplo: info@refugiodelsisga.com";
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
				} else {
					if (!validarNumeroDeContactoCliente(numeroDeContactoCliente)) {
						var alerta = document.createElement("div");
						alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
							'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
							'</svg>' +
							" Número de Contacto Invalido!.<br><br>El número de Contacto solo debe<br> tener números. (No caracteres especiales).<br><br>Ejemplo: 3105734578";
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
				}
			}
		}








		const nombre = nombreCliente.trim(); // Obtener el valor y eliminar espacios en blanco al principio y al final
		if (nombre.length > 0) {
			const palabras = nombre.split(" "); // Dividir la cadena en palabras
			const palabrasCapitalizadas = palabras.map(function(palabra) {
				return palabra.charAt(0).toUpperCase() + palabra.slice(1).toLowerCase();
			});
			const nombreFormateado = palabrasCapitalizadas.join(" "); // Unir las palabras nuevamente
			nombreCliente = nombreFormateado; // Establecer el valor formateado en el campo de entrada
		}


		// Crear un formulario oculto
		var form = document.createElement("form");
		form.method = "POST";
		form.action = "/editarCliente";

		// Crear campos de entrada ocultos para enviar los valores editados
		var idInput = document.createElement("input");
		idInput.type = "hidden";
		idInput.name = "id";
		idInput.value = id;

		var nombreClienteInput = document.createElement("input");
		nombreClienteInput.type = "hidden";
		nombreClienteInput.name = "nombreCliente";
		nombreClienteInput.value = nombreCliente;

		var tipoIDClienteInput = document.createElement("input");
		tipoIDClienteInput.type = "hidden";
		tipoIDClienteInput.name = "tipoIDCliente";
		tipoIDClienteInput.value = tipoIDCliente;

		var numeroIDClienteInput = document.createElement("input");
		numeroIDClienteInput.type = "hidden";
		numeroIDClienteInput.name = "numeroIDCliente";
		numeroIDClienteInput.value = numeroIDCliente;

		var correoElectronicoClienteInput = document.createElement("input");
		correoElectronicoClienteInput.type = "hidden";
		correoElectronicoClienteInput.name = "correoElectronicoCliente";
		correoElectronicoClienteInput.value = correoElectronicoCliente;

		var numeroDeContactoClienteInput = document.createElement("input");
		numeroDeContactoClienteInput.type = "hidden";
		numeroDeContactoClienteInput.name = "numeroDeContactoCliente";
		numeroDeContactoClienteInput.value = numeroDeContactoCliente;

		var direccionClienteInput = document.createElement("input");
		direccionClienteInput.type = "hidden";
		direccionClienteInput.name = "direccionCliente";
		direccionClienteInput.value = direccionCliente;

		var adicionalClienteInput = document.createElement("input");
		adicionalClienteInput.type = "hidden";
		adicionalClienteInput.name = "adicionalCliente";
		adicionalClienteInput.value = adicionalCliente;

		// Agregar los campos de entrada al formulario
		form.appendChild(idInput);
		form.appendChild(nombreClienteInput);
		form.appendChild(tipoIDClienteInput);
		form.appendChild(numeroIDClienteInput);
		form.appendChild(correoElectronicoClienteInput);
		form.appendChild(numeroDeContactoClienteInput);
		form.appendChild(direccionClienteInput);
		form.appendChild(adicionalClienteInput);

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
