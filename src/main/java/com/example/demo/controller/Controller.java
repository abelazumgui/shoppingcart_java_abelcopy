package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.IClienteService;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class Controller {
	
	@Autowired
	IClienteService cservice;

	@GetMapping("/list_all")
	public List<Cliente> listClientes() {
		return cservice.listado();
	}
	
	@PostMapping("/nuevo")
	public String añadirCliente(@RequestBody Cliente cliente){
		Cliente nuevo=cservice.busqueda_id(cliente.getId());
		if(nuevo==null) {
			cservice.alta(cliente);
			return "Añadido correctamente.";
		} else {
			return "Ya existe.";
		}
	}
	
	@GetMapping("/buscarcliente/{id_cliente}")
	public String verCliente(@PathVariable("id_cliente") Integer id_cliente){
		Cliente nuevo=cservice.busqueda_id(id_cliente);
		if(nuevo==null) {
			return null;
		} else {
			return nuevo.toString()+"<html><body><br/><a href='http://localhost:1304/clientes/inicio'>Volver</a></body></html>";
		}
	}
	
	@DeleteMapping("/eliminarcliente/{id_cliente}")
	public String eliminarDisco(@PathVariable("id_cliente") Integer id_cliente){
		Cliente nuevo=cservice.busqueda_id(id_cliente);
		if(nuevo==null) {
			return "No existe.";
		} else {
			cservice.eliminar(id_cliente);
			return "Eliminado.";
		}
	}
	
	@PutMapping("/modificar")
	public String modificarDisco(@RequestBody Cliente cliente){
		Cliente nuevo=cservice.busqueda_id(cliente.getId());
		if(nuevo==null) {
			return "No existe.";
		} else {
			cservice.modificar(cliente);
			return "Modificado.";
		}
	}
	
	@GetMapping(value = "/inicio", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String welcomeAsHTML() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" +
          "<body>\n\n" + ""
          		+ "<a href='http://localhost:1304/clientes/list_all'>Ver listado clientes</a></br>"
          		+ "<a href='http://localhost:1304/clientes/añadir'>Añadir cliente</a></br>"
          		+ "<a href='http://localhost:1304/clientes/list_all'>Ver clientes</a></br>"
          		+ "<a href='http://localhost:1304/clientes/list_all'>Ver clientes</a></br>"
          		+ "<a href='http://localhost:1304/clientes/buscarcliente/1'><input type='button' value='Cliente 1'></a>"
          		+ "<a href='http://localhost:1304/clientes/buscarcliente/2'><input type='button' value='Cliente 2'></a>"
          		+ "<a href='http://localhost:1304/clientes/buscarcliente/3'><input type='button' value='Cliente 3'></a>"
          		+ "<a href='http://localhost:1304/clientes/buscarcliente/4'><input type='button' value='Cliente 4'></a>"
          		+ "</body>"
          		+ "</html>";
    }
	
	@GetMapping(value = "/añadir", produces = MediaType.TEXT_HTML_VALUE)
	public String añadirCliente() {
		return "<html><body>"
				+ "<form action='LoginServlet' method='POST'>"
				+ "<p>Id: <input type='text' id='id'></p>"
				+ "<p>Nombre: <input type='text' id='nombre'></p>"
				+ "<p>Telefono: <input type='text' id='telefono'></p>"
				+ "<p>Email: <input type='text' id='email'></p>"
				+ "<input type='submit' value='Alta'>"
				+ "</form>"
				+ "<a href='http://localhost:1304/clientes/inicio'>Volver</a>"
				+ "</body></html>";
	}
	
	
	
	
}
