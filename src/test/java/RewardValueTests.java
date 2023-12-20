import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        var rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue, true);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }

    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 10000;
        var rewardValue = new RewardValue(cashValue);
        rewardValue.convertFromCashToMiles();
        assertEquals(cashValue*0.0035, rewardValue.getMilesValue());
    }

    @Test
    void convert_from_miles_to_cash() {
        int milesValue = 10000;
        var rewardValue = new RewardValue(milesValue, true); //Specify isMiles as true
        rewardValue.convertFromMilesToCash();
        assertEquals(milesValue, rewardValue.getCashValue() / 0.0035, 0.0001); //Compare with the correct conversion, and add a delta for double comparison
    }
}
