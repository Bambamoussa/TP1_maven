package kanban;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private  long id_section;

    public long getId_section() {
        return id_section;
    }

    public void setId_section(long id_section) {
        this.id_section = id_section;
    }

    private  String libelle_section;

    public String getLibelle_section() {
        return libelle_section;
    }

    public void setLibelle_section(String libelle_section) {
        this.libelle_section = libelle_section;
    }

    @OneToMany(mappedBy="section" , cascade = CascadeType.ALL)
    private Set<Fiche> fiches = new HashSet<Fiche>();

    public void addFiches(Fiche f) {
        f.setSection(this);
        fiches.add(f) ;
    }


}
