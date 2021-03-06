package ca.me.proj.entity.treatment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TREATMENT")
public class TreatmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "medication")
    private String medication;

    @Column(name = "procedure_id")
    private String procedureId;

    // @Column(name = "teeth")
    // private Character teeth;

    @Column(name = "symptoms")
    private String symtoms;

    @Column(name = "comments")
    private String comments;


}
