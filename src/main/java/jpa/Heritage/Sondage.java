package jpa.Heritage;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public  abstract  class Sondage {

    private  Long id_Sondage;


    @Id
    @GeneratedValue(strategy=
            GenerationType.AUTO)
    public Long getId_Sondage() {
        return id_Sondage;
    }

    public void setId_Sondage(Long id_Sondage) {
        this.id_Sondage = id_Sondage;
    }

    private Date choix_date;
    private String choix_lieu;
    private String choix_date_lieu;

    public Date getChoix_date() {
        return choix_date;
    }

    public void setChoix_date(Date choix_date) {
        this.choix_date = choix_date;
    }

    public String getChoix_lieu() {
        return choix_lieu;
    }

    public void setChoix_lieu(String choix_lieu) {
        this.choix_lieu = choix_lieu;
    }

    public String getChoix_date_lieu() {
        return choix_date_lieu;
    }

    public void setChoix_date_lieu(String choix_date_lieu) {
        this.choix_date_lieu = choix_date_lieu;
    }


}
