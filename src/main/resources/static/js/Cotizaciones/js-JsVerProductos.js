										document.addEventListener("DOMContentLoaded", function () {
											// Obtener elementos del DOM
											const modal = document.getElementById("miModal");
											const tablaBody = document.querySelector("#tablaProductos tbody");
											const botonCerrarModal = document.querySelector(".closeModalProductos");

											// Función para mostrar el modal
											function mostrarModal() {
												modal.style.display = "block";
											}

											// Función para cerrar el modal
											function cerrarModal() {
												modal.style.display = "none";
											}

											// Función para mostrar los productos de la fila específica
											function mostrarProductosDeFila(productos) {
												tablaBody.innerHTML = ''; // Limpiar tabla
												productos.forEach(producto => {
													const fila = document.createElement("tr");
													fila.innerHTML = `
									                    <td>${producto.producto}</td>
									                    <td>${producto.cantidad}</td>
									                    <td>$ ${producto.valorUnitario}</td>
									                    <td>$ ${producto.subTotal}</td>
									                `;
													tablaBody.appendChild(fila);
												});
												mostrarModal(); // Mostrar el modal después de cargar los productos
											}

											// Agregar evento de clic al botón "Mostrar Tabla" de cada fila
											const botonesMostrarModal = document.querySelectorAll("#mostrarModal");
											botonesMostrarModal.forEach(boton => {
												boton.addEventListener("click", function () {
													const fila = this.closest("tr"); // Obtener la fila padre del botón clickeado
													const datosProductosHTML = fila.querySelector("#datosProductos").textContent.trim();
													const productos = JSON.parse(datosProductosHTML); // Parsear los productos de la fila como JSON
													mostrarProductosDeFila(productos);
												});
											});

											// Agregar evento de clic al botón para cerrar el modal
											botonCerrarModal.addEventListener("click", cerrarModal);

											// Función para cerrar el modal cuando se hace clic fuera del contenido
											window.addEventListener("click", function (event) {
												if (event.target === modal) {
													cerrarModal();
												}
											});
										});
