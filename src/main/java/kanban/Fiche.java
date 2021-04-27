package kanban;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Fiche implements Serializable {



    @Id
    @GeneratedValue(strategy=
            GenerationType.AUTO)
    private long id_fiche;

    public void setId_fiche(long id_fiche) {
        this.id_fiche = id_fiche;
    }

    private  String libelle;
    private Date date_buttoir;
    private String lieu;
    private String url;
    private Long temps;
    @ManyToOne
    private  Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne
    @JoinColumn (name="id_utilisateur")
    private  Utilisateur utilisateur;
    @ManyToOne
    private  TableauKanban tableau;



    @OneToMany(mappedBy = "fiche", cascade = CascadeType.ALL)
    private Set<Tag> tags= new HashSet<>();
    public void addTag(Tag t) {
        t.setFiche(this);
        tags.add(t) ;
    }



    public TableauKanban getTableau() {
        return tableau;
    }

    public void setTableau(TableauKanban tableau) {
        this.tableau = tableau;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String note ;




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


    public long getId_fiche() {
        return id_fiche;
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
