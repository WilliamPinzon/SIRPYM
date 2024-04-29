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
    <td>
        <button class="btn btn-primary" onclick="editarFila(this)"
											style="font-size: 12px;">
											<svg xmlns="http://www.w3.org/2000/svg" width="14" height="14"
												fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
												<path
													d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z" />
											</svg>
										</button>
										<button class="btn btn-success" onclick="guardarFila(this)" style="display: none; font-size: 12px;">
    <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-floppy" viewBox="0 0 16 16">
        <path d="M11 2H9v3h2V2Z" />
        <path d="M1.5 0h11.586a1.5 1.5 0 0 1 1.06.44l1.415 1.414A1.5 1.5 0 0 1 16 2.914V14.5a1.5 1.5 0 0 1-1.5 1.5h-13A1.5 1.5 0 0 1 0 14.5v-13A1.5 1.5 0 0 1 1.5 0ZM1 1.5v13a.5.5 0 0 0 .5.5H2v-4.5A1.5 1.5 0 0 1 3.5 9h9a1.5 1.5 0 0 1 1.5 1.5V15h.5a.5.5 0 0 0 .5-.5V2.914a.5.5 0 0 0-.146-.353l-1.415-1.415A.5.5 0 0 0 13.086 1H13v4.5A1.5 1.5 0 0 1 11.5 7h-7A1.5 1.5 0 0 1 3 5.5V1H1.5a.5.5 0 0 0-.5.5Zm3 4a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 .5-.5V1H4v4.5ZM3 15h10v-4.5a.5.5 0 0 0-.5-.5h-9a.5.5 0 0 0-.5.5V15Z" />
    </svg>
</button>
										

    </td>
    <td>
        <button class="btn btn-danger" onclick="eliminarCliente(this)"
											style="font-size: 12px;">
											<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
												fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
												<path
													d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z" />
												<path
													d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z" />
											</svg>
										</button>
    </td>
    <td>${index + 1}</td>
    <td class="nombre">${registro.nombreItem}</td>
    <td>${registro.unidad}</td>
    <td class="editable-cell id formatted-input" hidden>${registro.id}</td>
    
    <td class="id" hidden>${registro.id}</td>
    <td class="disponibles" hidden>${registro.disponibles}</td>
    <td class="producidos" hidden>${registro.producidos}</td>
    <td class="stockActual" hidden>${registro.stockActual}</td>
    <td class="ventaTotal" hidden>${registro.ventaTotal}</td>
    
<td class="editable-cell disponibles formatted-input" oninput="updateValues(this)">${parseFloat(registro.disponibles)}</td>
<td class="editable-cell producidos" oninput="updateValues(this)" >${parseFloat(registro.producidos)}</td>
<td class="editable-cell stockActual formatted-input" oninput="updateValues(this)" >${parseFloat(registro.stockActual)}</td>
<td class="editable-cell ventaTotal formatted-input" contenteditable="false">
    ${parseFloat(registro.ventaTotal)}
</td>


									
`;


										tablaBody.appendChild(row);

									});
								}
function updateValues(input) {
    var row = input.closest("tr");
    var disponibles = parseFloat(row.querySelector(".editable-cell.disponibles input").value);
    var producidos = parseFloat(row.querySelector(".editable-cell.producidos input").value);
    var stockActual = parseFloat(row.querySelector(".editable-cell.stockActual input").value);
    
    var ventaTotal = disponibles + producidos - stockActual;
    
    row.querySelector(".editable-cell.ventaTotal input").value = ventaTotal;
}


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

function validateDelete(input) {

	const alertaDelete = document.querySelector('.alert-delete');
	alertaDelete.style.animation = 'none';

	setTimeout(function() {
		alertaDelete.style.animation = '';
	}, 20);

	setTimeout(function() {
		alertaDelete.style.display = 'none';
	}, 10000);
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
    fila.find(".editable-cell").each(function() {
        var valorActual = $(this).text().trim();
        $(this).html(`<input type="number" class="form-control" value="${valorActual}">`);
    });
    fila.find(".btn-primary").hide();
    fila.find(".btn-success").show();
    
}

function guardarFila(button) {
    var fila = $(button).closest("tr");
    var id = fila.find(".id").text();
    var disponibles = fila.find(".editable-cell.disponibles input").val(); // Obtener el valor del input dentro de la celda editable
    var producidos = fila.find(".editable-cell.producidos input").val(); // Obtener el valor del input dentro de la celda editable
    var stockActual = fila.find(".editable-cell.stockActual input").val(); // Obtener el valor del input dentro de la celda editable
    var ventaTotal = fila.find(".editable-cell.ventaTotal input").val(); // Obtener el valor del input dentro de la celda editable
	
    console.log("Nuevo producidos: " + producidos);
    mostrarModal();
	
	console.log("id "+ id)
    mostrarModal();

    document.getElementById("btn-aceptar").addEventListener("click", function() {
        // Crear un formulario
        var form = document.createElement("form");
        form.method = "POST";
        form.action = "/editarRegistroSemanal";

        // Agregar campos al formulario
        var idInput = document.createElement("input");
        idInput.type = "hidden";
        idInput.name = "id";
        idInput.value = id;

        var disponiblesInput = document.createElement("input");
        disponiblesInput.type = "hidden";
        disponiblesInput.name = "disponibles";
        disponiblesInput.value = disponibles;

        var producidosInput = document.createElement("input");
        producidosInput.type = "hidden";
        producidosInput.name = "producidos";
        producidosInput.value = producidos;

        var stockActualInput = document.createElement("input");
        stockActualInput.type = "hidden";
        stockActualInput.name = "stockActual";
        stockActualInput.value = stockActual;
        
        var ventaTotalInput = document.createElement("input");
        ventaTotalInput.type = "hidden";
        ventaTotalInput.name = "ventaTotal";
        ventaTotalInput.value = ventaTotal;

        // Agregar campos al formulario
        form.appendChild(idInput);
        form.appendChild(disponiblesInput);
        form.appendChild(producidosInput);
        form.appendChild(stockActualInput);
        form.appendChild(ventaTotalInput);

        // Agregar el formulario al cuerpo del documento y enviarlo
        document.body.appendChild(form);
        form.submit();
        ocultarModal();
    });
    
    	document.getElementById("btn-cancelar").addEventListener("click", function() {
		fila.find(".btn-primary").show();
		fila.find(".btn-success").hide();
		fila.find(".editable-cell").prop("readonly", true);
		ocultarModal();
	});

	document.getElementById("btn-close").addEventListener("click", function() {
		fila.find(".btn-primary").show();
		fila.find(".btn-success").hide();
		fila.find(".editable-cell").prop("readonly", true);
		ocultarModal();
	});
}




function eliminarCliente(button) {
	var fila = $(button).closest("tr");
	var id = fila.find(".id").text();
	
	console.log("eli: " + id);
		    
	mostrarModalEliminar();
	
	document.getElementById("btn-aceptarF").addEventListener("click", function() {
        $.ajax({
            type: "POST",
            url: "/eliminarRegistroSemanal",
            data: { id: id },
            success: function (data) {
                fila.remove();
            },
            error: function (error) {
                console.error("Error al eliminar el cliente: " + error);
            }
        });

        ocultarModalEliminar();
    });
	
	document.getElementById("btn-cancelarF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
	
	document.getElementById("btn-closeF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
}

