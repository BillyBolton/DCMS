package ca.me.proj.dtos.branch;

import ca.me.proj.dtos.address.AddressDTO;
import ca.me.proj.dtos.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BranchDTO extends BaseDTO {
    // PK
    private String id;

    // FK
    private String manager_id;

    private AddressDTO address;
    // private String address_id;


}
