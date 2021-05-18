package kg.sennamed.sennamedFront.services.impl;

import kg.sennamed.sennamedFront.http.LoginHttpRequest;
import kg.sennamed.sennamedFront.models.User;
import kg.sennamed.sennamedFront.services.LoginService;

import java.io.IOException;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean login(String login, String password) throws IOException {
/*        if (login.length()<3 || password.length()<3){
            return false;
        }
        User user=LoginHttpRequest.INSTANCE.getUserByLogin(login);
        if(user.isActive()==false){
            return false;
        }
        if (user.getId()!=null && user.getUserPassword().equals(password)) {
            return true;
        }*/

        return false;
    }
}
