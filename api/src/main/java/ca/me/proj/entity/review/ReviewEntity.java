package ca.me.proj.entity.review;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity
@Table(name="REVIEW")
public class ReviewEntity {
    
    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Column(name = "date")
    private Date date;

    @NotNull
    @Column(name = "branch_id")
    private String branchId;

    @NotNull
    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "professionalism")
    private Long professionalism;

    @Column(name = "communication")
    private Long communication;

    @Column(name = "cleanliness")
    private Long cleanliness;

    @Column(name = "value")
    private Long value;

    @Column(name = "comments")
    private String comments;
}