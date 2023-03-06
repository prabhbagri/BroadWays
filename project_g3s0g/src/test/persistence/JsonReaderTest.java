package persistence;

import model.BroadwayShow;
import model.BroadwayShowList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");

        try {
            BroadwayShowList bsl = reader.read();
            Assertions.fail("IOException expected");
        } catch (IOException e) {
        }

    }

    @Test
    void testReaderBroadwayShowsEmpty() {
        JsonReader reader = new JsonReader("./data/testReaderBroadwayShowsEmpty.json");

        try {
            BroadwayShowList bsl = reader.read();
            Assertions.assertEquals("My Broadway Show List", bsl.getName());
            Assertions.assertEquals(0, bsl.getSize());
        } catch (IOException e) {
            Assertions.fail("Couldn't read from file");
        }

    }

    @Test
    void testReaderBroadwayShows() {
        JsonReader reader = new JsonReader("./data/testReaderBroadwayShows.json");

        try {
            BroadwayShowList bsl = reader.read();
            Assertions.assertEquals("My Broadway Show List", bsl.getName());
            List<BroadwayShow> shows = bsl.getShows();
            Assertions.assertEquals(0, shows.size());

        } catch (IOException e) {
            Assertions.fail("Couldn't read from file");
        }

    }
}

