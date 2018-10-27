package br.edu.etep.creche.model.webservice;

import br.edu.etep.creche.model.DAO.UsuarioDAO;
import br.edu.etep.creche.model.Usuario;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("Creche")
public class WSCreche {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario user = new Usuario();
    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public WSCreche() {
    }

    /**
     * Retrieves representation of an instance of
     * br.edu.etep.creche.model.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/get/{login}")
    public String getUsuario(
            @PathParam("login") String login) {

        user.setLogin(login);
        user = dao.buscar(user);

        return gson.toJson(user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Usuario/list")
    public String listUsuarios() {

        List<Usuario> lista;
        lista = dao.listar();
        return gson.toJson(lista);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/inserir")
    public boolean inserir(String content) {

        user = gson.fromJson(content, Usuario.class);
        return dao.inserir(user);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/alterar")
    public void alterar(String content) {

        user = gson.fromJson(content, Usuario.class);
        dao.atualizar(user);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Usuario/excluir/{login}")
    public boolean excluir(@PathParam("login") String login) {

        user.setLogin(login);
        user = dao.buscar(user);
        return dao.excluir(user);
    }

}
