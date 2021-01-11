package kanban;

import javax.persistence.*;

@Entity
public enum  Section {

    Attente("en attente"),
    EnCours("en cours"),
    Realise("  realisé  ");

    @ManyToOne
    public Fiche getFichier() {
        return fichier;
    }

    public void setFichier(Fiche fichier) {
        this.fichier = fichier;
    }
    @ManyToOne
    public TableauKanban getTableaukanban() {
        return tableaukanban;
    }

    public void setTableaukanban(TableauKanban tableaukanban) {
        this.tableaukanban = tableaukanban;
    }

    private  Fiche fichier;
    private TableauKanban tableaukanban;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId_section() {
        return id_section;
    }

    public void setId_section(Long id_section) {
        this.id_section = id_section;
    }

    private  Long id_section;
    private String section;

    Section(String section) {
        this.section=section;

    }


}
