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
        window.location.href = "/NominaDiaria?error";
        return; // Detener la ejecución si no hay registros
    } else if (fecha === "") {
        window.location.href = "/NominaDiaria?errorFecha";
        return;
    }

    const registros = [];
    rows.forEach(row => {
        const nombre = row.cells[1].textContent;
        const cargo = row.cells[2].textContent;
        const valorTotal = row.querySelector('.valor-total').value;
        const diaLaborado = row.querySelector('.dia-laborado').value;
        
        var valDia = 0;
        
        if (diaLaborado === "completo") {
		    valDia = 1;
		} else if (diaLaborado === "medio") {
		    valDia = 0.5;
		}

        registros.push({
			fechaDeRegistroNomina: fecha,
            nombreCompleto: nombre,
            cargo: cargo,
            diaLaborado: valDia,
            valorACancelar: valorTotal
            // Agregar la fecha al registro
        });
    });

    // Enviar los registros al backend solo si hay registros
    if (registros.length > 0) {
        guardarRegistros(registros);
    }
});

function guardarRegistros(registros) {
    fetch('/guardar-registrosNominaDiaria', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(registros)
    })
    .then(response => {
        if (response.ok) {
            window.location.href = "/NominaDiaria?exito";
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
        window.location.href = "/NominaDiaria?error";
        return; // Detener la ejecución si no hay registros
    } else if (fecha === "") {
		ocultarModalConfirmacion();
        window.location.href = "/NominaDiaria?errorFecha";
        return;
    }else{
		var modal = document.getElementById("modal-confirmacion");
	    modal.style.display = "block";
	    return false;
	}
    
}
