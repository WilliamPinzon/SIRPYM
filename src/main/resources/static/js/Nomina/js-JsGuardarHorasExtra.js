function ocultarModalConfirmacion() {
    var modal = document.getElementById("modal-confirmacion");
    modal.style.display = "none";
}

document.getElementById("btn-aceptar").addEventListener("click", function() {
    const tabla2Body = document.getElementById('tabla2Body');
    const rows = tabla2Body.querySelectorAll('tr');
    const fechaInput = document.getElementById('fecha');
    const fecha = fechaInput.value;

    if (rows.length === 0) {
        window.location.href = "/NominaHorasExtra?error";
        return; // Detener la ejecución si no hay registros
    } else if (fecha === "") {
        window.location.href = "/NominaHorasExtra?errorFecha";
        return;
    }

    const registros = [];
    rows.forEach(row => {
        const nombre = row.cells[1].textContent;
        const horaIngreso = row.querySelector('.hora-ingreso').value;
        const horaSalida = row.querySelector('.hora-salida').value;
        const totalExtra = row.querySelector('.total-extra').value;

        registros.push({
            nombreCompleto: nombre,
            horaDeIngreso: horaIngreso,
            horaDeSalida: totalExtra,
            totalHoraExtra: horaSalida,
            fechaDeRegistroNomina: fecha // Agregar la fecha al registro
        });
    });

    // Enviar los registros al backend solo si hay registros
    if (registros.length > 0) {
        guardarRegistros(registros);
    }
});

function guardarRegistros(registros) {
    fetch('/guardar-registros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(registros)
    })
    .then(response => {
        if (response.ok) {
            window.location.href = "/NominaHorasExtra?exito";
        } else {
            console.error('Error al guardar los registros:', response.statusText);
        }
    })
    .catch(error => {
        console.error('Error en la solicitud fetch:', error);
    });
    ocultarModalConfirmacion();
}


document.getElementById("btn-cancelar").addEventListener("click", function() {
    ocultarModalConfirmacion();
});

document.getElementById("btn-close").addEventListener("click", function() {
    ocultarModalConfirmacion();
});

const guardarRegistrosBtn = document.getElementById('guardarRegistrosBtn');
guardarRegistrosBtn.addEventListener('click', function() {
    mostrarModalConfirmacion();
});

function mostrarModalConfirmacion() {
	
    const rows = tabla2Body.querySelectorAll('tr');
    const fechaInput = document.getElementById('fecha');
    const fecha = fechaInput.value;

    if (rows.length === 0) {
		ocultarModalConfirmacion();
        window.location.href = "/NominaHorasExtra?error";
        return; // Detener la ejecución si no hay registros
    } else if (fecha === "") {
		ocultarModalConfirmacion();
        window.location.href = "/NominaHorasExtra?errorFecha";
        return;
    }else{
		var modal = document.getElementById("modal-confirmacion");
	    modal.style.display = "block";
	    return false;
	}
    
}
