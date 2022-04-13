package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.IClienteService;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class Controller {
	
	@Autowired
	IClienteService clienteService;

	@GetMapping("/list_all")
	public List<Cliente> listClientes() {
		return clienteService.listado_clientes();
	}
	
	public static void main(String[] args) {
		System.out.print("Probando a ver que se ve");
	}

}
