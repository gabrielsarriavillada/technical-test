package utils;

import java.math.BigDecimal;

/**
 * Created by gabriels on 27/04/2017.
 */
public class ScenarioContext {

    private static BigDecimal savedBalance;

    private static BigDecimal savedStake;

    public static void saveBalance(BigDecimal balance) {
        savedBalance = balance;
    }

    public static void saveStake(BigDecimal stake) {
        savedStake = stake;
    }

    public static BigDecimal getSavedBalance() {
        return savedBalance;
    }

    public static BigDecimal getSavedStake() {
        return savedStake;
    }
}
