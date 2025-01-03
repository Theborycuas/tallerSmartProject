package com.codesoftlution.tallerSmartBackend.repositories;

import com.codesoftlution.tallerSmartBackend.models.UserRolModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRoleRepository extends JpaRepository<UserRolModel, Long> {
    UserRolModel findUserRolModelByRolName(String name);
}
