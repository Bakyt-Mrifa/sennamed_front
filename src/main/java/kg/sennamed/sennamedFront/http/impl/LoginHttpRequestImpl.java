package kg.sennamed.sennamedFront.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import kg.sennamed.sennamedFront.http.LoginHttpRequest;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;

public class LoginHttpRequestImpl implements LoginHttpRequest {

    private ObjectMapper om=new ObjectMapper();
    private OkHttpClient okHttpClient=new OkHttpClient();

    @Override
    public User getUser(User user) throws IOException {
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(user));

        Request request=new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8080/lots/get")
                .post(requestBody)
                .build();

        Response response=okHttpClient.newCall(request).execute();
        int code=response.code();
        System.out.println("Код запроса: "+code+" - Успешно!!!");

        if (response.isSuccessful()) {
            user=om.readValue(response.body().string(), User.class);
            System.out.println("После метода saveLot: "+user);
        }else {
            System.out.println("Произошла системная ошибка!");
        }
        return lot;
    }
}
/*
        Request request=new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url(httpGetServer+"?id="+id)
                .build();
        System.out.println("URL: "+httpGetServer+"?id="+id);
        Response response=okHttpClient.newCall(request).execute();
        int code=response.code();
        System.out.println("Код запроса: "+code+" - Успешно");
        if (response.isSuccessful()){
            lot=om.readValue(response.body().string(), Lot.class);
        }else {
            System.out.println("Произошла системная ошибка!");
        }
        return lot;
*/
