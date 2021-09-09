package kg.sennamed.sennamedFront.http.impl;

import com.google.gson.Gson;
import kg.sennamed.sennamedFront.http.HttpRequests;
import kg.sennamed.sennamedFront.http.PositionHttpRequest;
import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.models.Result;

import java.io.IOException;
import java.util.List;

public class PositionHttpRequestImpl implements PositionHttpRequest {

    private HttpRequests httpRequests = new HttpRequests();
    private Gson gson = new Gson();
    private Result result;
    String link;


    @Override
    public void savePosition(Position position) throws IOException {
        link = "position/save";
        result = httpRequests.postRequests(position, link);
    }

    @Override
    public void removePosition(Position position) throws IOException {
        link = "position/remove";
        result = httpRequests.postRequests(position, link);
    }


    @Override
    public Position editPosition(Position position) throws IOException {
        link = "position/update";
        result = httpRequests.postRequests(position, link);
        position = gson.fromJson(result.getObject().toString(), position.getClass());
        return position;
    }

    @Override
    public List<Position> getPositionList() throws IOException {
        List<Position> positionList = (List<Position>) httpRequests.getRequests("position/getList");

        return positionList;
    }



}

