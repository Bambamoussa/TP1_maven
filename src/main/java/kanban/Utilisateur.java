package kanban;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Utilisateur implements Serializable {

    private  Long id_utilisateur;
    private List<Fiche> fiches;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @OneToMany(mappedBy="utilisateur")
    public List <Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List <Fiche> fiches) {
        this.fiches = fiches;
    }



}
