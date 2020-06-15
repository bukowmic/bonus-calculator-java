package tdd.bonus;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusCalculatorTest {

    @Test
    void should_calculate_individual_bonus_0_for_sales_equal_to_quota() {
        BonusCalculator bonusCalculator = new BonusCalculator();
        Salesman salesman = new Salesman(10, 10, 100, 100);

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void should_calculate_realization_of_sales() {
        BonusCalculator bonusCalculator = new BonusCalculator();
        Salesman salesman = new Salesman(100, 50, 100, 100);

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(new BigDecimal(50));
    }

    @Test
    void should_calculate_0_for_sales_lower_then_quota() {
        BonusCalculator bonusCalculator = new BonusCalculator();
        Salesman salesman = new Salesman(50, 100, 10, 10);

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void should_calculate_bonus_without_tax() {
        BonusCalculator bonusCalculator = new BonusCalculator();
        Salesman salesman = new Salesman(100, 50, 10, 100);

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(new BigDecimal(5));
    }

    @Test
    void should_calculate_bonus_with_tax() {
        BonusCalculator bonusCalculator = new BonusCalculator();
        Salesman salesman = new Salesman(100, 50, 10, 50);

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(new BigDecimal("2.5"));
    }
}
