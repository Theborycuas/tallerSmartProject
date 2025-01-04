package com.codesoftlution.tallerSmartBackend.controllers;

import com.codesoftlution.tallerSmartBackend.TallerSmartBackendApplication;
import com.codesoftlution.tallerSmartBackend.models.UserModel;
import com.codesoftlution.tallerSmartBackend.response.ListUserResponse;
import com.codesoftlution.tallerSmartBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserController {
    Logger log = Logger.getLogger(TallerSmartBackendApplication.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getUsers()
    {
        try {
            List<UserModel> userModels = this.userService.getUsers();

            ListUserResponse listUserResponse = new ListUserResponse();
            listUserResponse.setUserModelList(userModels);
            listUserResponse.setMessage("Lista de USUARIOS");

            return new ResponseEntity(listUserResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserModel userRegister(@RequestBody UserModel userModel){

        log.info("GUARDAR USUARIO");
        return this.userService.saveUsers(userModel);
        /*try {
            return this.userService.saveUsers(userModel);
        } catch (Exception e){
            //return new Response(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
    }


    @RequestMapping(value = "/getOk/{ok}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getOk(@PathVariable("ok") String ok){

        log.info("TODO OK");
        return  new ResponseEntity("OK", HttpStatus.OK);
    }
}
