package kg.sennamed.sennamedFront.services;

import kg.sennamed.sennamedFront.services.impl.LoginServiceImpl;

import java.io.IOException;

public interface LoginService {
    LoginService INSTANCE=new LoginServiceImpl();
    boolean login(String login, String password) throws IOException;
}
