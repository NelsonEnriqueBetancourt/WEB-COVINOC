package com.COVINOC.USER.Validation.UserImplement;

import com.COVINOC.USER.Models.User;
import com.COVINOC.USER.Util.Exception2.ResourceNotAccepted;
import com.COVINOC.USER.Util.Exception1.ResourceNotFound;
import com.COVINOC.USER.Validation.User.UserValidation;
import org.springframework.stereotype.Component;

@Component
public class UserValidate implements UserValidation {

    private void MessageUser(String message)throws ResourceNotFound{
        throw new ResourceNotFound(message);
    }

    private void MessageUserId(String message)throws ResourceNotAccepted{
        throw new ResourceNotAccepted(message);
    }


    @Override
    public void UserValidation(User user) throws ResourceNotFound {
        if (user.getName()==null){
            this.MessageUser("El Nombre Del Usuario debe ser Obligatorio, Intente nuevamente");
        }
        if (user.getLastName()==null){
            this.MessageUser("El Apellido Del Usuario debe ser Obligatorio, Intente nuevamente");
        }

        if (user.getEmail()==null){
            this.MessageUser("El E-mail Del Usuario debe ser Obligatorio, Intente nuevamente");
        }
        if (user.getIdentification()==0){
            this.MessageUser("El Numero De Identificacion Del Usuario debe ser Obligatorio, Intente nuevamente");
        }
        if (user.getIdentification()<10){
            this.MessageUser("El Numero De Identificacion Del Usuario No Es Valido Max 10 Numerous, Intente nuevamente");
        }
        if (user.getTelephone()==0){
            this.MessageUser("El Numero del Telefono  Del Usuario debe ser Obligatorio, Intente nuevamente");

        }
        if (user.getTelephone()<10){
            this.MessageUser("El Numero De Telefono Del Usuario No Es Valido Max 10 Numerous, Intente nuevamente");
        }
    }

    @Override
    public void UserValidationId(Integer id) throws ResourceNotAccepted {
        if (id==null){
            this.MessageUserId("El Usuario No se encuentra Registrado en el Sistema");
        }
    }
}
