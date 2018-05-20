package pe.edu.upc.marcelo.api;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import pe.edu.upc.marcelo.entities.Cliente;
import pe.edu.upc.marcelo.service.inter.IClienteService;

@Path("/v1/clientes")
public class ClienteRest {

	@Inject
	IClienteService clienteService;
	
	Gson gson;

	@PostConstruct
	void init() {
		gson = new Gson();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(Cliente c) {

		String out = "";

		try {
			clienteService.create(c);
			out = gson.toJson("Cliente Registrado");
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(out).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listClientes() {

		List<Cliente> clientes = new ArrayList<>();
		String out = "";
		
		try {
			clientes = clienteService.reader();
			out = gson.toJson(clientes);
		} catch (Exception e) {
			// TODO: handle exception
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}

		return Response.status(Response.Status.OK).entity(out).build();
	}

}
