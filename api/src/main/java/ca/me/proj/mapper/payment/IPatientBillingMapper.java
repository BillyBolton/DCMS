package ca.me.proj.mapper.payment;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.payment.PatientBillingDTO;
import ca.me.proj.entity.payment.PatientBillingEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IPatientBillingMapper
        extends IBaseMapper<PatientBillingDTO, PatientBillingEntity> {

}
