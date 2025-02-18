package unit.data;

import base.BaseTest;
import com.wildbit.java.postmark.client.data.DataHandler;
import com.wildbit.java.postmark.client.data.model.bounces.Bounce;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Bounce data tests.
 */
public class BounceTest extends BaseTest {

    DataHandler dataHandler = new DataHandler();

    @Test
    void bouncesData() throws IOException{
        String expected_data = "{\n" +
                "  \"TotalCount\" : 0,\n" +
                "  \"Bounces\" : [ {\n" +
                "    \"Id\" : 1,\n" +
                "    \"Content\" : \"test\"\n" +
                "  } ]\n" +
                "}";

        Bounce bounce = new Bounce();
        bounce.setId(1L);
        bounce.setContent("test");
        List<Bounce> data = new ArrayList<>();
        data.add(bounce);

        Bounces bounces = new Bounces();
        bounces.setBounces(data);
        assertEquals(dataHandler.toJson(bounces), expected_data);
    }
}
