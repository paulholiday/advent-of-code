package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DaySixTest {

    private DaySix daySix;
    private List<String> answersList;

    @BeforeEach
    void setup() {

        daySix = new DaySix();
        Utils utils = new Utils();

        answersList = utils.getFileContentsBetweenWhiteSpaces("src/main/resources/DaySixInput.txt");
    }

    @Test
    void getNumberOfUniqueQuestionsAnsweredYesByOneGroup() {

        assertEquals(3, daySix.getNumberOfUniqueQuestionsAnswerYes("abc"));
        assertEquals(3, daySix.getNumberOfUniqueQuestionsAnswerYes("abcccbb"));
        assertEquals(1, daySix.getNumberOfUniqueQuestionsAnswerYes("aaaaaa"));
        assertEquals(6, daySix.getNumberOfUniqueQuestionsAnswerYes("nefaym eynamf eafnmy afnmey "));
        assertEquals(21, daySix.getNumberOfUniqueQuestionsAnswerYes("zmd alo ekvrtpyuqi hwmc szgah"));

    }

    @Test
    void getNumberOfUniqueQuestionsAnsweredYesFromInput() {

        List<String> answers = Arrays.asList("abc", "abcccbb", "aaaaaa", "nefaym eynamf eafnmy afnmey ", "zmd alo ekvrtpyuqi hwmc szgah");

        assertEquals(34, daySix.getNumberOfUniqueQuestionsAnsweredYesFromInput(answers));

        System.out.println(daySix.getNumberOfUniqueQuestionsAnsweredYesFromInput(answersList));
    }
}
