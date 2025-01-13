package com.codesoftlution.tallerSmartBackend.response;

import com.codesoftlution.tallerSmartBackend.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListUserResponse {
    private List<UserModel> userModelList;
    private String message;
}
