package kg.sennamed.sennamedFront.http;

import kg.sennamed.sennamedFront.http.impl.LoginHttpRequestImpl;
import kg.sennamed.sennamedFront.models.Account;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;

public interface LoginHttpRequest {

        LoginHttpRequest INSTANCE=new LoginHttpRequestImpl();
    User getUser (String login, String password) throws IOException;
    User getUserObject (Account account) throws IOException;
}
