package org.paulholiday;

public class DayThree {

    int getNumberOfTreesWhileTraversingMap(char[][] map, int downTraversalNumber, int rightTraversalNumber) {
        int numberOfTrees = 0;
        int j = 0;
        for (int i = 0; i < map.length; i+=downTraversalNumber) {
            if ('#' == map[i][j]) {
                numberOfTrees++;
            }
            j +=rightTraversalNumber;
        }
        return numberOfTrees;
    }
}
