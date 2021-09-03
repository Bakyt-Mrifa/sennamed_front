package kg.sennamed.sennamedFront.http.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import javafx.scene.control.Alert;
import kg.sennamed.sennamedFront.http.HttpRequests;
import kg.sennamed.sennamedFront.http.PositionHttpRequest;
import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.models.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PositionHttpRequestImpl implements PositionHttpRequest {

    private ObjectMapper om = new ObjectMapper();
    private OkHttpClient okHttpClient = new OkHttpClient();
    private HttpRequests httpRequests;
    private Gson gson=new Gson();
    private Result result;
    String link;


    @Override
    public Result savePosition(Position position) throws IOException {
        link="position/save";
        result=httpRequests.postRequests(position, link);
        return result;
    }

    @Override
    public Position editPosition(Position position) throws IOException {
        link="position/update";
        result=httpRequests.postRequests(position, link);
        position = gson.fromJson(result.getObject().toString(), position.getClass());
/*
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), om.writeValueAsString(position));

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("http://localhost:8088/api/v1/position/update")
                .post(requestBody)
                .build();


        Response response = okHttpClient.newCall(request).execute();
        int code = response.code();
        System.out.println("Код запроса: " + code + " - Успешно!!!" + response);

        if (response.isSuccessful()) {
            //Open new scene --------------
            Result result = om.readValue(response.body().string(), Result.class);
            System.out.println(result);
            if (result.getObject() == null) {
                Alert message = new Alert(Alert.AlertType.ERROR);
                message.setHeaderText("Ошибка авторизации");
                message.setContentText(result.getMessage());
                message.showAndWait();
            }
        } else {
            System.out.println("Произошла системная ошибка!");
        }*/
        return position;
    }

    @Override
    public List<Position> getPositionList() {
        List<Position> positionList=new ArrayList<>();

        return null;
    }


}

