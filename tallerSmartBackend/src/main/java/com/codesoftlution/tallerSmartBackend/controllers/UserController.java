package com.codesoftlution.tallerSmartBackend.controllers;

import com.codesoftlution.tallerSmartBackend.TallerSmartBackendApplication;
import com.codesoftlution.tallerSmartBackend.models.UserModel;
import com.codesoftlution.tallerSmartBackend.models.UserRolModel;
import com.codesoftlution.tallerSmartBackend.services.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("tallerSmart")
@CrossOrigin(origins = "*")
public class UserController {
    Logger log = Logger.getLogger(TallerSmartBackendApplication.class.getName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserModel> getUsers()
    {
        return this.userService.getUsers();
        /*try {
            return this.userService.getUsers();
        } catch (Exception e){
            //return new ResponseEntity<T>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }*/
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
