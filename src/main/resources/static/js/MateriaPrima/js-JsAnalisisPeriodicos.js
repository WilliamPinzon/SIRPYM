for (var year = 2024; year <= 2050; year++) {
	document.getElementById("fechaAño").innerHTML += "<option value='" + year + "'>" + year + "</option>";
}
													
function mostrarOcultarGrafico() {
	var graficoContainer = document.getElementById('graficoContainer');
	var boton = document.getElementById('showChartBtn');

	if (graficoContainer.style.display === 'none') {
		graficoContainer.style.display = 'block';
		boton.textContent = 'Ocultar Gráfico';
		// Llamar a la función para generar el gráfico
		generarGrafico();
	} else {
		graficoContainer.style.display = 'none';
		boton.textContent = 'Mostrar Gráfica';
	}
}
					
function mostrarOcultarGrafico2() {
	var graficoContainer = document.getElementById('graficoContainer2');
	var boton = document.getElementById('showChartBtn2');

	if (graficoContainer.style.display === 'none') {
		graficoContainer.style.display = 'block';
		boton.textContent = 'Ocultar Gráfica';
		// Llamar a la función para generar el gráfico
		generarGraficoAño();
	} else {
		graficoContainer.style.display = 'none';
		boton.textContent = 'Mostrar Gráfico';
	}
}

function cambiarTipoFiltro() {
	var tipoFiltro = document.getElementById('tipoFiltro').value;
	var filtroMes = document.getElementById('filtroMes');
	var filtroAño = document.getElementById('filtroAño');

	var tablaMes = document.getElementById('tabla1'); // Obtener la referencia a la tabla de mes
	var tablaAño = document.getElementById('tabla1'); // Obtener la referencia a la tabla de mes

	var graficaMes = document.getElementById('graficoContainer'); // Obtener la referencia a la tabla de mes
	var graficaAño = document.getElementById('graficoContainer2'); // Obtener la referencia a la tabla de mes

	var botonMes = document.getElementById('showChartBtn');
	var botonAño = document.getElementById('showChartBtn2');

	var InfoMes = document.getElementById('InfoMes');
	var InfoAño = document.getElementById('InfoAño');

	if (tipoFiltro === 'mes') {
		filtroMes.style.display = 'block';
		filtroAño.style.display = 'none';

		botonMes.style.display = 'block';
		botonAño.style.display = 'none';

		tablaAño.style.display = 'none'; // Ocultar la tabla de mes
		graficaAño.style.display = 'none'; // Ocultar la tabla de mes

		tablaMes.style.display = 'block'; // Ocultar la tabla de mes
		graficaMes.style.display = 'none'; // Ocultar la tabla de mes

		InfoMes.style.display = 'block'; // Ocultar la tabla de mes
		InfoAño.style.display = 'none'; // Ocultar la tabla de mes


	} else if (tipoFiltro === 'año') {
		filtroMes.style.display = 'none';
		filtroAño.style.display = 'block';

		botonMes.style.display = 'none';
		botonAño.style.display = 'block';

		tablaAño.style.display = 'block'; // Ocultar la tabla de mes
		graficaAño.style.display = 'none'; // Ocultar la tabla de mes

		tablaMes.style.display = 'none'; // Ocultar la tabla de mes
		graficaMes.style.display = 'none'; // Ocultar la tabla de mes

		InfoMes.style.display = 'none'; // Ocultar la tabla de mes
		InfoAño.style.display = 'block'; // Ocultar la tabla de mes
	}
}


function getWeekNumber(d) {
	// Ajustar al primer día de la semana (lunes)
	d.setHours(0, 0, 0, 0);
	d.setDate(d.getDate() + 4 - (d.getDay() || 7));
	// Calcular el primer jueves del año
	var yearStart = new Date(d.getFullYear(), 0, 1);
	var weekNumber = Math.ceil((((d - yearStart) / 86400000) + 1) / 7);
	return weekNumber;
}

function aplicarFiltro() {
	var tipoFiltro = document.getElementById('tipoFiltro').value;
	var fecha;

	if (tipoFiltro === 'mes') {
		fecha = document.getElementById('fechaMes').value;

		var año = parseInt(fecha.split("-")[0]);
		var mes = parseInt(fecha.split("-")[1]);

		// Realizar petición al servidor con el año y mes seleccionados
		fetch(`/verSemanaRegistroSemanalPorMes?año=${año}&mes=${mes}`)
			.then(response => {
				if (!response.ok) {
					throw new Error('Hubo un problema al obtener los datos.');
				}
				return response.json();
			})
			.then(data => {
				// Mostrar los datos obtenidos
				console.log(data);
				mostrarProductos(data);
				// Regenerar el gráfico con los nuevos datos
				generarGrafico();
			})
			.catch(error => console.error('Error:', error));
	} else if (tipoFiltro === 'año') {
		fecha = document.getElementById('fechaAño').value;
		var año = fecha;

		// Realizar petición al servidor con el año y mes seleccionados
		fetch(`/verSemanaRegistroSemanalPorAnho?año=${año}`)
			.then(response => {
				if (!response.ok) {
					throw new Error('Hubo un problema al obtener los datos.');
				}
				return response.json();
			})
			.then(data => {
				// Mostrar los datos obtenidos
				console.log(data);
				mostrarProductosAño(data);
				// Regenerar el gráfico con los nuevos datos
				generarGraficoAño();
			})
			.catch(error => console.error('Error:', error));
	}
}

function mostrarProductos(registrosMensuales) {
	var tablaBody = document.getElementById("mainTableBody");
	tablaBody.innerHTML = ""; // Limpiar la tabla antes de agregar nuevos datos

	// Objeto para almacenar los registros agrupados por nombre del producto
	var registrosAgrupados = {};

	// Agrupar los registros por nombre del producto y semana
	registrosMensuales.forEach(function (registro) {
		if (!registrosAgrupados[registro.nombreItem]) {
			registrosAgrupados[registro.nombreItem] = {};
		}
		if (!registrosAgrupados[registro.nombreItem][registro.semana]) {
			registrosAgrupados[registro.nombreItem][registro.semana] = registro.ventaTotal;
		} else {
			registrosAgrupados[registro.nombreItem][registro.semana] += registro.ventaTotal;
		}
	});

	// Obtener las semanas únicas presentes en los registros
	var semanas = [...new Set(registrosMensuales.map(registro => registro.semana))];

	// Crear la fila de encabezado de la tabla
	var headerRow = document.createElement("tr");
	headerRow.innerHTML = `<th scope="col">Item</th><th scope="col">Unidad</th>`;
	semanas.forEach(semana => {
		headerRow.innerHTML += `<th scope="col">Semana ${semana}</th>`;
	});
	headerRow.innerHTML += `<th scope="col">Venta Total</th>`;
	tablaBody.appendChild(headerRow);

	// Iterar sobre los registros agrupados para construir las filas de la tabla
	Object.keys(registrosAgrupados).forEach(function (nombreProducto) {
		var row = document.createElement("tr");
		row.innerHTML = `<td>${nombreProducto}</td>`;
	
		// Agregar la unidad en la segunda columna
		row.innerHTML += `<td>${registrosMensuales.find(registro => registro.nombreItem === nombreProducto).unidad}</td>`;
	
		// Iterar sobre las semanas para mostrar los valores de venta total
		semanas.forEach(semana => {
			var ventaTotal = registrosAgrupados[nombreProducto][semana] || 0; // Obtener el valor de venta total de la semana actual
			row.innerHTML += `<td data-semana="${semana}">${ventaTotal}</td>`; // Agregar el atributo data-semana
		});
	
		// Calcular la venta total para todas las semanas
		var ventaTotalTotal = Object.values(registrosAgrupados[nombreProducto]).reduce((acc, curr) => acc + curr, 0);
		row.innerHTML += `<td>${ventaTotalTotal}</td>`;
	
		tablaBody.appendChild(row);
	});

	// Actualizar el número de semana seleccionada en el span correspondiente
	var semanaSeleccionadaSpan = document.getElementById("semanaSeleccionada");
	semanaSeleccionadaSpan.textContent = ""; // Limpiar el contenido anterior
}


function generarGrafico() {
	var table = document.getElementById('mainTableBody');
	var labels = [];
	var datasets = [];

	// Recorrer las filas de la tabla para obtener los datos
	for (var i = 1; i < table.rows.length; i++) {
		var row = table.rows[i];
		var producto = row.cells[0].innerText; // Obtener el nombre del producto

		// Recopilar las ventas de cada semana para el producto actual
		var ventas = [];
		for (var j = 2; j < row.cells.length - 1; j++) { // Excluir la primera y última columna
			var semana = row.cells[j].getAttribute('data-semana');
			var venta = parseInt(row.cells[j].innerText); // Obtener el valor de ventas y convertirlo a entero
			ventas.push(venta);
			if (i === 1) { // Solo agregar una etiqueta para el primer producto para evitar duplicados
				labels.push('Semana ' + semana);
			}
		}

		// Agregar un conjunto de datos para el producto actual
		datasets.push({
			label: producto,
			data: ventas,
			backgroundColor: getRandomColor(), // Obtener un color aleatorio para cada conjunto de datos
			borderColor: getRandomColor(),
			borderWidth: 1
		});
	}

	// Mostrar la gráfica
	var ctx = document.getElementById('salesChart').getContext('2d');
	if (window.myChart) {
		window.myChart.destroy(); // Destruir el gráfico anterior si existe
	}
	window.myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: labels,
			datasets: datasets
		},
		options: {
			scales: {
				xAxes: [{
					scaleLabel: {
						display: true,
						labelString: 'Semanas', // Etiqueta del eje X
						fontSize: 14 // Tamaño de la fuente de la etiqueta del eje X
					}
				}],
				yAxes: [{
					scaleLabel: {
						display: true,
						labelString: 'Ventas', // Etiqueta del eje Y
						fontSize: 14 // Tamaño de la fuente de la etiqueta del eje Y
					},
					ticks: {
						beginAtZero: true
					}
				}]
			}
		}
	});
}

function mostrarProductosAño(registrosMensuales) {
	var tablaBody = document.getElementById("mainTableBody2");
	tablaBody.innerHTML = ""; // Limpiar la tabla antes de agregar nuevos datos

	// Objeto para almacenar los registros agrupados por nombre del producto
	var registrosAgrupados = {};

	// Agrupar los registros por nombre del producto y mes
	registrosMensuales.forEach(function (registro) {
		if (!registrosAgrupados[registro.nombreItem]) {
			registrosAgrupados[registro.nombreItem] = {};
		}
	
	var mes = registro.mes; // Obtener el mes del registro
		if (!registrosAgrupados[registro.nombreItem][mes]) {
			registrosAgrupados[registro.nombreItem][mes] = registro.ventaTotal;
		} else {
			registrosAgrupados[registro.nombreItem][mes] += registro.ventaTotal;
		}
	});

	// Obtener los meses únicos presentes en los registros
	var meses = [...new Set(registrosMensuales.map(registro => registro.mes))];

	// Array con los nombres de los meses
	var nombresMeses = [
		"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
		"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
	];

	// Crear la fila de encabezado de la tabla
	var headerRow = document.createElement("tr");
	headerRow.innerHTML = `<th scope="col">Item</th><th scope="col">Unidad</th>`;
	meses.forEach(mes => {
		var nombreMes = nombresMeses[mes - 1]; // Restamos 1 porque los meses se cuentan desde 0 en el array
		headerRow.innerHTML += `<th scope="col" id="mesNombre">${nombreMes}</th>`;
	});
	headerRow.innerHTML += `<th scope="col">Venta Total</th>`;
	tablaBody.appendChild(headerRow);

	// Iterar sobre los registros agrupados para construir las filas de la tabla
	Object.keys(registrosAgrupados).forEach(function (nombreProducto) {
		var row = document.createElement("tr");
		row.innerHTML = `<td>${nombreProducto}</td>`;

		// Agregar la unidad en la segunda columna
		row.innerHTML += `<td>${registrosMensuales.find(registro => registro.nombreItem === nombreProducto).unidad}</td>`;

		// Variable para almacenar el total de ventas por año
		var totalAnual = 0;

		// Iterar sobre los meses para mostrar los valores de venta total
		meses.forEach(mes => {
			var ventaTotal = registrosAgrupados[nombreProducto][mes] || 0; // Obtener el valor de venta total del mes actual
			row.innerHTML += `<td>${ventaTotal}</td>`;
			totalAnual += ventaTotal; // Sumar al total anual
		});

		// Agregar el total anual como última celda
		row.innerHTML += `<td>${totalAnual}</td>`;

		tablaBody.appendChild(row);
	});

	// Actualizar el número de semana seleccionada en el span correspondiente
	var semanaSeleccionadaSpan = document.getElementById("semanaSeleccionada2");
	semanaSeleccionadaSpan.textContent = ""; // Limpiar el contenido anterior
}

function generarGraficoAño() {
    var table = document.getElementById('mainTableBody2');
    var labels = [];
    var datasets = [];

	// Obtener los nombres de las columnas
	var nombresColumnas = [];
	for (var j = 2; j < table.rows[0].cells.length - 1; j++) {
	    nombresColumnas.push(table.rows[0].cells[j].innerText);
	}
	
	// Recorrer las filas de la tabla para obtener los datos
	for (var i = 1; i < table.rows.length; i++) {
	    var row = table.rows[i];
	    var producto = row.cells[0].innerText; // Obtener el nombre del producto
	
	    // Recopilar las ventas de cada mes para el producto actual
	    var ventas = [];
	    for (var j = 2; j < row.cells.length - 1; j++) { // Excluir la primera y última columna
	        var venta = parseInt(row.cells[j].innerText); // Obtener el valor de ventas y convertirlo a entero
	        ventas.push(venta);
	    }
	
	    // Agregar un conjunto de datos para el producto actual
	    datasets.push({
	        label: producto,
	        data: ventas,
	        backgroundColor: getRandomColor(), // Obtener un color aleatorio para cada conjunto de datos
	        borderColor: getRandomColor(),
	        borderWidth: 1
	    });
	}
	
	// Agregar los nombres de las columnas como etiquetas
	labels = nombresColumnas;


    // Mostrar la gráfica
    var ctx = document.getElementById('salesChart2').getContext('2d');
    if (window.myChart) {
        window.myChart.destroy(); // Destruir el gráfico anterior si existe
    }
    window.myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: datasets
        },
        options: {
            scales: {
                xAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Meses', // Etiqueta del eje X
                        fontSize: 14 // Tamaño de la fuente de la etiqueta del eje X
                    }
                }],
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'Ventas', // Etiqueta del eje Y
                        fontSize: 14 // Tamaño de la fuente de la etiqueta del eje Y
                    },
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
}


// Función para generar un color aleatorio en formato RGBA
function getRandomColor() {
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return 'rgba(' + r + ',' + g + ',' + b + ', 0.5)';
}

// Agregar un manejador de eventos al botón "Mostrar Gráfica"
document.getElementById('showChartBtn').addEventListener('click', function () {
	generarGrafico(); // Llamar a la función para generar el gráfico
});

// Agregar un manejador de eventos al botón "Mostrar Gráfica"
document.getElementById('showChartBtn2').addEventListener('click', function () {
	generarGraficoAño(); // Llamar a la función para generar el gráfico
});

// Llamar a las funciones para generar los gráficos cuando se carga la página
window.onload = function () {
	generarGrafico();
	generarGraficoAño();
};