package com.codesoftlution.tallerSmartBackend.repositories;

import com.codesoftlution.tallerSmartBackend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
}
