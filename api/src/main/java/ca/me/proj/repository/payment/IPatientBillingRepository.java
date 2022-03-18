package ca.me.proj.repository.payment;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.payment.PatientBillingEntity;

@Repository
public interface IPatientBillingRepository extends CrudRepository<PatientBillingEntity, Long> {

    @Override
    @Query(value = "SELECT * from PATIENT_BILLING", nativeQuery = true)
    List<PatientBillingEntity> findAll();

}
