package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayTwoTest {

    private DayTwo dayTwo;

    @BeforeEach
    void setup() {
        dayTwo = new DayTwo();
    }

    @Test
    void validatePasswordWithNumberOfLetterOccurrences() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("6-10 p: ctpppjmdpppppp");

        boolean isValid = dayTwo.validatePasswordWithNumberOfLetterOccurrences(passwordPolicy);

        assertTrue(isValid);
    }

    @Test
    void invalidPasswordWithNumberOfLetterOccurrences() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("1-8 k: qkkkkkkxkkkkkkkkk");

        boolean isValid = dayTwo.validatePasswordWithNumberOfLetterOccurrences(passwordPolicy);

        assertFalse(isValid);
    }

    @Test
    void numberOfValidPasswordsWithNumberOfLetterOccurrences() {

        Utils utils = new Utils();
        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();

        List<String> stringContents = utils.getFileContentsByLine("src/main/resources/DayTwoInput.txt");
        int counter = 0;

        for (String input : stringContents) {
            PasswordPolicy passwordPolicy = passwordPolicyParser.parse(input);

            if (dayTwo.validatePasswordWithNumberOfLetterOccurrences(passwordPolicy)) {
                counter++;
            }
        }

        System.out.println("Number of valid passwords = " + counter);
    }

    @Test
    void validatePasswordWithOneCorrectLetterPosition() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("6-10 p: ctpppjmdpppppp");

        boolean isValid = dayTwo.validatePasswordWithOneCorrectLetterPosition(passwordPolicy);

        assertTrue(isValid);
    }

    @Test
    void invalidPasswordWithOneCorrectLetterPosition() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("1-8 k: qkkkkkkxkkkkkkkkk");

        boolean isValid = dayTwo.validatePasswordWithOneCorrectLetterPosition(passwordPolicy);

        assertFalse(isValid);
    }

    @Test
    void invalidPasswordWithLettersInBothPositions() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("2-9 c: ccccccccc");

        boolean isValid = dayTwo.validatePasswordWithOneCorrectLetterPosition(passwordPolicy);

        assertFalse(isValid);
    }

    @Test
    void numberOfValidPasswordsWithOneCorrectLetterPosition() {

        Utils utils = new Utils();
        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();

        List<String> stringContents = utils.getFileContentsByLine("src/main/resources/DayTwoInput.txt");
        int counter = 0;

        for (String input : stringContents) {
            PasswordPolicy passwordPolicy = passwordPolicyParser.parse(input);

            if (dayTwo.validatePasswordWithOneCorrectLetterPosition(passwordPolicy)) {
                counter++;
            }
        }

        System.out.println("Number of valid passwords = " + counter);
    }
}
