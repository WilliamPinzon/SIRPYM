let currentView = 0;
// Variable global para controlar si se debe enviar el formulario
var enviarFormulario = true;
function agregarRazonSocial() {
	var selectCliente = document.getElementById("numeroIDCliente");
	var razonInput = document.getElementById("razon");
	var idInput = document.getElementById("id");
	var idClienteInput = document.getElementById("idCliente");
	
	var selectedOptionCliente = selectCliente.options[selectCliente.selectedIndex];
	var razon = selectedOptionCliente.getAttribute("razon");
	var id = selectedOptionCliente.getAttribute("idCliente");
	var idCliente = selectedOptionCliente.getAttribute("numeroidCliente");
	
	razonInput.value = razon;
	idInput.value = id;
	idClienteInput.value = idCliente;
}


function actualizarValorUnitario(select) {
    var selectedOption = select.options[select.selectedIndex];
    if (!selectedOption) {
        return;
    }
    var precio = selectedOption.getAttribute("data-precio");
    var valorUnitarioInput = select.closest("tr").querySelector('.unit-price');
    valorUnitarioInput.value = precio;
    
//    var descripcion = selectedOption.getAttribute("data-descripcion");
//	var descripcionInput = select.closest("tr").querySelector('.descripcion');
//	descripcionInput.value = descripcion;

    
	var nom = selectedOption.getAttribute("Item");
	var nomInput = select.closest("tr").querySelector('.nomItem');
	nomInput.value = nom;
	
	

}

document.addEventListener('DOMContentLoaded', function() {

	function updateRow(row) {

		const quantity = parseInt(row.querySelector('.quantity').value);
		const unitPrice = parseFloat(row.querySelector('.unit-price').value);

		const subtotal = quantity * unitPrice;
		var subtotalElement = row.querySelector('.subtotal');

		subtotalElement.textContent = subtotal.toFixed(2);
		
		var valTotal = document.getElementById("valorTotal");
		const totalSubtotales = sumarSubtotales();
		valTotal.value = totalSubtotales;

	}

	function addRowAndCheckView() {
		const newRow = table.querySelector('tbody tr').cloneNode(true);

//		newRow.querySelector('.descripcion').textContent = '';
		newRow.querySelector('.quantity').value = 0;
		newRow.querySelector('.unit-price').value = ''; // Limpiar el valor unitario
		newRow.querySelector('.subtotal').textContent = '';
		

		table.querySelector('tbody').appendChild(newRow);

		cambiarVista(1);
	}

	function cambiarVista(direction) {
	    ocultarModalConfirmacion();
	    const rows = table.getElementsByTagName('tr');
	    const rowsPerPage = 3;
	    const totalDataRows = rows.length - 1;
	    const maxPageIndex = Math.ceil(totalDataRows / rowsPerPage) - 1;
	
	    let currentPageIndex = parseInt(table.getAttribute('data-current-page-index')) || 0;
	    currentPageIndex += direction;
	    currentPageIndex = Math.min(maxPageIndex, Math.max(0, currentPageIndex));
	
	    const startRow = currentPageIndex * rowsPerPage + 1;
	    const endRow = Math.min(startRow + rowsPerPage, totalDataRows + 1);
	
	    for (let i = 1; i < rows.length; i++) {
	        if (i >= startRow && i < endRow) {
	            rows[i].style.display = '';
	        } else {
	            rows[i].style.display = 'none';
	        }
	    }
	
	    const currentViewSpan = document.querySelector('.current-view');
	    currentViewSpan.textContent = `Vista ${currentPageIndex + 1} de ${maxPageIndex + 1}`;
	
	    const anteriorBtn = document.getElementById('anteriorBtn');
	    const siguienteBtn = document.getElementById('siguienteBtn');
	
	    if (currentPageIndex > 0) {
	        anteriorBtn.style.display = '';
	    } else {
	        anteriorBtn.style.display = 'none';
	    }
	
	    if (currentPageIndex < maxPageIndex || totalDataRows % rowsPerPage === 0 && totalDataRows > 3) {
	        siguienteBtn.style.display = '';
	    } else {
	        siguienteBtn.style.display = 'none';
	    }
	    
	
	    table.setAttribute('data-current-page-index', currentPageIndex);
	}

	// Event listeners para los botones de anterior y siguiente
	const anteriorBtn = document.getElementById('anteriorBtn');
	const siguienteBtn = document.getElementById('siguienteBtn');
	
	anteriorBtn.addEventListener('click', () => cambiarVista(-1));
	siguienteBtn.addEventListener('click', () => cambiarVista(1));


	const table = document.getElementById('productTable');
	const addRowButton = document.getElementById('addRow');

	addRowButton.addEventListener('click', addRowAndCheckView);
	cambiarVista(1);

	table.addEventListener('change', function(event) {
		const target = event.target;
		if (target.classList.contains('quantity') || target.classList.contains('unit-price') || target.classList.contains('product')) {
			const row = target.closest('tr');
			updateRow(row);
		}
	});

	updateRow(table.querySelector('tbody tr'));
});


function agregarFila(event) {
	 event.preventDefault();
	const table = document.getElementById("productTable").getElementsByTagName('tbody')[0];
	const lastRow = table.rows[table.rows.length - 1];
	const newRow = lastRow.cloneNode(true);

	newRow.cells[0].querySelector('.select').value = '';
	newRow.cells[1].querySelector('input').value = '';
	newRow.cells[2].querySelector('input').value = '';
	newRow.cells[3].querySelector('td').textContent = '';

	table.appendChild(newRow);

	cambiarVista(1);
}


function eliminarFila(btn) {
	
	event.preventDefault(); // Agregar esta línea
	mostrarModalEliminar();
	ocultarModalConfirmacion();
	
	document.getElementById("btn-aceptarF").addEventListener("click", function() {
		const row = btn.parentNode.parentNode;
		const table = document.getElementById("productTable").getElementsByTagName('tbody')[0];
	
		if (table.rows.length > 1) {
			if (row.rowIndex !== 0) {
				row.parentNode.removeChild(row);
			}
		}
	
		if (table.rows.length <= 4) {
			cambiarVista(1);
		}
	
		var valTotal = document.getElementById("valorTotal");
		const totalSubtotales = sumarSubtotales();
		valTotal.value = "$ " + totalSubtotales;
		ocultarModalEliminar(); 
	});

	document.getElementById("btn-cancelarF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
	
	document.getElementById("btn-closeF").addEventListener("click", function() {
		ocultarModalEliminar();
	});
	enviarFormulario = false;

}

document.getElementById("anteriorBtn").addEventListener("click", function(event) {
    event.preventDefault();
    cambiarVista(-1);
});

document.getElementById("siguienteBtn").addEventListener("click", function(event) {
    event.preventDefault();
    cambiarVista(1);
});

function cambiarVista(direction) {
	ocultarModalConfirmacion();
	const table = document.getElementById("productTable").getElementsByTagName('tbody')[0];
	const totalViews = Math.ceil(table.rows.length / 3);
	currentView += direction;

	if (currentView < 0) {
		currentView = 0;
	} else if (currentView >= totalViews) {
		currentView = totalViews - 1;
	}
	document.querySelector(".current-view").innerText = `Vista ${currentView + 1} de ${totalViews}`;
}


function sumarSubtotales() {
	const table = document.getElementById("productTable").getElementsByTagName('tbody')[0];
	let total = 0;

	for (let i = 0; i < table.rows.length; i++) {
		const row = table.rows[i];
		const subtotalCell = row.cells[3];
		const subtotal = parseFloat(subtotalCell.textContent);

		if (!isNaN(subtotal)) {
			total += subtotal;
		}
	}

	return total;
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



// Función para mostrar el modal de confirmación
function mostrarModalConfirmacion(eventOrigin) {
    var modal = document.getElementById("modal-confirmacion");
    modal.style.display = "block";

    if (eventOrigin === 'addRow') {
        agregarFila();
        enviarFormulario = false; // No enviar el formulario si se agrega una fila
    } else {
        // Recopilar la información de los productos seleccionados
        var productosSeleccionados = [];
        $(".product").each(function() {
            var cantidad = $(this).closest("tr").find(".quantity").val();
            var valorUnitario = $(this).closest("tr").find(".unit-price").val();
            var subTotalString = (cantidad * valorUnitario).toString();

            var producto = {
                producto: $(this).val(),
                cantidad: cantidad,
                valorUnitario: valorUnitario,
                subTotal: subTotalString
            };
            productosSeleccionados.push(producto);
        });

        // Agregar la información al campo oculto del formulario
        $("#productosSeleccionados").val(JSON.stringify(productosSeleccionados));
    }
    enviarFormulario = false;
}

// Agregar evento al botón de aceptar del modal
document.getElementById("btn-aceptar").addEventListener("click", function() {
    // Verificar si se debe enviar el formulario
    enviarFormulario = true;
    if (enviarFormulario) {
        // Envía el formulario
        var formularioRegistro = document.querySelector('form');
        formularioRegistro.submit();
    }
    ocultarModalConfirmacion();
});

// Agregar evento al formulario para prevenir su envío si la variable enviarFormulario es falsa
document.querySelector('form').addEventListener('submit', function(event) {
    if (!enviarFormulario) {
        event.preventDefault(); // Prevenir el envío del formulario
    }
});


function ocultarModalConfirmacion() {
	var modal = document.getElementById("modal-confirmacion");
	modal.style.display = "none";
}

function mostrarModalEliminar() {
	ocultarModalConfirmacion();
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "block";
	return false;
}

function ocultarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "none";
}

document.getElementById("btn-cancelar").addEventListener("click", function() {
	ocultarModalConfirmacion();
});

document.getElementById("btn-close").addEventListener("click", function() {
	ocultarModalConfirmacion();
});

function mostrarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "block";
	return false;
}

function ocultarModalEliminar() {
	var modal = document.getElementById("modal-eliminar");
	modal.style.display = "none";
}

function borrar() {
    const filas = document.querySelectorAll("#productTable tbody tr:not(:first-child)");
    
    filas.forEach(fila => fila.remove());

    const primerCampoInput = document.querySelector("#productTable tbody tr:first-child td:nth-child(1) select");
    primerCampoInput.value = '';

    const otrosCamposInput = document.querySelectorAll("#productTable tbody tr:first-child td input");
    otrosCamposInput.forEach(input => input.value = '');

    primerCampoInput.focus();

	const numeroClienteInput = document.getElementById("numeroIDClientes");
	const razonInput = document.getElementById("razon");
	const productoInput = document.getElementById("producto");
	const cantidadInput = document.getElementById("cantidad");
	const valorUnitarioInput = document.getElementById("valorUnitario");
	const subTotalInput = document.getElementById("subTotal");
	const valorTotal = document.getElementById("valorTotal");

	numeroClienteInput.value = "";
	razonInput.value = "";
	productoInput.value = "";
	cantidadInput.value = "";
	valorUnitarioInput.value = "";
	subTotalInput.value = "";
	valorTotal.value = "";

	numeroClienteInput.focus();
	
	cambiarVista(1);
}