package persistence;

import model.BroadwayShowList;
import org.junit.jupiter.api.Assertions;

public class JsonTest {
    protected void checkBroadwayShows(String name, BroadwayShowList bsl) {
        Assertions.assertEquals(name, bsl.getName());
    }
}

