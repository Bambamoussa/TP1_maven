package Rest;

import jaxrs.Dao.UtilisateuDao;
import kanban.Utilisateur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


    @Path("/api")
    @Produces({"application/json", "application/xml"})
    public class UtilisateurResource {
        private UtilisateuDao utilisateurdao;
        List <Utilisateur> uti=new ArrayList <Utilisateur>();
        public  UtilisateurResource()
        {
            this.utilisateurdao=new UtilisateuDao();
        }

        @GET
        @Path("/utilisateur/{utilisateurId}")
        @Produces(MediaType.APPLICATION_JSON)
        public  Utilisateur getUtilisateurById(@PathParam("utilisateurId") Long utilisateurId)  {
            Utilisateur utilisateur= this.utilisateurdao.findOne(utilisateurId);
            return  utilisateur;
        }

        @GET
        @Path("/utilisateur/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Utilisateur> getUtilisateur(){


            return this.utilisateurdao.listUtilisateurs();
        }


        @POST
        @Path("/utilisateur")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void createUtilisateur(Utilisateur u) {

            this.utilisateurdao.saveUtilisater(u);

        }


        @DELETE
        @Path("/utilisateur/delete")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteUtilisateur(Utilisateur u) {

            this.utilisateurdao.delete(u);

        }

        @DELETE
        @Path("/utilisateur/delete/{deleteID}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteUtilisateurById(Long utilisateurId) {

            this.utilisateurdao.deleteById(utilisateurId);

        }

    }
