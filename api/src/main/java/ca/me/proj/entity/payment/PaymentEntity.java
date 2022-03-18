package ca.me.proj.entity.payment;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PAYMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PaymentEntity {

    @Id
    @Column(name = "id")
    protected Long eId;

    @Column(name = "amount")
    protected Double amount;

    @Column(name = "date")
    protected Date date;

}
