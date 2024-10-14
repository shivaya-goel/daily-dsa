import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

//    private static String msisdnPattern = "^((?!(0))\\d{9}|\\d{12})$";
    private static String msisdnPattern = "^((?!(0))\\d{12}|\\d{9})$";
    private static boolean isMsisdnTrim = false;

    private static boolean isValidMsisdn(String msisdn) {
        if (!msisdn.matches(msisdnPattern)) {
            List<String> numbers = getNumbers(msisdnPattern);
            throw new RuntimeException(getInvalidMsisdnErrorMessage(numbers));
        }
        return true;
    }

    private static List<String> getNumbers(String string) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(string);
        List<String> numbers = new ArrayList();

        while(matcher.find()) {
            numbers.add(matcher.group());
        }

        return numbers;
    }

    private static String getInvalidMsisdnErrorMessage(List<String> numbers) {
        if(isMsisdnTrim) {
            return "Invalid msisdn. It should be of " + (1+ Integer.parseInt(numbers.get(numbers.size()-1))) + " digits only. " +
                    "It should start with zero";
        }
        return "Invalid msisdn. It should be of " + numbers.get(numbers.size()-1) + " digits only. " +
                "It should not start with zero";
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.isValidMsisdn("123456789")); // true
        System.out.println(test.isValidMsisdn("123456789012")); // true
        System.out.println(test.isValidMsisdn("1234567890")); //false
    }
}
