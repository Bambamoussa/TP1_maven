package Rest;

import jaxrs.Dao.FicheDao;
import jaxrs.Dao.TagDao;
import kanban.Fiche;
import kanban.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/tag")
@Produces({"application/json", "application/xml"})
public class TagResource {

        private TagDao tagdao;

        public  TagResource()
        {
            this.tagdao=new TagDao();
        }

        @GET
        @Path("/{tagId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Tag getTagById(@PathParam("tagId") Long ficheId)  {
            Tag tag= this.tagdao.findOne(ficheId);
            return  tag;
        }

        @GET
        @Path("/tag/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List <Tag> getTag(){


            return this.tagdao.listTags();
        }


        @POST
        @Path("/tag")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void createTag(Tag f) {

            this.tagdao.saveTag(f);

        }


        @DELETE
        @Path("/fiche/delete")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteUtilisateur(Tag f) {

            this.tagdao.delete(f);

        }

        @DELETE
        @Path("/tag/delete/{deleteID}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteFicheById(Long utilisateurId) {

            this.tagdao.deleteById(utilisateurId);

        }

    }
