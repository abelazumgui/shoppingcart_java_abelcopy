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
	ClienteRepository clienteRepo;

	@Override
	public ArrayList<Cliente> listado_clientes() {
		return (ArrayList<Cliente>)clienteRepo.findAll();
	}

}
