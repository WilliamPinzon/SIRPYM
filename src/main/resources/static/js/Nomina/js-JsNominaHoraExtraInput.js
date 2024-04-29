document.addEventListener('DOMContentLoaded', function () {
    const tabla1 = document.getElementById('tabla1');
    const tabla2 = document.getElementById('tabla2');
    const tabla2Body = document.getElementById('tabla2Body');

    tabla1.addEventListener('click', function (event) {
        const target = event.target;
        if (target.classList.contains('move-button')) {
            const row = target.parentNode.parentNode;
            const indice = row.cells[0].textContent;
            const nombre = row.cells[1].textContent;
            
            const newRow = tabla2Body.insertRow();
            const newCell1 = newRow.insertCell(0);
            const newCell2 = newRow.insertCell(1);
            const newCell3 = newRow.insertCell(2);
            const newCell4 = newRow.insertCell(3);
            const newCell5 = newRow.insertCell(4);
            const newCell6 = newRow.insertCell(5);
            
            newCell1.textContent = indice;
            newCell2.textContent = nombre;
            newCell3.innerHTML = '<input type="time" class="form-control hora-ingreso" style="height: 30px; width: 100%; font-size: 11px;" value="08:14">';
            newCell4.innerHTML = '<input type="time" class="form-control hora-salida" style="height: 30px; font-size: 11px;" value="17:01">';
            newCell5.innerHTML = '<input type="text" class="form-control total-extra" style="height: 30px; font-size: 11px;" readonly>';
            newCell6.innerHTML = `
                <button class="btn btn-danger cancel-button" style="font-size: 10px; height: 10px; padding-bottom: 20px;">Cancelar
                   <svg xmlns="http://www.w3.org/2000/svg" width="12" height="12" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708"/>
</svg>
                </button>`;
            
            // Calcular total extra al agregar la fila
            calcularTotalExtra(newRow);
            
            console.log("Número de filas:", tabla2Body.rows.length);
            
            row.remove();
        }
        sortTableAsc(tabla1);
    });

    tabla2.addEventListener('change', function (event) {
        const target = event.target;
        if (target.classList.contains('hora-ingreso') || target.classList.contains('hora-salida')) {
            const row = target.parentNode.parentNode;
            // Calcular total extra al cambiar hora de ingreso o salida
            calcularTotalExtra(row);
        }
    });

    tabla2.addEventListener('click', function (event) {
        const target = event.target;
        if (target.classList.contains('cancel-button')) {
            const row = target.parentNode.parentNode;
            const indice = row.cells[0].textContent;
            const nombre = row.cells[1].textContent;
            const newRow = tabla1.insertRow();
            newRow.innerHTML = `<td class="selectable">${indice}</td><td class="selectable">${nombre}</td><td><button class="btn btn-primary move-button" style="font-size: 10px; height: 10px; padding-bottom: 20px;">Agregar
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-plus-fill" viewBox="0 0 16 16">
                    <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2M8.5 6v1.5H10a.5.5 0 0 1 0 1H8.5V10a.5.5 0 0 1-1 0V8.5H6a.5.5 0 0 1 0-1h1.5V6a.5.5 0 0 1 1 0"/>
                </svg>
            </button></td>`;
            row.remove();
            sortTableAsc(tabla1);
        }
    });

    function sortTableAsc(table) {
        const tbody = table.querySelector('tbody');
        const rows = Array.from(tbody.querySelectorAll('tr'));
        rows.sort((a, b) => {
            const indexA = parseInt(a.cells[0].textContent);
            const indexB = parseInt(b.cells[0].textContent);
            return indexA - indexB; // Cambio en la lógica de comparación
        });
        tbody.innerHTML = '';
        rows.forEach(row => tbody.appendChild(row));
    }

    function calcularTotalExtra(row) {
        const horaIngreso = row.querySelector('.hora-ingreso').valueAsDate;
        const horaSalida = row.querySelector('.hora-salida').valueAsDate;
        if (horaIngreso && horaSalida) {
            const diffMillis = horaSalida.getTime() - horaIngreso.getTime();
            const diffHours = (diffMillis / (1000 * 60 * 60)) - 8.78;
            // Establecer el valor del input en lugar de su contenido
            row.querySelector('.total-extra').value = diffHours.toFixed(2);
        } else {
            row.querySelector('.total-extra').value = '';
        }
    }
});
