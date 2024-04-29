th: inline = "javascript"
var currentIndex = 0;
var tableRows = document.getElementById("mainTableBody").getElementsByTagName("tr");
var numRows = tableRows.length;

function showNext() {
	var nextIndex = currentIndex + 9;
	if (nextIndex >= numRows) {
		nextIndex = numRows;
		document.getElementsByClassName("arrow-button")[1].style.display = "none";
	}
	currentIndex = nextIndex;
	showRows();
}

function showPrevious() {
	var previousIndex = currentIndex - 9;
	if (previousIndex < 0) {
		previousIndex = 0;
		document.getElementsByClassName("arrow-button")[0].style.display = "none";
	}
	currentIndex = previousIndex;
	showRows();
}

function showRows() {
	const numRowsPerPage = 9; // Número de filas por página
    const totalViews = Math.ceil(numRows / numRowsPerPage); // Calcular el total de vistas
	for (var i = 0; i < numRows; i++) {
		if (i >= currentIndex && i < currentIndex + 9) {
			tableRows[i].style.display = "";
		} else {
			tableRows[i].style.display = "none";
		}
	}
	document.getElementsByClassName("arrow-button")[0].style.display = (currentIndex > 0) ? "" : "none";
	document.getElementsByClassName("arrow-button")[1].style.display = (currentIndex + 9 < numRows) ? "" : "none";
	   // Actualizar texto que muestra la vista actual y el total de vistas
    const currentView = Math.floor(currentIndex / numRowsPerPage) + 1; // Calcular la vista actual
    document.querySelector(".current-view").innerText = `Vista ${currentView} de ${totalViews}`; // Actualizar el texto
}

function buscarColaborador() {
    var input = document.getElementById("buscarInput");
    var filter = input.value.toUpperCase();
    var tabla = document.getElementsByTagName("table")[0];
    var filas = tabla.getElementsByTagName("tr");

    if (filter === "") {
        showRows();
    } else {
        for (var i = 0; i < filas.length; i++) {
            var celda = filas[i].getElementsByTagName("td")[1];
            if (celda) {
                var textoCelda = celda.textContent || celda.innerText;
                if (textoCelda.toUpperCase().indexOf(filter) > -1) {
                    filas[i].style.display = "";
                } else {
                    filas[i].style.display = "none";
                }
            }
        }
    }
}

showRows();