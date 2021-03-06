package Rest;

import jaxrs.Dao.FicheDao;
import jaxrs.Dao.SectionDao;
import kanban.Fiche;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/section")
@Produces({"application/json", "application/xml"})

public class SectionResource {
/*
        private SectionDao sectiondao;

        public  SectionResource()
        {
            this.sectiondao= new SectionDao();
        }

        @GET
        @Path("/{sectionId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Fiche getFicheById(@PathParam("ficheId") Long ficheId)  {
            Fiche fiche= this.sectiondao.findOne(ficheId);
            return  fiche;
        }

        @GET
        @Path("/fiche/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List <Fiche> getFiche(){


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
        @Path("/utilisateur/delete/{deleteID}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteUtilisateurById(Long utilisateurId) {

            this.fichedao.deleteById(utilisateurId);

        }

    }*/

}
