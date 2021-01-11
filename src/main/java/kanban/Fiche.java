package kanban;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Fiche implements Serializable {




    private Long id_fiche;
    private  String libelle;
    private Date date_buttoir;
    private String lieu;
    private String url;
    private Long temps;
    private  Utilisateur utilisateur;
    private  TableauKanban tableau;

    @ManyToOne
    public TableauKanban getTableau() {
        return tableau;
    }

    public void setTableau(TableauKanban tableau) {
        this.tableau = tableau;
    }

    private List<Section> sections;
    private List <Tag> tag;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String note ;

    @OneToMany(mappedBy = "fiche", cascade = CascadeType.PERSIST)
    public List <Tag> getTag() {
        return tag;
    }
    @OneToMany(mappedBy = "fichier", cascade = CascadeType.PERSIST)
    public List <Section> getSections() {
        return sections;
    }

    public void setSections(List <Section> sections) {
        this.sections = sections;
    }

    public void setTag(List <Tag> tag) {
        this.tag = tag;
    }



    @ManyToOne
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }





    public Long getTemps() {
        return temps;
    }

    public void setTemps(Long temps) {
        this.temps = temps;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Temporal(TemporalType.DATE)
    public Date getDate_buttoir() {
        return date_buttoir;
    }

    public void setDate_buttoir(Date date_buttoir) {
        this.date_buttoir = date_buttoir;
    }

    public String getLieu() {
        return lieu;
    }

    @Id
    @GeneratedValue(strategy=
            GenerationType.AUTO)
    public Long getId_fiche() {
        return id_fiche;
    }

    public void setId_fiche(Long id_fiche) {
        this.id_fiche = id_fiche;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
