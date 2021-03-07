package Rest;


import jaxrs.Dao.FicheDao;
import kanban.Fiche;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
    public class SwaggerResource {


        private static final Logger logger = Logger.getLogger(SwaggerResource.class.getName());

        @GET
        @Path("/")
        public byte[] Get1() {
            try {
                return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/index.html"));
            } catch (IOException e) {
                return null;
            }
        }
        /*

        @GET
        @Path("/")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Fiche>fichesAll(){
            return new FicheDao().listFiche();
        }*/

        @GET
        @Path("{path:.*}")
        public byte[] Get(@PathParam("path") String path) {
            try {
                return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/"+path));
            } catch (IOException e) {
                return null;
            }
        }

    }
