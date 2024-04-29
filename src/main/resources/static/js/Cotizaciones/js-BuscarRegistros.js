document.addEventListener('DOMContentLoaded', function () {
												const identificacionInput = document.getElementById('numeroIDClientes');
												const numeroDeContactoClienteInput = document.getElementById('numeroDeContactoCliente');
												const suggestionsContainerNumeroIDCliente = document.getElementById('suggestionsID');
												let lastActiveInputNumeroID = null;

												const sugerenciasNumeroID = Array.from(document.querySelectorAll('.suggestionsID-itemID')).map(sugerencia => ({
													id: sugerencia.getAttribute('value'),
													numeroIDCliente: sugerencia.textContent
												}));

												function mostrarSugerenciasNumeroID(sugerencias, container) {
													container.innerHTML = '';
													sugerencias.forEach(sugerencia => {
														const suggestionItem = document.createElement('div');
														suggestionItem.classList.add('suggestionsID-itemID');
														suggestionItem.textContent = sugerencia.numeroIDCliente;
														suggestionItem.addEventListener('click', () => {
															container.style.display = 'none';
															if (lastActiveInputNumeroID === identificacionInput) {
																numeroDeContactoClienteInput.value = sugerencia.numeroDeContactoCliente;
																identificacionInput.value = sugerencia.numeroIDCliente;
																buscarClienteporNumero(identificacionInput); // Llama a la función buscarClienteporNumero
															}
														});
														container.appendChild(suggestionItem);
													});
													container.style.display = 'block';
												}

												identificacionInput.addEventListener('input', () => {
													const identificacionValue = identificacionInput.value.toLowerCase();
													const sugerenciasFiltradas = sugerenciasNumeroID.filter(sugerencia =>
														sugerencia.numeroIDCliente.toLowerCase().startsWith(identificacionValue)
													);
													mostrarSugerenciasNumeroID(sugerenciasFiltradas, suggestionsContainerNumeroIDCliente);
												});

												identificacionInput.addEventListener('focus', () => {
													lastActiveInputNumeroID = identificacionInput;
												});

												document.addEventListener('click', (event) => {
													if (!suggestionsContainerNumeroIDCliente.contains(event.target)) {
														suggestionsContainerNumeroIDCliente.style.display = 'none';
													}
												});
											});

											document.addEventListener('DOMContentLoaded', function () {
												const nombreInput = document.getElementById('razon');
												const suggestionsContainerNombreCliente = document.getElementById('suggestionsNombreCliente');
												let lastActiveInputNombre = null;

												const sugerenciasNombre = Array.from(document.querySelectorAll('.suggestion-item')).map(sugerencia => ({
													id: sugerencia.getAttribute('value'),
													nombreCliente: sugerencia.textContent
												}));

												function mostrarSugerenciasNombre(sugerencias, container) {
													container.innerHTML = '';
													sugerencias.forEach(sugerencia => {
														const suggestionItem = document.createElement('div');
														suggestionItem.classList.add('suggestion-item');
														suggestionItem.textContent = sugerencia.nombreCliente;
														suggestionItem.addEventListener('click', () => {
															container.style.display = 'none';
															if (lastActiveInputNombre === nombreInput) {
																nombreInput.value = sugerencia.nombreCliente;
																buscarClienteporNombre(nombreInput.value); // Llama a la función buscarClienteporNombre
															}
														});
														container.appendChild(suggestionItem);
													});
													container.style.display = 'block';
												}

												nombreInput.addEventListener('input', () => {
													const nombreValue = nombreInput.value.toLowerCase();
													const sugerenciasFiltradas = sugerenciasNombre.filter(sugerencia =>
														sugerencia.nombreCliente.toLowerCase().startsWith(nombreValue)
													);
													mostrarSugerenciasNombre(sugerenciasFiltradas, suggestionsContainerNombreCliente);
												});

												nombreInput.addEventListener('focus', () => {
													lastActiveInputNombre = nombreInput;
												});

												document.addEventListener('click', (event) => {
													if (!suggestionsContainerNombreCliente.contains(event.target)) {
														suggestionsContainerNombreCliente.style.display = 'none';
													}
												});
											});

											function buscarClienteporNumero(input) {
												var idCliente = input.value;
												// Realiza una solicitud AJAX para buscar el cliente por su número de cliente
												$.ajax({
													type: "GET",
													url: "/RegistroDeCotizaciones/buscarClientePorID",
													data: {numeroDeDocumento: idCliente},
													success: function (cliente) {
														$("#razon").val(cliente.nombreCompleto);
														$("#numeroDeContactoCliente").val(cliente.numeroDeContacto);
														$("#correoElectronicoCliente").val(cliente.correoElectronico);
														$("#direccionCliente").val(cliente.direccion);
													},
													error: function (error) {
														console.error("Error al buscar el cliente por número: " + error);
													}
												});
											}


function buscarClienteporNombre(nombreCliente) {
    // Realiza una solicitud AJAX para buscar el cliente por su nombre
    $.ajax({
        type: "GET",
        url: "/RegistroDeCotizaciones/buscarClientePorNombre",
        data: {nombreCompleto: nombreCliente}, // Cambiar a nombreCompleto
        success: function (cliente) {
            console.log(cliente);
            $("#numeroIDClientes").val(cliente.numeroDeDocumento);
            $("#numeroDeContactoCliente").val(cliente.numeroDeContacto);
            $("#correoElectronicoCliente").val(cliente.correoElectronico);
            $("#direccionCliente").val(cliente.direccion);
        },
        error: function (error) {
            console.error("Error al buscar el cliente por nombre: " + error);
        }
    });
}

