const calendario = flatpickr("#mostrarCalendario", {
    enableTime: true, // Permitir selección de tiempo
    dateFormat: "Y-m-d", // Formato de fecha y hora (h para formato de 12 horas, K para AM/PM)
    time_24hr: false, // Usar formato de 12 horas
    onClose: function (selectedDates, dateStr, instance) {
        // Cerrar el calendario si se hace clic fuera de él
        calendario.close();
    },
    onReady: function(selectedDates, dateStr, instance) {
        // Crear botones Aceptar y Cancelar
        const botones = document.createElement("div");
        botones.innerHTML = '<button id="btnAceptar">Aceptar</button> <button id="btnCancelar">Cancelar</button>';
        instance.calendarContainer.appendChild(botones);

        // Manejar evento clic del botón Aceptar
        document.getElementById("btnAceptar").addEventListener("click", function () {
            const fechaSeleccionada = calendario.selectedDates[0];
            if (fechaSeleccionada) {
                const fechaStr = calendario.formatDate(fechaSeleccionada, "Y-m-d"); // Utilizar el mismo formato que el de la configuración
                document.getElementById('mostrarCalendario').textContent = fechaStr;
                document.getElementById('fechaSeleccionada').value = fechaStr;
            }
            calendario.close();
        });

        // Manejar evento clic del botón Cancelar
        document.getElementById("btnCancelar").addEventListener("click", function () {
            calendario.close();
        });

        document.getElementById("mostrarCalendario").addEventListener("click", function (event) {
            event.preventDefault(); // Prevenir el comportamiento predeterminado del botón

            // Abrir el calendario
            calendario.open();
        });
    }
});




