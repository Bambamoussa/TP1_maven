package Rest;

import jaxrs.Dao.FicheDao;
import jaxrs.Dao.SectionDao;
import kanban.Fiche;
import kanban.Section;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/api")
@Produces({"application/json", "application/xml"})

public class SectionResource {

        private SectionDao sectiondao;

        public  SectionResource()
        {
            this.sectiondao= new SectionDao();
        }

        @GET
        @Path("/section/{sectionId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Section getSectionById(@PathParam("sectionId") Long sectionId)  {
            Section section= this.sectiondao.findOne(sectionId);
            return  section;
        }

        @GET
        @Path("/section/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List <Section> getSection(){


            return this.sectiondao.listSection();
        }


        @POST
        @Path("/section")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void createSection(Section s) {

            this.sectiondao.saveSection(s);

        }


        @DELETE
        @Path("/section/delete")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteSection(Section s) {

            this.sectiondao.delete(s);

        }

        @DELETE
        @Path("/section/delete/{deleteID}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteSectionById(Long sectionId) {

            this.sectiondao.deleteById(sectionId);

        }

    }


