package jpa.Heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Sondate_date")

public class SondageDate extends Sondage {

    public Date getChoix_date() {
        return super.getChoix_date();
    }

}
