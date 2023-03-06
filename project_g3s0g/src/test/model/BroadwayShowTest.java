package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BroadwayShowTest {
    private BroadwayShow testBroadwayShow =
            new BroadwayShow
                    (1, "Hamilton",
                            "The story of America then, told by America now", 4);

    @Test
    public void testConstructor() {
        assertEquals(1, this.testBroadwayShow.getId());
        assertEquals("Hamilton", this.testBroadwayShow.getTitle());
        assertEquals("The story of America then, told by America now", this.testBroadwayShow.getDescription());
        assertEquals(4, this.testBroadwayShow.getRating());
    }

    @Test
    public void testSetRating() {
        this.testBroadwayShow.setRating(5);
        assertEquals(this.testBroadwayShow.getRating(), 5);
    }

    @Test
    public void testToString() {
        assertEquals(testBroadwayShow.toString(),
                (testBroadwayShow.getTitle() + " : " + testBroadwayShow.getDescription()));
    }
}


   /* private BroadwayShow testBroadwayShow;

    @BeforeEach
    void runBefore() {
        testBroadwayShow = new BroadwayShow("Hamilton",
                "The story of America then, told by America now",
                4);
    }

    @Test
    void testConstructor() {
        assertEquals("Hamilton", testBroadwayShow.getTitle());
        assertEquals("The story of America then, told by America now",
                testBroadwayShow.getDescription());
        assertEquals(4, testBroadwayShow.getRating());
    }

    @Test
    public void testSetRating() {
        assertEquals(testBroadwayShow.getRating(), 4);
    }

    static class BroadwayShowTest {
        private BroadwayShow testBroadwayShow;

        @BeforeEach
        void runBefore() {
            testBroadwayShow = new BroadwayShow("Hamilton",
                    "The story of America then, told by America now",
                    4);
        }

        @Test
        void testConstructor() {
            assertEquals("Hamilton", testBroadwayShow.getTitle());
            assertEquals("The story of America then, told by America now",
                    testBroadwayShow.getDescription());
            assertEquals(4, testBroadwayShow.getRating());
        }

        @Test
        public void testSetRating() {
            assertEquals(testBroadwayShow.getRating(), 4);
        }

    }*/
