package org.paulholiday;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOneTest {

    @Test
    void multiplyTwoEntriesThatSumTo2020() {

        Utils utils = new Utils();
        List<Integer> fileContents = utils.getFileContentsByLine("src/main/resources/DayOneInput.txt");

        DayOne dayOne = new DayOne();

        List<Integer> resultList = dayOne.getTwoEntriesThatSumTo2020(fileContents);

        assertEquals(2020, resultList.get(0) + resultList.get(1));

        System.out.println(dayOne.multiplyAnswers(resultList.get(0), resultList.get(1)));
    }
}
