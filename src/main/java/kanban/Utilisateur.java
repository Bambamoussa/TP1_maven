package kanban;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_utilisateur;
    private  String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private  String prenom;

    @OneToMany(mappedBy="utilisateur", cascade = CascadeType.ALL)
    private Set<Fiche> fiches = new HashSet<Fiche>();

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void addFiches(Fiche f) {
        f.setUtilisateur(this);
        fiches.add(f) ;
    }


}
