package ca.me.proj.dtos.payment;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PatientBillingDTO extends PaymentDTO {

    private long cardNumber;
    private int expiryDate;
    private PaymentType paymentType;

}
