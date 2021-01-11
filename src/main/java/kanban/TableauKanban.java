package kanban;

import javax.persistence.*;
import java.util.List;

@Entity
public class TableauKanban {
    private Long id_Kanban;
    private List<Section>  sections;
    private  List <Fiche> fiches;

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    public List <Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List <Fiche> fiches) {
        this.fiches = fiches;
    }




    public void setSections(List <Section> sections) {
        this.sections = sections;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId_Kanban() {
        return id_Kanban;
    }

    public void setId_Kanban(Long id_Kanban) {
        this.id_Kanban = id_Kanban;
    }

    @OneToMany(mappedBy = "tableaukanban", cascade = CascadeType.PERSIST)
    @Enumerated(EnumType.STRING)

    public List <Section> getSections() {
        return sections;
    }



}
