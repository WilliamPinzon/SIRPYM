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

function validateNombre(input) {
	const regex = /^[a-zA-Z\u00C0-\u017F ]*$/;
	if (!regex.test(input.value)) {
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
		input.value = "";
		const incProductoInput = document.getElementById("incProducto");
		const baseProductoInput = document.getElementById("baseProducto");
		incProductoInput.value = "";
		baseProductoInput.value = "";
		input.focus();
	}
}

function capitalizeEachWord(input) {
    const nombre = input.value.trim(); // Obtener el valor y eliminar espacios en blanco al principio y al final
    if (nombre.length > 0) {
        const palabras = nombre.split(" "); // Dividir la cadena en palabras
        const palabrasCapitalizadas = palabras.map(function (palabra) {
            return palabra.charAt(0).toUpperCase() + palabra.slice(1).toLowerCase();
        });
        const nombreFormateado = palabrasCapitalizadas.join(" "); // Unir las palabras nuevamente
        input.value = nombreFormateado; // Establecer el valor formateado en el campo de entrada
    }
}


function validarCorreoElectronicoCliente(input) {
	const regex = /^[\w\.-]+@[\w\.-]+\.\w+$/;
	if (!regex.test(input.value)) {
		var alerta = document.createElement("div");
		alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
			'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
			'</svg>' +
			" Correo electronico Invalido!.<br><br>El correo electronico debe ser en<br> formato email. (No caracteres especiales).<br><br>Ejemplo: info@refugiodelsisga.com";
			alerta.className = "alert-email alert";
		alerta.style.color = "rgb(0, 0, 64)";
		document.body.appendChild(alerta);
		setTimeout(function() {
			alerta.style.display = 'none';
		}, 10000);
		setTimeout(function() {
			alertaExito.style.animation = '';
		}, 20);
		input.value = "";
		input.focus();
	}
}

function validateNumID(input) {
	const regex = /^[0-9]*$/;
	
	if (!regex.test(input.value) || input.value.toString().length > 12) {
		var alerta = document.createElement("div");
		alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
				'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
				'</svg>' +
				" Número de Documento Invalido!.<br><br>El número de documento solo debe <br>tener números. (Maximo 12 caracteres <br> sin caracteres especiales).<br><br>Ejemplo: 123456789";
			alerta.className = "alert-numID alert";
		alerta.style.color = "rgb(0, 0, 64)";
		document.body.appendChild(alerta);
		setTimeout(function() {
			alerta.style.display = 'none';
		}, 10000);
		setTimeout(function() {
			alertaExito.style.animation = '';
		}, 20);
		input.value = "";
		input.focus();
	}
}

function validateNumContacto(input) {
	const regex = /^[0-9]*$/;
	if (!regex.test(input.value)) {
		var alerta = document.createElement("div");
		alerta.innerHTML = '<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
			'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
			'</svg>' +
			" Número de Contacto Invalido!.<br><br>El número de Contacto solo debe<br> tener números. (No caracteres especiales).<br><br>Ejemplo: 3105734578";
			alerta.className = "alert-numID alert";
		alerta.style.color = "rgb(0, 0, 64)";
		document.body.appendChild(alerta);
		setTimeout(function() {
			alerta.style.display = 'none';
		}, 10000);
		setTimeout(function() {
			alertaExito.style.animation = '';
		}, 20);
		input.value = "";
		input.focus();
	}
}


function mostrarModalConfirmacion() {
	var modal = document.getElementById("modal-confirmacion");
	modal.style.display = "block";
	return false; // Evita el envío del formulario por defecto
}

function ocultarModalConfirmacion() {
	var modal = document.getElementById("modal-confirmacion");
	modal.style.display = "none";
}

document.getElementById("btn-aceptar").addEventListener("click", function() {
	var formularioRegistro = document.querySelector('form');
	formularioRegistro.submit();
	ocultarModalConfirmacion(); // Cierra el modal después de enviar el formulario.
});

document.getElementById("btn-cancelar").addEventListener("click", function() {
	ocultarModalConfirmacion(); // Cierra el modal al hacer clic en "Cancelar"
});

document.getElementById("btn-close").addEventListener("click", function() {
	ocultarModalConfirmacion(); // Cierra el modal al hacer clic en la "x"
});

const formularioRegistro = document.getElementById('RegistroCliente');
formularioRegistro.addEventListener('submit', function(event) {
	event.preventDefault(); // Prevenimos el envío del formulario por defecto
	mostrarModalConfirmacion(); // Mostramos el modal de confirmación
});

function borrar() {
	// Obtener los elementos de entrada
	const nombreClienteInput = document.getElementById("nombreCliente");
	const tipoIDClienteInput = document.getElementById("tipoIDCliente");
	const numeroIDClienteInput = document.getElementById("numeroIDCliente");
	const correoElectronicoCliente = document.getElementById("correoElectronicoCliente");
	const numeroDeContactoCliente = document.getElementById("numeroDeContactoCliente");
	const direccionClienteInput = document.getElementById("direccionCliente");
	const adicionalCliente = document.getElementById("adicionalCliente");

	// Limpiar los valores de los campos de entrada
	nombreClienteInput.value = "";
	tipoIDClienteInput.value = "";
	numeroIDClienteInput.value = "";
	correoElectronicoCliente.value = "";
	numeroDeContactoCliente.value = "";
	direccionClienteInput.value = "";
	adicionalCliente.value = "";

	// Opcional: colocar el foco en el primer campo de entrada después de limpiar
	nombreClienteInput.focus();
}