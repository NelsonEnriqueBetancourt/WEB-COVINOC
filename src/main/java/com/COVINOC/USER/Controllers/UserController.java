package com.COVINOC.USER.Controllers;

import com.COVINOC.USER.Models.User;
import com.COVINOC.USER.Services.Users.UserService;
import com.COVINOC.USER.Util.Exception2.ResourceNotAccepted;
import com.COVINOC.USER.Util.Exception1.ResourceNotFound;
import com.COVINOC.USER.Validation.UserImplement.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "API/REST/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidate userValidate;

    @RequestMapping(value = "user/getUsers",method = RequestMethod.GET)
    public ResponseEntity<List<User>>GetUsers(){
        List<User>userList=userService.GetUsers();
        if (userList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(userList);
        }
    }

     @RequestMapping(value = "user/getUserid/{id}",method = RequestMethod.GET)
    public ResponseEntity<?>GetUserId(@PathVariable Integer id)throws ResourceNotAccepted {
        Map<String,Object>response=new HashMap<>();
        try {
            this.userValidate.UserValidationId(id);
            this.userService.GetUserId(id);
            response.put("Mensaje","El Usuario Se Encuentra Registrado En El Sistema ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            return null;
        }
    }

    @RequestMapping(value = "user/updateUser/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?>UpdateUser(@RequestBody User user,@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            User updateUser=userService.GetUserId(id);
            userService.SaveUser(user);
            response.put("Mensaje","Los Datos Del Usuario Han Sido Actualizados ".concat("Con Exito"));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","Los Datos No Han Sido Actualizados,Intente Nuevamente " );
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "user/newUser",method = RequestMethod.POST)
    public ResponseEntity<?>SaveUser(@RequestBody User user)throws ResourceNotFound{
        Map<String,Object>response=new HashMap<>();
        this.userValidate.UserValidation(user);
        this.userService.SaveUser(user);
        response.put("Mensaje","El Usuario Ha Sido Guardado en el Sistema con Exito Usuario = ".concat(user.getName()));
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @RequestMapping(value = "user/deleteUser/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?>DeleteUser(@PathVariable Integer id){
        Map<String,Object>response=new HashMap<>();
        try {
            this.userService.DeleteUserId(id);
            response.put("Mensaje","El Usuario Ha Sido Eliminado Con Exito ".concat(id.toString()));
            return ResponseEntity.ok(response);
        }catch (DataAccessException exception){
            response.put("Mensaje","El Usuario No Ha Sido Eliminado Del Sistema ".concat(id.toString()));
            response.put("Error",exception.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);

        }
    }

    @RequestMapping(value = "user/page/{page}",method = RequestMethod.GET)
    public Page<User>PageUser(@PathVariable Integer page){
        Pageable pageable= PageRequest.of(page,5);
        return userService.USER_PAGE(pageable);
    }





}
