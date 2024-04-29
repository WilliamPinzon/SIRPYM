th: inline = "javascript"
var currentIndex = 0;
var tableRows = document.getElementById("mainTableBody").getElementsByTagName("tr");
var numRows = tableRows.length;

function showNext() {
	var nextIndex = currentIndex + 10;
	if (nextIndex >= numRows) {
		nextIndex = numRows;
		document.getElementsByClassName("arrow-button")[1].style.display = "none";
	}
	currentIndex = nextIndex;
	showRows();
}

function showPrevious() {
	var previousIndex = currentIndex - 10;
	if (previousIndex < 0) {
		previousIndex = 0;
		document.getElementsByClassName("arrow-button")[0].style.display = "none";
	}
	currentIndex = previousIndex;
	showRows();
}

function showRows() {
	for (var i = 0; i < numRows; i++) {
		if (i >= currentIndex && i < currentIndex + 10) {
			tableRows[i].style.display = "";
		} else {
			tableRows[i].style.display = "none";
		}
	}
	document.getElementsByClassName("arrow-button")[0].style.display = (currentIndex > 0) ? "" : "none";
	document.getElementsByClassName("arrow-button")[1].style.display = (currentIndex + 10 < numRows) ? "" : "none";
}

function buscarCliente() {
    var input = document.getElementById("buscarInput");
    var filter = input.value.toUpperCase();
    var tabla = document.getElementsByTagName("table")[0];
    var filas = tabla.getElementsByTagName("tr");

    if (filter === "") {
        // Si el filtro está vacío, mostrar todas las filas
        showRows();
    } else {
        // Si hay un filtro, ocultar las filas que no coinciden
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