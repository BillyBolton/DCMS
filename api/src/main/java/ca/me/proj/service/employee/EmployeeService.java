package ca.me.proj.service.employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.dtos.employee.NewEmployeeDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.mapper.employee.IEmployeeMapper;
import ca.me.proj.repository.branch.IBranchRepository;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.repository.profile.IProfileRepository;
import ca.me.proj.service.profile.ProfileService;

@Service
public class EmployeeService {

    @Autowired
    private IEmployeeMapper mapper;

    @Autowired
    private IProfileRepository profileRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private ProfileService profileService;

    public List<EmployeeDTO> findAll() {
        return mapper.entityToDto(employeeRepository.findAll());
    }

    public List<EmployeeDTO> findDentistByBranchId(String branchId) {
        return mapper.entityToDto(employeeRepository.findDentistByBranchId(branchId));
    }

    public EmployeeDTO createEmployee(EmployeeDTO dto) {

        if (profileService.existsByID(dto.getId())) {
            return mapper.entityToDto(employeeRepository.save(mapper.dtoToEntity(dto)));
        } else {
            dto.setProfile(profileService.createProfile(dto.getProfile()));
            return mapper.entityToDto(employeeRepository.save(mapper.dtoToEntity(dto)));
        }
    }

    public NewEmployeeDTO createEmployee(NewEmployeeDTO dto) {

        return mapper.dtoToLite(createEmployee(mapper.liteToDto(dto)));

    }



    public ResponseEntity<String> deleteEmployeeByID(String id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return CustomResponseEntity.deleteSuccess();
        } else {
            // Not sure what proper syntax here would be if not a Response Entity
            return CustomResponseEntity.badRequestDNE();
        }
    }

    public boolean existsByID(String id) {
        return employeeRepository.existsById(id);
    }

    public EmployeeDTO findById(String id) {
        return mapper.entityToDto(employeeRepository.findById(id).orElse(null));
    }

}
