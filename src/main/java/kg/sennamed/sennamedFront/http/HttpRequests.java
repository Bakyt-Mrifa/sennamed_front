package kg.sennamed.sennamedFront.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import javafx.scene.control.Alert;
import kg.sennamed.sennamedFront.models.Result;

import java.io.IOException;

public class HttpRequests {
    private ObjectMapper om = new ObjectMapper();
    private OkHttpClient okHttpClient = new OkHttpClient();
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
                Alert message = new Alert(Alert.AlertType.INFORMATION);
                message.setHeaderText("Ответ системы");
                message.setContentText(result.getMessage());
                message.showAndWait();
            }
            return result;
        } else {
            System.out.println("Произошла системная ошибка!");
        }
        return result;
    }

    public Object getRequests(String link) throws IOException {
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8088/api/v1/" + link)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        int code = response.code();
        System.out.println("Get response code: " + code + ", response: " + response);
        Object object = om.readValue(response.body().string(), Object.class);
        return object;
    }

}

