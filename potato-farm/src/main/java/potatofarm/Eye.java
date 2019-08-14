package potatofarm;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(toBuilder = true)
@Data
public class Eye {

    private int length;
    private List<String> dreams;
}
