package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BroadwayShowListTest {
    BroadwayShowList list;
    BroadwayShow show1;
    BroadwayShow show2;
    BroadwayShow show3;

    public BroadwayShowListTest() {
    }

    @BeforeEach
    public void runBefore() {
        this.list = new BroadwayShowList("On Broadway");
        this.show1 = new BroadwayShow(1, "Hamilton",
                "The story of America then, told by America now.", 1);
        this.show2 = new BroadwayShow(2,
                "Wicked",
                "Highlighting the importance of healthy and mutual female support systems.",
                2);
        this.show3 = new BroadwayShow(3, "Chicago",
                "Satire on corruption in the administration of criminal justice.",
                3);
    }

    @Test
    public void testGetName() {
        assertEquals(this.list.getName(), "On Broadway");
    }

    @Test
    public void testGetIndex() {
        this.list.addShow(this.show1);
        this.list.addShow(this.show2);
        this.list.addShow(this.show3);

        assertEquals(this.list.getIndex(1), this.show2);
        assertEquals(this.list.getIndex(0), this.show1);
    }

    @Test
    public void testGetSize() {
        this.list.addShow(this.show1);
        this.list.addShow(this.show2);
        this.list.addShow(this.show3);

        assertEquals(this.list.getSize(), 3);
    }

    @Test
    public void testGetShows() {
    }
}
