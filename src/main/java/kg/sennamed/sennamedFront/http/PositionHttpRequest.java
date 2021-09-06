package kg.sennamed.sennamedFront.http;

import kg.sennamed.sennamedFront.http.impl.PositionHttpRequestImpl;
import kg.sennamed.sennamedFront.models.Position;
import kg.sennamed.sennamedFront.models.Result;

import java.io.IOException;
import java.util.List;

public interface PositionHttpRequest {

    PositionHttpRequest INSTACNE = new PositionHttpRequestImpl();
    void savePosition (Position position) throws IOException;
    Position editPosition (Position position) throws IOException;
    List<Position> getPositionList() throws IOException;


}
