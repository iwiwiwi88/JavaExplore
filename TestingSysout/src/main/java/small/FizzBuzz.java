package small;

import utils.Clock;

import java.util.function.Consumer;

/***
 * *** RESULTS for x = 100000 ***
 * bruteForce: Time duration [ms]: 1188
 * preRunWithIntArray: Time duration [ms]: 726
 * preRunWithStringArray: Time duration [ms]: 940
 */
public class FizzBuzz {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";
    private static Clock clock = new Clock();
    private static int x = 100000;

    public static void main(String[] args) {
        String bruteForce = "bruteForce: " + runForMethod(FizzBuzz::bruteForce);
        String preRunWithIntArray = "preRunWithIntArray: " + runForMethod(FizzBuzz::preRunWithIntArray);
        String preRunWithStringArray = "preRunWithStringArray: " + runForMethod(FizzBuzz::preRunWithStringArray);

        System.out.println(String.format("*** RESULTS for x = %s ***", x));
        System.out.println(bruteForce);
        System.out.println(preRunWithIntArray);
        System.out.println(preRunWithStringArray);
    }

    private static String runForMethod(Consumer<Integer> consumer) {
        clock.start();
        consumer.accept(x);
        clock.stop();
        return clock.toString();
    }

    private static void bruteForce(int x) {
        for (int i = 1; i <= x; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(FIZZBUZZ);
            } else if (i % 3 == 0) {
                System.out.println(FIZZ);
            } else if (i % 5 == 0) {
                System.out.println(BUZZ);
            } else {
                System.out.println(i);
            }
        }
    }

    private static void preRunWithIntArray(int x) {
        int[] nums = new int[x + 1];

        for (int i = 3; i <= x; i += 3) {
            nums[i]++;
        }
        for (int i = 5; i <= x; i += 5) {
            nums[i] += 2;
        }

        for (int i = 1; i <= x; i++) {
            switch (nums[i]) {
                case 0:
                    System.out.println(i);
                    break;
                case 1: // div by 3
                    System.out.println(FIZZ);
                    break;
                case 2: // div by 5
                    System.out.println(BUZZ);
                    break;
                case 3: // div by 3 and 5
                    System.out.println(FIZZBUZZ);
            }
        }
    }


    private static void preRunWithStringArray(int x) {
        String[] s = new String[x + 1];

        for (int i = 3; i <= x; i += 3) {
            s[i] = FIZZ;
        }
        for (int i = 5; i <= x; i += 5) {
            s[i] = s[i] == null ? BUZZ : s[i] + BUZZ;
        }

        for (int i = 1; i <= x; i++) {
            if (s[i] == null) {
                System.out.println(i);
            } else {
                System.out.println(s[i]);
            }
        }
    }

}
