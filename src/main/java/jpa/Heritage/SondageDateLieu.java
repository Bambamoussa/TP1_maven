package jpa.Heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("sondage_date_lieu")

public class SondageDateLieu extends Sondage{

    public String getChoix_date_lieu() {
        return super.getChoix_date_lieu();
    }


}
