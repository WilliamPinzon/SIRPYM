function ocultarModalConfirmacion() {
    var modal = document.getElementById("modal-confirmacion");
    modal.style.display = "none";
}

document.getElementById("btn-aceptar").addEventListener("click", function() {
    const tabla2Body = document.getElementById('tabla2Body');
    const rows = tabla2Body.querySelectorAll('tr');
	const fechaInput = document.getElementById('fecha2');
	const fechaValue = fechaInput.value;
	
	// Extraer el año, mes y semana de la fecha
	const parts = fechaValue.split('-W'); // Dividir la cadena en partes usando "-W" como separador
	const year = parseInt(parts[0]); // Extraer el año
	const week = parseInt(parts[1]); // Extraer la semana
	
	// Calcular el primer día de la semana
	const firstDayOfYear = new Date(year, 0, 1); // 1 de enero del año dado
	const firstDayOfGivenWeek = new Date(firstDayOfYear.getTime() + ((week - 1) * 7 * 24 * 60 * 60 * 1000)); // Primer día de la semana dada
	const month = firstDayOfGivenWeek.getMonth() + 1; // Obtener el mes (los meses en JavaScript son indexados desde 0)
	
	console.log("Año: " + year + ", Mes: " + month + ", Semana: " + week);


	const fecha = getStartDateOfWeek(year, week); // Función para obtener la fecha de inicio de la semana
	


    if (rows.length === 0) {
        window.location.href = "/NominaDiaria?error";
        return; // Detener la ejecución si no hay registros
    } else if (fecha === "") {
        window.location.href = "/NominaDiaria?errorFecha";
        return;
    }
    

	const registros = [];
	rows.forEach(row => {
	    const nombreItem = row.cells[1].textContent;
	    const unidad = row.cells[2].textContent;
	   	const disponibles = row.cells[3].querySelector('input').value; // Obtener el valor del input
	    const producidos = row.cells[4].querySelector('input').value; // Obtener el valor del input
	    const stockActual = row.cells[5].querySelector('input').value; // Obtener el valor del input
	    const ventaTotal = row.cells[6].querySelector('input').value; // Obtener el valor del input
	
	    // Agregar los datos al arreglo de registros
	    registros.push({
	        fechaRegistroSemanal: fecha,
	        anho: year,
	        mes: month,
	        semana: week,
	        nombreItem: nombreItem,
	        unidad: unidad,
	        disponibles: disponibles,
	        producidos: producidos,
	        stockActual: stockActual,
	        ventaTotal: ventaTotal
	    });
	});

// Función para obtener la fecha de inicio de la semana
function getStartDateOfWeek(year, week) {
    const simple = new Date(year, 0, 1 + (week - 1) * 7);
    const dow = simple.getDay();
    const ISOweekStart = simple;
    if (dow <= 4) {
        ISOweekStart.setDate(simple.getDate() - simple.getDay() + 1);
    } else {
        ISOweekStart.setDate(simple.getDate() + 8 - simple.getDay());
    }
    return ISOweekStart.toISOString().split('T')[0];
}

    // Enviar los registros al backend solo si hay registros
    if (registros.length > 0) {
        guardarRegistros(registros);
    }
});

function guardarRegistros(registros) {
    fetch('/guardar-registrosSemanales', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(registros)
    })
    .then(response => {
        if (response.ok) {
            window.location.href = "/RegistroSemanal?exito";
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
        window.location.href = "/RegistroSemanal?error";
        return; // Detener la ejecución si no hay registros
    } else if (fecha === "") {
		ocultarModalConfirmacion();
        window.location.href = "/RegistroSemanal?errorFecha";
        return;
    }else{
		var modal = document.getElementById("modal-confirmacion");
	    modal.style.display = "block";
	    return false;
	}
    
}
