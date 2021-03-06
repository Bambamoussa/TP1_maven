package jaxrs.Heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("sondage_lieu")

public class SondageLieu extends  Sondage {
    private  String choix_date_lieu_;

    public String getChoix_date_lieu() {
        return super.getChoix_date_lieu();
    }



}
