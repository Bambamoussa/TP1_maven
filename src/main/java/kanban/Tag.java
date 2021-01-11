package kanban;

import javax.persistence.*;

@Entity
public class Tag {

    private Long id_Tag;
    private String libelle;
    private Fiche fiche ;

    @ManyToOne
    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    @Id
    @GeneratedValue(strategy=
            GenerationType.AUTO)
    public Long getId_Tag() {
        return id_Tag;
    }

    public void setId_Tag(Long id_Tag) {
        this.id_Tag = id_Tag;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



}
