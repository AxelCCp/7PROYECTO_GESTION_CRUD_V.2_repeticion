package pildoras.es.dao;

import java.util.List;

import pildoras.es.controlador.entity.Cliente;

public interface ClienteDAO {

	//CREAMOS UNA LISTA DE TIPO CLIENTES PARA ALMACENAR CLIENTES
	public List<Cliente>getClientes();

	public void insertarCliente(Cliente elCliente);
	
}
