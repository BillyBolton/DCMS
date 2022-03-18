package ca.me.proj.entity.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import ca.me.proj.dtos.payment.PaymentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PATIENT_BILLING")
public class PatientBillingEntity extends PaymentEntity {

    @Column(name = "card_number")
    private long cardNumber;

    @Column(name = "expiry_date")
    private int expiryDate;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "payment_type")
    private PaymentType paymentType;


}
