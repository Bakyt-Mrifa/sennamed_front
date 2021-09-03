package kg.sennamed.sennamedFront.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import javafx.scene.control.Alert;
import kg.sennamed.sennamedFront.http.LoginHttpRequest;
import kg.sennamed.sennamedFront.models.Account;
import kg.sennamed.sennamedFront.models.Result;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;

public class LoginHttpRequestImpl implements LoginHttpRequest {
    Gson gson = new Gson();
    private ObjectMapper om = new ObjectMapper();
    private OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    public User getUser(String login, String password) throws IOException {
/*
        User user=new User();

        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"), login);

        Request request=new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8080/lots/get")
                .post(requestBody)
                .build();

        Response response=okHttpClient.newCall(request).execute();
        int code=response.code();
        System.out.println("Код запроса: "+code+" - Успешно!!!");

        if (response.isSuccessful()) {
            //Open new scene --------------
            user=om.readValue(response.body().string(), User.class);
            System.out.println("User: "+user);
        }else {
            System.out.println("Произошла системная ошибка!");
        }*/
        return null;
    }

    @Override
    public User getUserObject(Account account) throws IOException {
        User user = new User();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(account));

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8088/api/v1/login/getAccount")
                .post(requestBody)
                .build();


        Response response = okHttpClient.newCall(request).execute();
        int code = response.code();
        System.out.println("Код запроса: " + code + " - Успешно!!!" + response);


        if (response.isSuccessful()) {
            //Open new scene --------------
            Result result = om.readValue(response.body().string(), Result.class);

            if (result.getObject() == null) {
                Alert message = new Alert(Alert.AlertType.ERROR);
                message.setHeaderText("Ошибка авторизации");
                message.setContentText(result.getMessage());
                message.showAndWait();
            } else if (result.getType().equals(user.getClass().getSimpleName())) {
                user = gson.fromJson(result.getObject().toString(), user.getClass());
                System.out.println("user = "+user);
            }

        } else {
            System.out.println("Произошла системная ошибка!");
        }
        return user;

    }
}

