package com.codesoftlution.tallerSmartBackend.controllers;

import com.codesoftlution.tallerSmartBackend.models.VehicleModel;
import com.codesoftlution.tallerSmartBackend.response.ListVehicleResponse;
import com.codesoftlution.tallerSmartBackend.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/getVehicleById/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getVehicleById(@PathVariable("userId") Long userId) {
        try {
            List<VehicleModel> listVehicleModel = this.vehicleService.getVehicleByUser(userId);

            ListVehicleResponse listVehicleResponse = new ListVehicleResponse();
            listVehicleResponse.setListVehicleModel(listVehicleModel);
            listVehicleResponse.setDescription("Lista de Vehiculos del cliente" + userId);
            return new ResponseEntity(listVehicleResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/vehicleRegister", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public VehicleModel vehicleRegister(@RequestBody VehicleModel vehicleModel){
        return this.vehicleService.saveVehicle(vehicleModel);
    }


}
