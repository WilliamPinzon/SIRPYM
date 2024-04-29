function mostrarSemana() {
	var fechaInput = document.getElementById("fecha");
	var semanaSeleccionada = document.getElementById("semanaSeleccionada");
	var semana = fechaInput.value.split("-W")[1];
	semanaSeleccionada.textContent = semana;
}
								
function filtrarPorSemana() {
	var fechaDeRegistroNomina = document.getElementById("fecha").value;
	var año = fechaDeRegistroNomina.split("-W")[0];
	var semana = fechaDeRegistroNomina.split("-W")[1];
	
	// Realizar petición al servidor con el año y semana seleccionados
	fetch(`/verSemanaRegistroSemanal?año=${año}&semana=${semana}`)
		.then(response => {
	
		if (!response.ok) {
			throw new Error('Hubo un problema al obtener los datos.');
		}
		return response.json();
	})
		.then(data => {
		// Mostrar los colaboradores en la tabla
			mostrarProductos(data);
		})
	.catch(error => console.error('Error:', error));
}

function mostrarProductos(registrosSemanales) {
	var tablaBody = document.getElementById("mainTableBody");
	tablaBody.innerHTML = ""; // Limpiar la tabla antes de agregar nuevos datos

	// Verificar si la lista de registros semanales está vacía
	if (registrosSemanales.length === 0) {
		// Si está vacía, quitar el atributo readonly de los inputs en la tabla 2
		var tabla2Inputs = document.querySelectorAll("#tabla2Body input[type='number']");
		tabla2Inputs.forEach(function (input) {
			input.removeAttribute("readonly");
		});
	}

	registrosSemanales.forEach(function (registro, index) {
		var row = document.createElement("tr");

		row.innerHTML = `
            <td>${index + 1}</td>
            <td>${registro.nombreItem}</td>
            <td>${registro.unidad}</td>
            <td>${registro.disponibles}</td>
            <td>${registro.producidos}</td>
            <td>${registro.stockActual}</td>
            <td>${registro.ventaTotal}</td>
        `;
	tablaBody.appendChild(row);

	});
}

