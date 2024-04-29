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

function validateNombre(input) {
	const regex = /^[a-zA-Z\u00C0-\u017F ]*$/;
	if (!regex.test(input.value)) {
		var alerta = document.createElement("div");
		alerta.innerHTML =
			'<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">' +
			'  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>' +
			'</svg>' +
			' Nombre de Contrato Invalido.<br><br>El nombre del Contrato solo debe tener letras.<br> (Se permiten las tíldes).<br><br>Ejemplo: William Orlando Pinzón <br><br>'
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
		input.focus();
	}
}

function capitalizeEachWord(input) {
    const nombre = input.value.trim();
    if (nombre.length > 0) {
        const palabras = nombre.split(" ");
        const palabrasCapitalizadas = palabras.map(function (palabra) {
            return palabra.charAt(0).toUpperCase() + palabra.slice(1).toLowerCase();
        });
        const nombreFormateado = palabrasCapitalizadas.join(" ");
        input.value = nombreFormateado;
    }
}


function updateValues(transporteInput, totalInput) {
    const transporte = parseFloat(transporteInput.value);
    const total = parseFloat(totalInput.value);

    if (isNaN(transporte) || isNaN(total)) {
        document.getElementById("valorDeBase").value = "";
    } else {
        const base = total - transporte;
        document.getElementById("valorDeBase").value = base.toFixed(2);
    }
}


function mostrarModalConfirmacion() {
	var modal = document.getElementById("modal-confirmacion");
	modal.style.display = "block";
	return false;
}

function ocultarModalConfirmacion() {
	var modal = document.getElementById("modal-confirmacion");
	modal.style.display = "none";
}

document.getElementById("btn-aceptar").addEventListener("click", function() {
	var formularioRegistro = document.querySelector('form');
	formularioRegistro.submit();
	ocultarModalConfirmacion();
});

document.getElementById("btn-cancelar").addEventListener("click", function() {
	ocultarModalConfirmacion();
});

document.getElementById("btn-close").addEventListener("click", function() {
	ocultarModalConfirmacion();
});

function borrar() {
	const tipoDeCargoInput = document.getElementById("tipoDeCargo");
	const descripcionInput = document.getElementById("descripcion");
	const valorDeTransporteInput = document.getElementById("valorDeTransporte");
	const valorDeBaseInput = document.getElementById("valorDeBase");
	const valorTotalInput = document.getElementById("valorTotal");

	tipoDeCargoInput.value = "";
	descripcionInput.value = "";
	valorDeTransporteInput.value = "";
	valorDeBaseInput.value = "";
	valorTotalInput.value = "";

	tipoDeCargoInput.focus();
}