package pildoras.es.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pildoras.es.controlador.entity.Cliente;

@Repository//PARA QUE TODA ESTA CLASE SEA REGISTRADA COMO UN BEAN
public class ClienteDAOClase implements ClienteDAO {

	
	@Override
	@Transactional//NOS AHORRAMOS LA TRANSACCIÓN, BEGIN, COMMIT, O EL ROLLBACK.
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		//(1)OBTENER LA SESSION
		Session miSession = sessionFactory.getCurrentSession();
		//(2)CREAR LA CONSULTA ("tabla Cliente", clase Cliente)
		Query<Cliente>miQuery = miSession.createQuery("from Cliente", Cliente.class);
		//(3)EJECURAR QUERY Y DEVOLVER RESULTADOS
		List<Cliente>clientes = miQuery.getResultList();
		return clientes;
	}
	
	
	//DECLARAMOS U SESSIONFACTORY Y LE PONEMOS EL MISMO NOMBRE DEL ARCHIVO XML... Y LE HACEMOS UNA INYECCIÓN DE DEPENDENCIAS, PARA USARLO EN EL MÉTODO.
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		//OBTENER LA SESSION
		Session miSession = sessionFactory.getCurrentSession();
		//INSERTAR EL CLIENTE
		miSession.save(elCliente);
		
	}
	
}
