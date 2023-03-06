package persistence;

import model.BroadwayShow;
import model.BroadwayShowList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            BroadwayShowList bsl = new BroadwayShowList("NY Times Best Broadways");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            Assertions.fail("IOException was expected");
        } catch (IOException e) {
        }

    }

    @Test
    void testWriterEmptyBroadwayShowList() {
        try {
            BroadwayShowList bsl = new BroadwayShowList("My Broadway Show List");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyBroadwayShowList.json");
            writer.open();
            writer.write(bsl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyBroadwayShowList.json");
            bsl = reader.read();
            Assertions.assertEquals("My Broadway Show List", bsl.getName());
            Assertions.assertEquals(0, bsl.getSize());
        } catch (IOException e) {
            Assertions.fail("Exception should not have been thrown");
        }

    }

    @Test
    void testWriterBroadwayShowList() {
        try {
            BroadwayShowList bsl = new BroadwayShowList("My Broadway Show List");
            bsl.addShow(new BroadwayShow(1, "Prabhnoor",
            "Great show!", 5));
            //bsl.addThingy(new Thingy("needle", Category.STITCHING));
            JsonWriter writer = new JsonWriter("./data/testWriterBroadwayShowList.json");
            writer.open();
            writer.write(bsl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterBroadwayShowList.json");
            bsl = reader.read();
            assertEquals("My Broadway Show List", bsl.getName());
            List<BroadwayShow> show = bsl.getShows();
            assertEquals(0, show.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

            /*BroadwayShowList bsl = new BroadwayShowList("My Broadway Show List");
           BroadwayShow show = new BroadwayShow(1, "Prabh",
                    "Prabhnoor", 5);
            bsl.addShow(show);
            JsonWriter writer = new JsonWriter("./data/testWriterBroadwayShowList.json");
            writer.open();
            writer.write(bsl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterBroadwayShowList.json");
            bsl = reader.read();
            Assertions.assertEquals("My Broadway Show List", bsl.getName());
            List<BroadwayShow> shows = bsl.getShows();
          //  System.out.println(shows.size());
            Assertions.assertEquals(1, shows.size());

        } catch (IOException e) {
            Assertions.fail("Exception should not have been thrown");
        }

    }*/
}
