package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayFourTest {

    private DayFour dayFour;
    private List<String> passportDetails;

    @BeforeEach
    void setup() {
        Utils utils = new Utils();

        passportDetails = utils.getFileContentsBetweenWhiteSpaces("src/main/resources/DayFourInput.txt");

        dayFour = new DayFour();
    }

    @Test
    void ensureInputIsGrouped() {

        for (String passport : passportDetails) {
            System.out.println(passport);
        }

    }

    @Test
    void validPassport() {

        assertTrue(dayFour.validPassportPartOne("ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"));
        assertTrue(dayFour.validPassportPartOne("hcl:#ae17e1 iyr:2013 eyr:2024 ecl:brn pid:760753108 byr:1931 hgt:179cm"));
    }

    @Test
    void invalidPassport() {

        assertFalse(dayFour.validPassportPartOne("iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884 hcl:#cfa07d byr:1929"));
        assertFalse(dayFour.validPassportPartOne("hcl:#cfa07d eyr:2025 pid:166559648 iyr:2011 ecl:brn hgt:59in"));
    }

    @Test
    void numberOfValidPassports() {

        long numberOfValidPassports = dayFour.countNumberOfValidPassports(passportDetails);

        System.out.println(numberOfValidPassports);
    }

    @Test
    void validBirthYear() {

        assertTrue(dayFour.validBirthYear(1920));
        assertTrue(dayFour.validBirthYear(2002));
        assertFalse(dayFour.validBirthYear(2003));
        assertFalse(dayFour.validBirthYear(1919));
    }

    @Test
    void validIssueYear() {

        assertTrue(dayFour.validIssueYear(2010));
        assertTrue(dayFour.validIssueYear(2020));
        assertFalse(dayFour.validIssueYear(2009));
        assertFalse(dayFour.validIssueYear(2021));
    }

    @Test
    void validExpirationYear() {

        assertTrue(dayFour.validExpirationYear(2020));
        assertTrue(dayFour.validExpirationYear(2030));
        assertFalse(dayFour.validExpirationYear(2019));
        assertFalse(dayFour.validExpirationYear(2031));
    }

    @Test
    void validHeight() {

        assertTrue(dayFour.validHeight("hgt:150cm"));
        assertTrue(dayFour.validHeight("hgt:193cm"));
        assertTrue(dayFour.validHeight("hgt:59in"));
        assertTrue(dayFour.validHeight("hgt:76in"));
        assertFalse(dayFour.validHeight("hgt:149cm"));
        assertFalse(dayFour.validHeight("hgt:194cm"));
        assertFalse(dayFour.validHeight("hgt:58in"));
        assertFalse(dayFour.validHeight("hgt:77in"));
        assertFalse(dayFour.validHeight("hgt:77"));
    }

    @Test
    void validHairColour() {

        assertTrue(dayFour.validHairColour("hcl:#123abf"));
        assertFalse(dayFour.validHairColour("hcl:#123abz"));
        assertFalse(dayFour.validHairColour("hcl:123abc"));
        assertTrue(dayFour.validHairColour("hcl:#efcc98"));
    }

    @Test
    void validEyeColour() {

        assertTrue(dayFour.validEyeColour("ecl:brn"));
        assertFalse(dayFour.validEyeColour("ecl:wat"));
    }

    @Test
    void validPassportId() {

        assertTrue(dayFour.validPassportID("pid:000000001"));
        assertFalse(dayFour.validPassportID("pid:0123456789"));
        assertFalse(dayFour.validPassportID("pid:181cm"));
    }

    @Test
    void numberOfValidPassportsPartTwo() {

        long numberOfValidPassports = dayFour.countNumberOfValidPassportsPartTwo(passportDetails);

        System.out.println(numberOfValidPassports);
    }

}
