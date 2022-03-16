package ca.me.proj.controller.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.service.profile.ProfileService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService service;

    @GetMapping("/findAll")
    public List<ProfileDTO> findAll() {
        return service.findAll();
    }
    
}