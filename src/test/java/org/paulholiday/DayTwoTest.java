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
    void validatePassword() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("6-10 p: ctpppjmdpppppp");

        boolean isValid = dayTwo.validatePassword(passwordPolicy);

        assertTrue(isValid);
    }

    @Test
    void invalidPassword() {

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse("1-8 k: qkkkkkkxkkkkkkkkk");

        boolean isValid = dayTwo.validatePassword(passwordPolicy);

        assertFalse(isValid);
    }

    @Test
    void numberOfValidPasswords() {

        Utils utils = new Utils();
        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();

        List<String> stringContents = utils.getFileContentsByLine("src/main/resources/DayTwoInput.txt");
        int counter = 0;

        for (String input : stringContents) {
            PasswordPolicy passwordPolicy = passwordPolicyParser.parse(input);

            if (dayTwo.validatePassword(passwordPolicy)) {
                counter++;
            }
        }

        System.out.println("Number of valid passwords = " + counter);
    }
}
