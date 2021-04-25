package kg.sennamed.sennamedFront.http;

import kg.sennamed.sennamedFront.http.impl.LoginHttpRequestImpl;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;

public interface LoginHttpRequest {

        LoginHttpRequest INSTANCE=new LoginHttpRequestImpl();
    User getUser (User user) throws IOException;
}
