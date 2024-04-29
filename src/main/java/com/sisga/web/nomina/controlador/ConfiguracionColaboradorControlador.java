package com.sisga.web.nomina.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisga.web.cotizaciones.modelo.TipodeID;
import com.sisga.web.nomina.controlador.dto.ColaboradoresRegistroDTO;
import com.sisga.web.nomina.modelo.Colaborador;
import com.sisga.web.nomina.repositorio.ColaboradoresRepositorio;
import com.sisga.web.nomina.servicio.ColaboradoresServicio;

@Controller
public class ConfiguracionColaboradorControlador {

	@Autowired
	private ColaboradoresRepositorio colaboradoresRepositorio;

	@Autowired
	private ColaboradoresServicio colaboradoresServicio;

	@PostMapping("/eliminarColaborador")
	public String eliminarColaboradorPorId(@RequestParam Long id) {
		colaboradoresServicio.deleteById(id);
		return "redirect:/ConfiguracionDeColaboradores?delete";
	}

	@PostMapping("/editarColaborador")
	public String editarColaborador(@RequestParam("id") String idStr, 
			@RequestParam("nombreCompleto") String nombreCompleto,
			@RequestParam("tipoDeDocumento") TipodeID tipoDeDocumento,
			@RequestParam("numeroDeDocumento") String numeroDeDocumento,
			@RequestParam("tipoDeContrato") String tipoDeContrato,
			@RequestParam("tipoDeCargo") String tipoDeCargo,
			@RequestParam("correoElectronico") String correoElectronico, 
			@RequestParam("numeroDeContacto") String numeroDeContacto, 
			@RequestParam("direccion") String direccion,
			@RequestParam("fechaDeIngreso") String fechaDeIngreso, 
			Model modelo,
			ColaboradoresRegistroDTO colaboradoresRegistroDTO) {
		modelo.addAttribute("tiposID", TipodeID.values());

		try {
			Long id = Long.parseLong(idStr);
			System.out.println("Aca pasa " + colaboradoresServicio.existeColaborador(colaboradoresRegistroDTO.getNumeroDeDocumento()));
			Colaborador colaborador = colaboradoresRepositorio.findById(id).orElse(null);

			if (colaborador != null) {
				colaborador.setNombreCompleto(nombreCompleto);
				colaborador.setTipoDeDocumento(tipoDeDocumento);
				colaborador.setNumeroDeDocumento(numeroDeDocumento);
				colaborador.setTipoDeContrato(tipoDeContrato);
				colaborador.setTipoDeCargo(tipoDeCargo);
				colaborador.setCorreoElectronico(correoElectronico);
				colaborador.setNumeroDeContacto(numeroDeContacto);
				colaborador.setDireccion(direccion);
				colaborador.setFechaDeIngreso(fechaDeIngreso);
				colaboradoresRepositorio.save(colaborador);
				return "redirect:/ConfiguracionDeColaboradores?save";
			} else {
				return "Cliente no encontrado";
			}

		} catch (NumberFormatException e) {
			return "Error en formato de número";
		} catch (Exception e) {
			return "Error al actualizar el Colaborador";
		}
	}

}
