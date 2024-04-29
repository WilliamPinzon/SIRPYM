		function generarXLSX() {
			const tabla2Body = document.getElementById('tabla2Body');
			const rows = tabla2Body.querySelectorAll('tr');
			const fechaInput = document.getElementById('fecha');
			const fecha = fechaInput.value; // Obtener el valor de la fecha

			if (rows.length === 0) {
					window.location.href = "/NominaHorasExtra?error";
					return; // Detener la ejecución si no hay registros
				} else if (fechaInput.value === "") {
					window.location.href = "/NominaHorasExtra?errorFecha";
					return;
				}

			const data = [];

			// Agregar los encabezados como primera fila
			const headers = ["Nombre Del Colaborador", "Hora de Ingreso", "Hora de Salida", "Total Horas Extra"];
			data.push(headers);

			// Recopilar los datos de las filas
			// Recopilar los datos de las filas
			for (let i = 0; i < rows.length; i++) {
				const row = rows[i];
				const rowData = [];
				const cells = row.querySelectorAll('td');
				// Recopilar el nombre del colaborador
				const nombre = cells[1].textContent.trim();
				rowData.push(nombre);
				// Recopilar las horas de ingreso, salida y total horas extra
				const horaIngreso = row.querySelector('.hora-ingreso').value;
				const horaSalida = row.querySelector('.hora-salida').value;
				const totalExtra = row.querySelector('.total-extra').value;
				rowData.push(horaIngreso, horaSalida, totalExtra);
				// Agregar los datos al array
				data.push(rowData);
			}


			const ws = XLSX.utils.aoa_to_sheet(data);
			const wb = XLSX.utils.book_new();
			XLSX.utils.book_append_sheet(wb, ws, "Registros");

			const nombre = "Horas Extra " + fecha;
			XLSX.writeFile(wb, nombre + ".xlsx");	
		}

		const descargarBtn = document.getElementById('descargarRegistrosBtn');
		descargarBtn.addEventListener('click', generarXLSX);
