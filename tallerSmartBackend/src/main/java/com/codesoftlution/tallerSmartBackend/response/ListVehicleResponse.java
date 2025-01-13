package com.codesoftlution.tallerSmartBackend.response;

import com.codesoftlution.tallerSmartBackend.models.VehicleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListVehicleResponse {
    private List<VehicleModel> listVehicleModel;
    private String description;
}
