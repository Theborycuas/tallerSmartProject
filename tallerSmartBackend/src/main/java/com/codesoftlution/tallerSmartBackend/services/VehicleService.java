package com.codesoftlution.tallerSmartBackend.services;

import com.codesoftlution.tallerSmartBackend.models.VehicleModel;
import com.codesoftlution.tallerSmartBackend.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    IVehicleRepository iVehicleRepository;

    public List<VehicleModel> getVehicleByUser(Long userId){
        return iVehicleRepository.findByUserModel_Id(userId);
    }

    public VehicleModel saveVehicle(VehicleModel vehicleModel){
        return iVehicleRepository.save(vehicleModel);
    }

    /*public void deleteVehicle(Long id){
        return iVehicleRepository.deleteBy_Id(id);
    }*/

}
