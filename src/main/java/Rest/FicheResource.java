package Rest;

import jaxrs.Dao.FicheDao;
import kanban.Fiche;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
@Path("/fiche")
@Produces({"application/json", "application/xml"})

public class FicheResource {


        private FicheDao  fichedao;

        public  FicheResource()
        {
            this.fichedao=new FicheDao();
        }

        @GET
        @Path("/{ficheId}")
        @Produces(MediaType.APPLICATION_JSON)
        public  Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {
            Fiche fiche= this.fichedao.findOne(ficheId);
            return  fiche;
        }
    
        @GET
        @Path("/fiche/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Fiche> getFiche(){


            return this.fichedao.listFiche();
        }


        @POST
        @Path("/fiche")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void createUtilisateur(Fiche f) {

            this.fichedao.saveFiche(f);

        }


        @DELETE
        @Path("/fiche/delete")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteUtilisateur(Fiche f) {

            this.fichedao.delete(f);

        }

        @DELETE
        @Path("/fiche/delete/{deleteID}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteFicheById(Long utilisateurId) {

            this.fichedao.deleteById(utilisateurId);

        }

    }
