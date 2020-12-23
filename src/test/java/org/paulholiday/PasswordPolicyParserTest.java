package org.paulholiday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordPolicyParserTest {

    @Test
    void parsePolicy() {

        String input = "6-10 p: ctpppjmdpppppp";

        PasswordPolicyParser passwordPolicyParser = new PasswordPolicyParser();
        PasswordPolicy passwordPolicy = passwordPolicyParser.parse(input);

        assertEquals(6, passwordPolicy.getPolicyDigit1());
        assertEquals(10, passwordPolicy.getPolicyDigit2());
        assertEquals('p', passwordPolicy.getLetter());
        assertEquals("ctpppjmdpppppp", passwordPolicy.getPassword());
    }
}
