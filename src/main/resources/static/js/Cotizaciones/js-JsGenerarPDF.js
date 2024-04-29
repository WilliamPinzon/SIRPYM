// Función para obtener el valor del botón de opción seleccionado
	var porcen = "";
	var propina = "";
function generatePDF(event) {
		event.preventDefault();
	   	// Crear un contenedor para el PDF
	    const container = document.createElement("div");
	    container.style.width = "600px"; // Ancho máximo del contenedor
	
	    // Crear el mensaje
	    // Crear un elemento de imagen
	    const imagen = document.createElement("img");
	    imagen.src = "../img/Refugio.png"; // Ruta de la imagen
	    imagen.style.height = "auto"; // Ajustar la altura automáticamente según el ancho
	    imagen.style.display = "block"; // Para centrar la imagen si es necesario
	    
	    imagen.style.width = "50%"; // Ancho completo del contenedor
		imagen.style.maxWidth = "1000px"; // Ancho máximo del contenido interno
		imagen.style.margin = "0 auto"; // Centrar el div
		imagen.style.textAlign = "center";
		imagen.style.fontSize = "16px";
		imagen.style.marginTop = "10px";
		imagen.style.marginLeft = "40%";
	
	    // Agregar la imagen al contenedor
	    container.appendChild(imagen);
	    
	   	const mesajeCabecera = document.createElement("div");
	    mesajeCabecera.innerHTML = "KM 62 via Bogotá - Tunja" + "<br>" + "NIT: 901420447-9" + "<br>" + "Tel: 300 553 7153" + "<br>" + "refugiodelsisga@gmail.com" + "<br>" + "<hr style='width: 100%;'>";
		mesajeCabecera.style.textAlign = "center";
		mesajeCabecera.style.fontSize = "10px";
		mesajeCabecera.style.marginTop = "0px";
		mesajeCabecera.style.marginLeft = "100px";
		mesajeCabecera.style.width = "100%"; // Ancho completo del contenedor
		mesajeCabecera.style.maxWidth = "1000px"; // Ancho máximo del contenido interno
		mesajeCabecera.style.userSelect = "text"; // Permitir selección de texto
		
	    
	    const mesajeCotizacion = document.createElement("div");
		var numeroCotizacion = document.getElementById("cotizacionNumero").textContent;
	    
	    mesajeCotizacion.innerHTML = "FACTURA DE TIPO COTIZACIÓN CON CONSECUTIVO N° " + numeroCotizacion + "<br>" + "<hr style='width: 100%;'>";
		mesajeCotizacion.style.textAlign = "center";
		mesajeCotizacion.style.fontSize = "18px";
		mesajeCotizacion.style.marginTop = "0px";
		mesajeCotizacion.style.marginLeft = "100px";
		mesajeCotizacion.style.width = "100%"; // Ancho completo del contenedor
		mesajeCotizacion.style.maxWidth = "1000px"; // Ancho máximo del contenido interno
		mesajeCotizacion.style.userSelect = "text"; // Permitir selección de texto

		//Datos del cliente
		
		// Crear una tabla para los productos en el PDF
	    const datos = document.createElement("table");
	    datos.style.width = "120%"; // Ancho máximo de la tabla
	    datos.style.borderCollapse = "collapse";
	    datos.style.fontSize = "10px";
	    datos.style.marginTop = "30px";
	    datos.style.marginLeft = "50px";
	    datos.style.border = "1px solid #dddddd"; // Borde de la tabla
	    datos.style.borderRadius = "15px"; // Bordes redondeados
	
	    
		const thStyleDatos = "padding: 5px; width: 20%; background-color: rgb(192,192,192); font-weight: bold; text-align: left; color: black";

	    // Encabezado de la tabla
	    const theadDatos = document.createElement("thead");
	    const headerRowDatos = document.createElement("tr");
	    ["DATOS DE LA COTIZACIÓN"].forEach(headerText => {
	        const th = document.createElement("th");
	        th.textContent = headerText;
	        th.style.cssText = thStyleDatos;
	        headerRowDatos.appendChild(th);
	    });
	    
	    theadDatos.appendChild(headerRowDatos);
	    datos.appendChild(theadDatos);
		
	    //Crear tabla para cliente
	    const clienteTable = document.createElement("table");
		clienteTable.style.width = "60%"; // Ancho máximo de la tabla
	    clienteTable.style.margin = "auto"; // Centrar la tabla en el contenedor
	    clienteTable.style.borderCollapse = "collapse";
	    clienteTable.style.fontSize = "10px";
	    clienteTable.style.marginTop = "10px";
	    clienteTable.style.marginLeft = "50px";
	    clienteTable.style.border = "1px solid #dddddd"; // Borde de la tabla
	    clienteTable.style.borderRadius = "15px"; // Bordes redondeados
	    clienteTable.style.textAlign = "left"; // Bordes redondeados
	    
	    // Estilos para las celdas del encabezado
	    const thStyleCliente = "padding: 5px; width: 10%; background-color: rgb(192,192,192); font-weight: bold; text-align: left; color: black";
	    const thStyleClienteTD = "padding: 5px; border-Radius: 15px; width: 15%; background-color: white; margin-left: 8000px; font-weight: bold; text-align: left; color: black";
	    
	    
	    const theadCliente = document.createElement("thead");
	    const headerRowCliente = document.createElement("tr");
	    
	   ["Número de Identificación", "Nombre o Razón Social", "Número de Telefono", "Correo Electronico", "Dirección"].forEach(headerText => {
		    const headerRow = document.createElement("tr");
		
		    // Encabezado de la columna
		    const th = document.createElement("th");
		    th.textContent = headerText;
		    th.style.cssText = thStyleCliente;
		    headerRow.appendChild(th);
		
		    // Obtener la opción seleccionada
		
		    // Agregar una celda para el número de identificación del cliente debajo de cada encabezado
		    if (headerText === "Número de Identificación") {
		        const numeroidCliente = document.getElementById("numeroIDClientes").value;
		        const idClienteCell = document.createElement("td");
		        idClienteCell.textContent = numeroidCliente;
		        idClienteCell.style.cssText = thStyleClienteTD;
		        headerRow.appendChild(idClienteCell);
		    }
		
		    // Agregar una celda para la razón social del cliente debajo de cada encabezado
		    if (headerText === "Nombre o Razón Social") {
		        const razon = document.getElementById("razon").value;
		        const razonCell = document.createElement("td");
		        razonCell.textContent = razon;
		        razonCell.style.cssText = thStyleClienteTD;
		        headerRow.appendChild(razonCell);
		    }
		    
		     // Agregar una celda para el número de identificación del cliente debajo de cada encabezado
		    if (headerText === "Número de Telefono") {
		        const numeroCliente = document.getElementById("numeroDeContactoCliente").value;
		        const numeroClienteCell = document.createElement("td");
		        numeroClienteCell.textContent = numeroCliente;
		        numeroClienteCell.style.cssText = thStyleClienteTD;
		        headerRow.appendChild(numeroClienteCell);
		    }
		
		    // Agregar una celda para la razón social del cliente debajo de cada encabezado
		    if (headerText === "Correo Electronico") {
		        const correoCliente = document.getElementById("correoElectronicoCliente").value;
		        const correoClienteCell = document.createElement("td");
		        correoClienteCell.textContent = correoCliente;
		        correoClienteCell.style.cssText = thStyleClienteTD;
		        headerRow.appendChild(correoClienteCell);
		    }
		    
		    // Agregar una celda para la razón social del cliente debajo de cada encabezado
		    if (headerText === "Dirección") {
		        const direccionCliente = document.getElementById("direccionCliente").value;
		        const direccionClienteCell = document.createElement("td");
		        direccionClienteCell.textContent = direccionCliente;
		        direccionClienteCell.style.cssText = thStyleClienteTD;
		        headerRow.appendChild(direccionClienteCell);
		    }
		
		    // Agregar la fila del encabezado al encabezado de la tabla
		    theadCliente.appendChild(headerRow);
		});
	
	    theadCliente.appendChild(headerRowCliente);
	    clienteTable.appendChild(theadCliente);
	    
	    //Tabla para la cotizacion
	    const cotizacaionTable = document.createElement("table");
		cotizacaionTable.style.width = "60%"; // Ancho máximo de la tabla
	    cotizacaionTable.style.margin = "auto"; // Centrar la tabla en el contenedor
	    cotizacaionTable.style.borderCollapse = "collapse";
	    cotizacaionTable.style.fontSize = "10px";
	    cotizacaionTable.style.marginTop = "-107px";
	    cotizacaionTable.style.marginLeft = "409px";
	    cotizacaionTable.style.border = "1px solid #dddddd"; // Borde de la tabla
	    cotizacaionTable.style.borderRadius = "15px"; // Bordes redondeados
	    cotizacaionTable.style.textAlign = "left"; // Bordes redondeados
	    
	    // Estilos para las celdas del encabezado
	    const thStyleCotizacion = "background: black; padding: 5px; width: 5%; background-color: rgb(192,192,192); font-weight: bold; text-align: left; color: black";
	    const thStyleCotizacionTD = "padding-left: 5px; border-Radius: 15px; width: 10%; background-color: white; margin-left: 100px; font-weight: bold; text-align: left; color: black";
	    
	    
	    const theadCotizacion = document.createElement("thead");
	    const headerRowCotizacion = document.createElement("tr");
	    
	   ["Fecha y Hora de la Cotización","Fecha y Hora del Evento", "Cantidad de Comensales"].forEach(headerText => {
			    const headerRowCotizacion = document.createElement("tr");
			
			    // Encabezado de la columna
			    const th = document.createElement("th");
			    th.textContent = headerText;
			    th.style.cssText = thStyleCotizacion;
			    headerRowCotizacion.appendChild(th);
			
			    // Agregar una celda para la fecha y hora de la cotización debajo de cada encabezado
				if (headerText === "Fecha y Hora de la Cotización") {
				    const fechaHoraActual = new Date(); // Obtener la fecha y hora actual del sistema
				    const fechaHoraFormateada = fechaHoraActual.toLocaleString(); // Formatear la fecha y hora según la configuración regional del navegador
				
				    const fechaHoraCell = document.createElement("td");
				    fechaHoraCell.textContent = fechaHoraFormateada;
				    fechaHoraCell.style.cssText = thStyleCotizacionTD;
				    headerRowCotizacion.appendChild(fechaHoraCell);
				}
				
				if (headerText === "Fecha y Hora del Evento") {
			    // Obtener el valor del elemento input
			    var fechaEvento = document.getElementById("fechaSeleccionada").value;
			    // Crear una nueva celda para el valor total
			    const fechaEventolCell = document.createElement("td");
			    fechaEventolCell.textContent = fechaEvento;
			    fechaEventolCell.style.cssText = thStyleCotizacionTD;
			
			    // Agregar la celda al encabezado de la fila de totales
			    headerRowCotizacion.appendChild(fechaEventolCell);
				}
				
				if (headerText === "Cantidad de Comensales") {
			    // Obtener el valor del elemento input
			    var cantidadComensales = document.getElementById("cantidad").value;
			    // Crear una nueva celda para el valor total
			    const cantidadComensalesCell = document.createElement("td");
			    cantidadComensalesCell.textContent = cantidadComensales;
			    cantidadComensalesCell.style.cssText = thStyleCotizacionTD;
			
			    // Agregar la celda al encabezado de la fila de totales
			    headerRowCotizacion.appendChild(cantidadComensalesCell);
				}
			
			    // Agregar la fila del encabezado al encabezado de la tabla
			    theadCotizacion.appendChild(headerRowCotizacion);
		});
	
	    theadCotizacion.appendChild(headerRowCotizacion);
	    cotizacaionTable.appendChild(theadCotizacion);
		
	    // Crear una tabla para los productos en el PDF
	    const pdfTable = document.createElement("table");
	    pdfTable.style.width = "120%"; // Ancho máximo de la tabla
	    pdfTable.style.borderCollapse = "collapse";
	    pdfTable.style.fontSize = "10px";
	    pdfTable.style.marginTop = "60px";
	    pdfTable.style.marginLeft = "50px";
	    pdfTable.style.border = "1px solid #dddddd"; // Borde de la tabla
	    pdfTable.style.borderRadius = "15px"; // Bordes redondeados
	
	    
		const thStyle = "padding: 5px; width: 20%; background-color: rgb(192,192,192); font-weight: bold; text-align: center; color: black";
		const thStyleTd = "padding: 7px; width: 20%; background-color: white; font-weight: bold; text-align: center; color: black";
	
		
	    // Encabezado de la tabla
	    const thead = document.createElement("thead");
	    const headerRow = document.createElement("tr");
	    ["PRODUCTO", "CANTIDAD", "VALO UNITARIO", "SUBTOTAL"].forEach(headerText => {
	        const th = document.createElement("th");
	        th.textContent = headerText;
	        th.style.cssText = thStyle;
	        headerRow.appendChild(th);
	    });
	    
	    thead.appendChild(headerRow);
	    pdfTable.appendChild(thead);
	
	    // Cuerpo de la tabla
	    const tbody = document.createElement("tbody");
	    const productRows = document.querySelectorAll(".table tbody tr");
	    productRows.forEach(row => {
	        const newRow = document.createElement("tr");
	        const cells = row.querySelectorAll("td");
			cells.forEach((cell, index) => {
			    if (index < 4) { // Solo procesar las primeras cuatro columnas
			        const newCell = document.createElement("td");
			        if (index === 2) { // Para el valor unitario
			            const unitPrice = parseFloat(row.querySelector(".unit-price").value);
			            const unitPriceFormatted = unitPrice.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ".");
			            newCell.textContent = "$ " + unitPriceFormatted;
			        } else if (index === 3) { // Para el valor total, calcular
			            const quantity = parseInt(row.querySelector(".quantity").value);
			            const unitPrice = parseFloat(row.querySelector(".unit-price").value);
			            const totalValue = quantity * unitPrice;
			            const totalValueFormatted = totalValue.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ".");
			            newCell.textContent = "$ " + totalValueFormatted;
			        } else {
			            const inputElement = cell.querySelector("input");
			            if (inputElement) {
			                newCell.textContent = inputElement.value;
			            } else {
			                const selectElement = cell.querySelector("select");
			                if (selectElement) {
			                    newCell.textContent = selectElement.options[selectElement.selectedIndex].text;
			                } else {
			                    newCell.textContent = ""; // O cualquier valor predeterminado que desees usar
			                }
			            }
			        }
			        newCell.style.cssText = thStyleTd;
			        newRow.appendChild(newCell);
			    }
			});
	    	tbody.appendChild(newRow);
	    });
	    
	    clienteTable.appendChild(tbody);
	    pdfTable.appendChild(tbody);
	    
		
		const mensajeConsignacion = document.createElement("div");
		mensajeConsignacion.innerHTML = "<hr style='width: 100%;'>" + "Para hacer efectiva la reserva, por favor consignar el " + porcen  + " del valor Total Neto cotizado a la siguiente cuenta:" + "<br>" + 
		"<br>" + "Banco de Bogotá: Cuenta Corriente No. 270145428" + "<br>" + "Refugio del Sisga SAS" + "<br>" +  "NIT: 901420447-9";
		mensajeConsignacion.style.width = "100%"; // Ancho completo del contenedor
		mensajeConsignacion.style.maxWidth = "1000px"; // Ancho máximo del contenido interno
		mensajeConsignacion.style.margin = "0 auto"; // Centrar el div
		mensajeConsignacion.style.textAlign = "center";
		mensajeConsignacion.style.fontSize = "16px";
		mensajeConsignacion.style.marginTop = "10px";
		mensajeConsignacion.style.marginLeft = "100px";

	
	    //Tabla para totales
	    const totalesTable = document.createElement("table");
		totalesTable.style.width = "60%"; // Ancho máximo de la tabla
	    totalesTable.style.margin = "auto"; // Centrar la tabla en el contenedor
	    totalesTable.style.borderCollapse = "collapse";
	    totalesTable.style.fontSize = "12px";
	    totalesTable.style.marginTop = "10px";
	    totalesTable.style.marginLeft = "409px";
	    totalesTable.style.border = "2px solid #dddddd"; // Borde de la tabla
	    totalesTable.style.borderRadius = "15px"; // Bordes redondeados
	    cotizacaionTable.style.textAlign = "left"; // Bordes redondeados
	    
	    // Estilos para las celdas del encabezado
	    const thStyletotales = "padding: 5px; width: 5%; background-color: rgb(192,192,192); font-weight: bold; text-align: left; color: black";
	    const thStyletotalesTD = "padding-right: 5px; border-Radius: 15px; width: 10%; background-color: white; margin-left: 100px; font-weight: bold; text-align: right; color: black";
	    
	    
	    const theadTotales = document.createElement("thead");
	    const headerRowTotales = document.createElement("tr");
	    
	   ["TOTAL BRUTO","IMPO-CONSUMO","SERVICIO INCLUIDO","TOTAL NETO"].forEach(headerText => {
	    const headerRowTotales = document.createElement("tr");
	
	    // Encabezado de la columna
	    const th = document.createElement("th");
	    th.textContent = headerText;
	    th.style.cssText = thStyletotales;
	    headerRowTotales.appendChild(th);
	
	
	    // Agregar una celda para el número de identificación del cliente debajo de cada encabezado
	    if (headerText === "TOTAL BRUTO") {
		    // Obtener el valor del elemento input
		    var valTotal = parseFloat(document.getElementById("valorTotal").value);
			const base = (valTotal / 1.08).toFixed(2);
			
			 // Formatear el valor total con puntos en las unidades
		    var baseFormateado = base.replace(/\B(?=(\d{3})+(?!\d))/g, ".");
		    
		    // Crear una nueva celda para el valor total
		    const subtotalCell = document.createElement("td");
		    subtotalCell.textContent = "$ " + baseFormateado;
		    subtotalCell.style.cssText = thStyletotalesTD;
		
		    // Agregar la celda al encabezado de la fila de totales
		    headerRowTotales.appendChild(subtotalCell);
		}
		
		// Agregar una celda para el número de identificación del cliente debajo de cada encabezado
	    if (headerText === "IMPO-CONSUMO") {
		    // Obtener el valor del elemento input
		    var valTotal = parseFloat(document.getElementById("valorTotal").value);
		    
		    const base = (valTotal / 1.08).toFixed(2); // Limitar a dos decimales
		    const impoConsumo = (valTotal - base).toFixed(2); // Limitar a dos decimales
		    
		    // Formatear el valor del impo-consumo con puntos en las unidades
		    var impoConsumoFormateado = impoConsumo.replace(/\B(?=(\d{3})+(?!\d))/g, ".");
		    
		    // Crear una nueva celda para el impo-consumo
		    const ImpoCell = document.createElement("td");
		    ImpoCell.textContent = "$ " + impoConsumoFormateado;
		    ImpoCell.style.cssText = thStyletotalesTD;
		    
		    // Agregar la celda al encabezado de la fila de totales
		    headerRowTotales.appendChild(ImpoCell);
		}
		
		if (headerText === "SERVICIO INCLUIDO") {
			if (propina == "SI") {
				var valTotal = parseFloat(document.getElementById("valorTotal").value);
				const base = (valTotal / 1.08); // Obtener el valor base sin incluir la propina
				var propinanum = base * 0.1; // Calcular el 10% del valor base como propina
			
				// Formatear la propina como una cadena con dos decimales y separadores de miles
				var propinaFormateado = propinanum.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ".");

				// Crear una nueva celda para la propina
				const ImpoCell = document.createElement("td");
				ImpoCell.textContent = "$ " + propinaFormateado;
				ImpoCell.style.cssText = thStyletotalesTD;
			        
				// Agregar la celda al encabezado de la fila de totales
				headerRowTotales.appendChild(ImpoCell);
				
			    } else {
			        // Si la propina no está incluida, mostrar $0.00 como propina
			        const propinaFormateado = "0.00";
			        const ImpoCell = document.createElement("td");
			        ImpoCell.textContent = "$ " + propinaFormateado;
			        ImpoCell.style.cssText = thStyletotalesTD;
			        headerRowTotales.appendChild(ImpoCell);
			}
		}
		
		// Agregar una celda para el número de identificación del cliente debajo de cada encabezado
		if (headerText === "TOTAL NETO") {
		    // Obtener el valor total del elemento input
		    var valTotal = parseFloat(document.getElementById("valorTotal").value);
		    var propinaFormateado;
		    var valTotalFormateado;
		
		    // Verificar si la propina está incluida
		    if (propina == "SI") {
		        // Calcular la propina como el 10% del valor base
		        var base = (valTotal / 1.08); // Obtener el valor base sin incluir la propina
		        var propinanum = base * 0.1; // Calcular el 10% del valor base como propina
		
		        // Formatear la propina como una cadena con dos decimales
		        propinaFormateado = propinanum.toFixed(2);
		        
		        // Sumar la propina al valor total
		        var valTotalConPropina = valTotal + propinanum;
		        
		        // Formatear el valor total con puntos en las unidades
		        valTotalFormateado = valTotalConPropina.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ".");
		    } else {
		        // Si la propina no está incluida, el valor neto es igual al valor total
		        propinaFormateado = "0.00";
		        valTotalFormateado = valTotal.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ".");
		    }
		
		    // Crear una nueva celda para el valor total
		    const vTotalCell = document.createElement("td");
		    vTotalCell.textContent = "$ " + valTotalFormateado;
		    vTotalCell.style.cssText = thStyletotalesTD;
		
		    // Agregar la celda al encabezado de la fila de totales
		    headerRowTotales.appendChild(vTotalCell);
		}
		
	    // Agregar la fila del encabezado al encabezado de la tabla
	    theadTotales.appendChild(headerRowTotales);
		});
	
	    theadTotales.appendChild(headerRowTotales);
	    totalesTable.appendChild(theadTotales);
	    
	    const mensajePT = document.createElement("div");
	    mensajePT.innerHTML = "<br>" + "Documento de Cotización generado por © SIRPYM V1.0.1. 2024" + "<br>";
		mensajePT.style.textAlign = "center";
		mensajePT.style.fontSize = "10px";
		mensajePT.style.marginTop = "0px";
		mensajePT.style.marginLeft = "100px";
		mensajePT.style.width = "100%"; // Ancho completo del contenedor
		mensajePT.style.maxWidth = "1000px"; // Ancho máximo del contenido interno
	
	    // Agregar la tabla al contenedor del PDF
	    container.appendChild(mesajeCabecera);
	    container.appendChild(mesajeCotizacion);
	    container.appendChild(datos);
	    container.appendChild(clienteTable);
	    container.appendChild(cotizacaionTable);
	    container.appendChild(pdfTable);
	    container.appendChild(totalesTable);
	    container.appendChild(mensajeConsignacion);
	    container.appendChild(mensajePT);

		// Generar el PDF a partir del contenedor
		const selectedOptionClienteNombre = document.getElementById("numeroIDClientes").value;
		const numeroidClienteNombre = selectedOptionClienteNombre;
			    
		// Obtener la fecha y hora actual del sistema
		const fechaHoraActual = new Date();
			    
		// Formatear la fecha y hora en el formato deseado
		const fechaFormateada = fechaHoraActual.toLocaleDateString().replace(/\//g, ''); // Elimina las barras "/"
		const horaFormateada = fechaHoraActual.toLocaleTimeString().replace(/:/g, ''); // Elimina los dos puntos ":"
			    
		// Concatenar la fecha y la hora formateadas
		const fechaHoraFormateada = `${fechaFormateada}${horaFormateada}`;
		
		// Abrir el contenido en otra ventana
		const newWindow = window.open("", numeroidClienteNombre + "_pdf");
		newWindow.document.body.appendChild(container);
			
		html2pdf().set({
		    margin: 1,
		    filename: fechaHoraFormateada + "_" +  numeroidClienteNombre + '.pdf',
		    image: { type: 'jpeg', quality: 1 }, // Ajusta la calidad de las imágenes
		    html2canvas: { scale: 10 } // Ajusta la escala para mejorar la calidad
		}).from(container).save();

}

function obtenerValorAbono() {
    var select = document.getElementById("opciones1");
    var valorSeleccionado = select.value;
    console.log("Valor seleccionado:", valorSeleccionado);
    // Realiza cualquier otra lógica necesaria aquí
	porcen = valorSeleccionado;
}

function obtenerValorPropina() {
    var select = document.getElementById("opciones2");
    var valorSeleccionado = select.value;
    // Realiza cualquier otra lógica necesaria aquí
	propina = valorSeleccionado;
}