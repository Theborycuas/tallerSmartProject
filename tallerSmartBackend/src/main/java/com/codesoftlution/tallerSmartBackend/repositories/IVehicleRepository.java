package com.codesoftlution.tallerSmartBackend.repositories;

import com.codesoftlution.tallerSmartBackend.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<VehicleModel, Long> {
    List<VehicleModel> findByUserModel_Id(Long userId);
}
