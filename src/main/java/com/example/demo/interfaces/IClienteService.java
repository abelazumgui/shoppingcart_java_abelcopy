package com.example.demo.interfaces;

import java.util.ArrayList;

import com.example.demo.model.Cliente;


public interface IClienteService {
	
	
	public void alta(Cliente cliente);
	public Cliente busqueda_id(int id);
	public void modificar(Cliente cliente);
	public void eliminar(int id_cliente);
	public ArrayList<Cliente> listado();

}
