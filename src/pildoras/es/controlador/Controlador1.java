package pildoras.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pildoras.es.controlador.entity.Cliente;
import pildoras.es.dao.ClienteDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador1 {
	
	//NOS DEVUELVE UN ARCHIVO JSP. 
	@RequestMapping("/lista")
	public String vistaClientes(Model elModelo) {
		
		//OBTENER LOS CLIENTES DESDE EL DAO
		List<Cliente>losClientes=clienteDAO.getClientes();
		
		//AGREGAR LOS CLIENTES AL MODELO
		elModelo.addAttribute("clientes", losClientes);
		
		return "lista-clientes";  
	}
	
	
	
	//MAPEO AL FORMULARIO PARA INSERTAR REGISTROS
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model elModelo) {
		
		//BIND DATOS CLIENTES 
		Cliente elCliente = new Cliente();
		elModelo.addAttribute("cliente", elCliente);
		
		return "muestraFormularioAgregar";
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente")Cliente elCliente) {
		
		//INSERTAR CLIENTE LA BASE DE DATOS 
		clienteDAO.insertarCliente(elCliente);
		
		return "redirect:/cliente/lista";
	}
	
	@Autowired
	private ClienteDAO clienteDAO;	 
}
