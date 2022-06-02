package com.COVINOC.USER.Validation.User;

import com.COVINOC.USER.Models.User;
import com.COVINOC.USER.Util.Exception2.ResourceNotAccepted;
import com.COVINOC.USER.Util.Exception1.ResourceNotFound;
import org.springframework.stereotype.Service;

@Service
public interface UserValidation {

    public void UserValidation(User user)throws ResourceNotFound;
    public void UserValidationId(Integer id)throws ResourceNotAccepted;
}
