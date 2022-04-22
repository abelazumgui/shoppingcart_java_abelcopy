package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IClienteService;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	ClienteRepository clirepository;

	
	@Override
	public void alta(Cliente cliente) {
		clirepository.save(cliente);
	}

	@Override
	public Cliente busqueda_id(int id) {
		return clirepository.findById(id).orElse(null);
	}

	@Override
	public void modificar(Cliente cliente) {
		clirepository.save(cliente);
	}

	@Override
	public void eliminar(int id) {
		clirepository.deleteById(id);
	}
	
	@Override
	public ArrayList<Cliente> listado() {
		return (ArrayList<Cliente>)clirepository.findAll();
	}

}
