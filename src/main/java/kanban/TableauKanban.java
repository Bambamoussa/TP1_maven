package kanban;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TableauKanban {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_Kanban;



    private String libelle_tableau;

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.ALL)
    private Set<Fiche> fiches= new HashSet<Fiche>();

    public void addFiches(Fiche f) {
        f.setTableau(this);
        fiches.add(f) ;
    }

    public String getLibelle_tableau() {
        return libelle_tableau;
    }

    public void setLibelle_tableau(String libelle_tableau) {
        this.libelle_tableau = libelle_tableau;
    }

    public Long getId_Kanban() {
        return id_Kanban;
    }

    public void setId_Kanban(Long id_Kanban) {
        this.id_Kanban = id_Kanban;
    }



}
