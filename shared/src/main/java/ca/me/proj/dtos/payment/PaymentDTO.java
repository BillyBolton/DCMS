package ca.me.proj.dtos.payment;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PaymentDTO implements Serializable {

    protected Long eId;
    protected Double amount;
    protected LocalDate date;

}
