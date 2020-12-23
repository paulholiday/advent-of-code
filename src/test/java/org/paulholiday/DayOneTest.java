package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOneTest {

    private Utils utils;
    private DayOne dayOne;
    private List<Integer> fileContents;

    @BeforeEach
    void setup() {
        utils = new Utils();
        fileContents = utils.getFileContentsByLine("src/main/resources/DayOneInput.txt");
        dayOne = new DayOne();
    }

    @Test
    void multiplyTwoEntriesThatSumTo2020() {

        List<Integer> resultList = dayOne.getTwoEntriesThatSumTo2020(fileContents);

        assertEquals(2020, resultList.get(0) + resultList.get(1));

        System.out.println(dayOne.multiplyTwoAnswers(resultList.get(0), resultList.get(1)));
    }

    @Test
    void multipleThreeEntriesThatSumTo2020() {

        List<Integer> resultList = dayOne.getThreeEntriesThatSumTo2020(fileContents);

        assertEquals(2020, resultList.get(0) + resultList.get(1) + resultList.get(2));

        System.out.println(dayOne.multiplyThreeAnswers(resultList.get(0), resultList.get(1), resultList.get(2)));
    }
}
