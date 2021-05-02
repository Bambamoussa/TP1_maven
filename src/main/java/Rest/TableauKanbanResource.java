package Rest;

import jaxrs.Dao.FicheDao;
import jaxrs.Dao.TablauKanbanDao;
import kanban.Fiche;
import kanban.TableauKanban;
import kanban.Utilisateur;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/api")
@Produces({"application/json", "application/xml"})

public class TableauKanbanResource {







        private TablauKanbanDao tableaukanbandao;

        public  TableauKanbanResource()
        {
            this.tableaukanbandao= new TablauKanbanDao();
        }

        @GET
        @Path("/tableau/{tableauId}")
        @Produces(MediaType.APPLICATION_JSON)
        public TableauKanban getTableauKanById(@PathParam("tableauId") Long tableauId)  {
            TableauKanban tableau = this.tableaukanbandao.findOne(tableauId);
            return  tableau;
        }

        @GET
        @Path("/tableau/all")
        @Produces(MediaType.APPLICATION_JSON)
        public List <TableauKanban> getTableau(){


            return this.tableaukanbandao.listTableaux();
        }


        @POST
        @Path("/tableau")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void createUtilisateur(TableauKanban t) {

            this.tableaukanbandao.saveTableau(t);

        }


        @DELETE
        @Path("/tableau/delete")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public void deleteTableau(TableauKanban t) {

            this.tableaukanbandao.delete(t);

        }

        @DELETE
        @Path("/tableau/delete/{deleteID}")

        public void deleteTableauById(@PathParam("deleteID") Long utilisateurId) {

            this.tableaukanbandao.deleteById(utilisateurId);

        }

    @POST
    @Path("tableau/{tableauId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TableauKanban updateFicheById(@PathParam("tableauId") Long tableauId, TableauKanban table)  {
        TableauKanban updatetableau= this.tableaukanbandao.findOne(tableauId);
        updatetableau.setLibelle_tableau(table.getLibelle_tableau());

        TableauKanban tableauKanban= this.tableaukanbandao.update(updatetableau);
        return  tableauKanban;
    }

    }
