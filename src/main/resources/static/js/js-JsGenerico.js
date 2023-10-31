document.addEventListener("DOMContentLoaded", function() {
	const botonMostrarOcultar = document.getElementById("mostrarOcultarBoton");
	const menu = document.getElementById("menu");
	const ayuda = document.querySelector(".ayuda");
	const main = document.querySelector("main");
	const buscarInput = document.getElementById("buscarInput"); // Agrega esta línea

	botonMostrarOcultar.addEventListener("click", function() {
		if (menu.classList.contains("menu-oculto")) {
			menu.classList.remove("menu-oculto");
			ayuda.classList.remove("menu-oculto")
			main.classList.remove("main-expandir");
			buscarInput.style.marginRight = "0";
			buscarInput.style.transition = "0.01 s";
		} else {
			menu.classList.add("menu-oculto");
			ayuda.classList.add("menu-oculto");
			main.classList.add("main-expandir");
			buscarInput.style.marginRight = "-11%";
			buscarInput.style.transition = "0.1 s";
		}
	});

	// Almacena el estado del menú en el almacenamiento local al hacer clic en el botón
	botonMostrarOcultar.addEventListener("click", function() {
		if (menu.classList.contains("menu-oculto")) {
			localStorage.setItem("menuVisible", "false");
		} else {
			localStorage.setItem("menuVisible", "true");
		}
	});

	// Restaura el estado del menú desde el almacenamiento local al cargar la página
	const menuVisible = localStorage.getItem("menuVisible");
	if (menuVisible === "false") {
		menu.classList.add("menu-oculto");
		ayuda.classList.add("menu-oculto");
		main.classList.add("main-expandir");
		buscarInput.style.marginRight = "-11%";
		buscarInput.style.transition = "0.1 s";
	}
});
