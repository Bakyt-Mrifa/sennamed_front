package kg.sennamed.sennamedFront.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import javafx.scene.control.Alert;
import kg.sennamed.sennamedFront.models.Customer;
import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.models.Result;
import kg.sennamed.sennamedFront.models.User;

import java.io.IOException;

public class HttpRequests {
    private ObjectMapper om = new ObjectMapper();
    private OkHttpClient okHttpClient = new OkHttpClient();
    private Gson gson = new Gson();
    private User user = new User();
    private Position position = new Position();
    private Customer customer = new Customer();
    private Result result;

    public Result postRequests(Object object, String link) throws IOException {


        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(object));

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8088/api/v1/" + link)
                .post(requestBody)
                .build();


        Response response = okHttpClient.newCall(request).execute();
        int code = response.code();
        System.out.println("Код запроса: " + code + " - Успешно!!!" + response);

        if (response.isSuccessful()) {
            //Open new scene --------------
            result = om.readValue(response.body().string(), Result.class);

            if (result.getObject() == null) {
                Alert message = new Alert(Alert.AlertType.ERROR);
                message.setHeaderText("Ошибка запроса");
                message.setContentText(result.getMessage());
                message.showAndWait();
            } return result;
        }else {
            System.out.println("Произошла системная ошибка!");
        }
        return result;
    }


    public Result getRequests(String link) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8088/api/v1/" + link)
                .build();
        Response response=okHttpClient.newCall(request).execute();
        int code=response.code();
        System.out.println("Get response code: "+code+", response: "+response);
        result=om.readValue(response.body().string(), Result.class);
        return result;
    }
}




/*===========================================================================
if (result.getType().equals(user.getClass().getSimpleName())) {
//                user = gson.fromJson(result.getObject().toString(), user.getClass());
                object = result.getObject();
                System.out.println("user = " + object);
            } else if (result.getType().equals(position.getClass().getSimpleName())) {
//                user = gson.fromJson(result.getObject().toString(), user.getClass());
                object = result.getObject();
                System.out.println("position = " + object);

            } else if (result.getType().equals(customer.getClass().getSimpleName())) {
//                user = gson.fromJson(result.getObject().toString(), user.getClass());
                object = result.getObject();
                System.out.println("customer = " + object);
            } else {
                System.out.println("Произошла системная ошибка!");
            }
            result.setObject(object);*/