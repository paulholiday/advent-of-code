package org.paulholiday;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class DayFour {

    private static final String HAIR_COLOUR_REGEX = "hcl:#[0-9a-f]{6}";
    private static final String EYE_COLOUR_REGEX = "ecl:(amb|blu|brn|gry|grn|hzl|oth)";

    boolean validPassportPartOne(String passport) {
        String[] splitOnColons = passport.split(":");

        if (splitOnColons.length == 9) {
            return true;
        }
        return splitOnColons.length == 8 && !passport.contains("cid");
    }

    long countNumberOfValidPassports(List<String> passportDetails) {
        return passportDetails.stream().filter(this::validPassportPartOne).count();
    }

    boolean validPassportPartTwo(String passport) {
        if (!validPassportPartOne(passport)) {
            return false;
        }

        String[] passportInfo = passport.split(" ");

        boolean isValid = true;
        int i = 0;
        while (isValid && i < passportInfo.length) {
            if (passportInfo[i].startsWith("byr")) {
                isValid = validBirthYear(Integer.parseInt(passportInfo[i].substring(4)));
            }
            if (passportInfo[i].startsWith("iyr")) {
                isValid = validIssueYear(Integer.parseInt(passportInfo[i].substring(4)));
            }
            if (passportInfo[i].startsWith("eyr")) {
                isValid = validExpirationYear(Integer.parseInt(passportInfo[i].substring(4)));
            }
            if (passportInfo[i].startsWith("hgt")) {
                isValid = validHeight(passportInfo[i]);
            }
            if (passportInfo[i].startsWith("hcl")) {
                if (passportInfo[i].length() == 11) {
                    isValid = validHairColour(passportInfo[i]);
                }
                else {
                    isValid = false;
                }
            }
            if (passportInfo[i].startsWith("ecl")) {
                isValid = validEyeColour(passportInfo[i]);
            }
            if (passportInfo[i].startsWith("pid")) {
                if (!passportInfo[i].startsWith("pid:#") && passportInfo[i].length() == 13) {
                    isValid = validPassportID(passportInfo[i]);
                }
                else {
                    isValid = false;
                }
            }

            i++;
        }

        return isValid;
    }

    long countNumberOfValidPassportsPartTwo(List<String> passportDetails) {
        return passportDetails.stream().filter(this::validPassportPartTwo).count();
    }

    boolean validBirthYear(int value) {
        return (value >= 1920) && (value <= 2002);
    }

    boolean validIssueYear(int value) {
        return (value >= 2010) && (value <= 2020);
    }

    boolean validExpirationYear(int value) {
        return (value >= 2020) && (value <= 2030);
    }

    boolean validHeight(String value) {
        if (value.endsWith("cm")) {
            String number = value.substring(4, value.indexOf("cm"));
            int height = Integer.parseInt(number);
            return (height >= 150) && (height <= 193);
        }
        else if (value.endsWith("in")) {
            String number = value.substring(4, value.indexOf("in"));
            int height = Integer.parseInt(number);
            return (height >= 59) && (height <= 76);
        }
        return false;
    }

    boolean validHairColour(String value) {
        return value.matches(HAIR_COLOUR_REGEX);
    }

    boolean validEyeColour(String value) {
        return value.matches(EYE_COLOUR_REGEX);
    }

    boolean validPassportID(String value) {
        try {
            int passportId = Integer.parseInt(value.substring(4));
            return (value.length() == 13) && (passportId > -1);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException thrown");
            return false;
        }
    }
}
