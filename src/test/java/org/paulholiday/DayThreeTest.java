package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayThreeTest {

    private char[][] map;
    private DayThree dayThree;

    @BeforeEach
    void setup() {
        Utils utils = new Utils();

        List<String> mapContents = utils.getFileContentsByLine("src/main/resources/DayThreeInput.txt");

        map = utils.getMap(mapContents);
        dayThree = new DayThree();
    }

    @Test
    void mapCreated() {

        for (char[] chars : map) {
            System.out.println(chars);
        }

        assertEquals(323, map.length);
        assertEquals(2261, map[0].length);
    }

    @Test
    void numberOfTreesThreeToOne() {

        int numberOfTrees = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 3);

        System.out.println(numberOfTrees);
        assertEquals(268, numberOfTrees);
    }

    @Test
    void numberOfTreesOneToOne() {

        int numberOfTrees = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 1);

        System.out.println(numberOfTrees);
    }

    @Test
    void numberOfTreesFiveToOne() {
        int numberOfTrees = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 5);

        System.out.println(numberOfTrees);
    }

    @Test
    void numberOfTreesSevenToOne() {
        int numberOfTrees = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 7);

        System.out.println(numberOfTrees);
    }

    @Test
    void numberOfTreesOneToTwo() {
        int numberOfTrees = dayThree.getNumberOfTreesWhileTraversingMap(map, 2, 1);

        System.out.println(numberOfTrees);
    }

    @Test
    void multipleNumberOfTrees() {

        int numberOfTreesThreeToOne = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 3);
        int numberOfTreesOneToOne = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 1);
        int numberOfTreesFiveToOne = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 5);
        int numberOfTreesSevenToOne = dayThree.getNumberOfTreesWhileTraversingMap(map, 1, 7);
        int numberOfTreesOneToTwo = dayThree.getNumberOfTreesWhileTraversingMap(map, 2, 1);

        long product = numberOfTreesThreeToOne * numberOfTreesOneToOne;
        product = product * numberOfTreesFiveToOne;
        product = product * numberOfTreesSevenToOne;
        product = product * numberOfTreesOneToTwo;

        System.out.println("Number of trees multiplied = " + product);
    }
}
