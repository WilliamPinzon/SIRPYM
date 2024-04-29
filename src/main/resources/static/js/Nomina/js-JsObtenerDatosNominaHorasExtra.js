		function filtrarPorMes() {
			var fechaDeRegistroNomina = document.getElementById("fechaDeRegistroNomina").value;
			var año = fechaDeRegistroNomina.split("-")[0];
			var mes = fechaDeRegistroNomina.split("-")[1];
			// Realizar petición al servidor con el año y mes seleccionados
			fetch(`/verInformeMensualNominaHorasExtra?año=${año}&mes=${mes}`)
				.then(response => {
					if (!response.ok) {
						throw new Error('Hubo un problema al obtener los datos.');
					}
					return response.json();
				})
				.then(data => {
					// Mostrar los colaboradores en la tabla
					mostrarColaboradores(data);
				})
				.catch(error => console.error('Error:', error));
		}



		function mostrarColaboradores(colaboradores) {
			var tablaBody = document.getElementById("mainTableBody");
			tablaBody.innerHTML = ""; // Limpiar la tabla antes de agregar nuevos datos

			colaboradores.forEach(function (colaborador, index) {
				var row = document.createElement("tr");

				var valor = parseFloat(colaborador.diaLaborado);
				var valorFormateado = valor.toLocaleString('es-CO', {style: 'currency', currency: 'COP', minimumFractionDigits: 0});


				row.innerHTML = `
                    <td>${index + 1}</td>
                    <td>${colaborador.nombreCompleto}</td>
                    <td>${colaborador.totalHoraExtra}</td>
                  `;
				tablaBody.appendChild(row);
			});
		}