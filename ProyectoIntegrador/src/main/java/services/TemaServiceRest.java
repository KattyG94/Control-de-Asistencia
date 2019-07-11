package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import modelos.Tema;
import on.TemaON;

@Path("/tema")
public class TemaServiceRest {
	
	
	

		@Inject
		private TemaON tON;
		
		@GET
		@Path("/listar")
		@Produces("application/json")
		public List<Tema> getEstudiantes(){
			return tON.getListadoTemas();
		}
		
		@POST
		@Path("/save")
		@Consumes("application/json")
		@Produces("application/json")
		public Response insertEst(Tema tema) {
			ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			
			try {
				tON.save(tema);
				data.put("code", "1");
				data.put("message", "ok");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("code", "99");
				data.put("message", e.getMessage());
				builder = Response.status(Response.Status.OK).entity(data);
			}
			return builder.build();
		}
		
		@POST
		@Path("/update")
		@Consumes("application/json")
		@Produces("application/json")
		public Response updateEst(Tema tema) {
			ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			try {
				tON.actualizar(tema);
				data.put("code", "1");
				data.put("message", "ok");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("code", "99");
				data.put("message", e.getMessage());
				builder = Response.status(Response.Status.OK).entity(data);
			}
			return builder.build();
		}
		
		@DELETE
		@Path("/delete")
		@Consumes("application/json")
		@Produces("application/json")
		public Response borrarEst(@QueryParam("id")int id) {
			ResponseBuilder builder = null;
			Map<String, String> data = new HashMap<>();
			
			try {
				tON.borra(id);
				data.put("code", "1");
				data.put("message", "ok");
				builder = Response.status(Response.Status.OK).entity(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				data.put("code", "99");
				data.put("message", e.getMessage());
				builder = Response.status(Response.Status.OK).entity(data);
			}
			return builder.build();
		}	
		
		@GET
		@Path("/buscar")
		@Produces("application/json")
		public Tema buscar(@QueryParam("codigo")int codigo) {
			return tON.buscar(codigo);
		}

}
