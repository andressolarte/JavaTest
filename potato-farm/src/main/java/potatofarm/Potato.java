package potatofarm;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class Potato {

    private Color color;
    private int size;
    private Eye eye;
    private String name;
}
