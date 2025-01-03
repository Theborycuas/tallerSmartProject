package com.codesoftlution.tallerSmartBackend;

import com.codesoftlution.tallerSmartBackend.models.UserRolModel;
import com.codesoftlution.tallerSmartBackend.repositories.IUserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DataInit {
    private IUserRoleRepository iUserRoleRepository;

    @Autowired
    public DataInit(IUserRoleRepository iUserRoleRepository){
        this.iUserRoleRepository = iUserRoleRepository;
    }

    @PostConstruct
    public void createDataTallerSmart(){
        Optional<UserRolModel> existRol = iUserRoleRepository.findById(1L);
        if(!existRol.isPresent()){

            UserRolModel rol1 = new UserRolModel();
            rol1.setId(1L);
            rol1.setRolName("CLIENTE");
            rol1.setDescription("Usuario que lleva su vehiculo al taller");
            iUserRoleRepository.save(rol1);

            UserRolModel rol2 = new UserRolModel();
            rol2.setId(2L);
            rol2.setRolName("DUEÑO_TALLER");
            rol2.setDescription("Usuario Dueño de Tallere");
            iUserRoleRepository.save(rol2);

            UserRolModel rol3 = new UserRolModel();
            rol3.setId(3L);
            rol3.setRolName("ADMINISTRADOR");
            rol3.setDescription("Usuario Administrador del Sistema");
            iUserRoleRepository.save(rol3);



        }
    }
}
