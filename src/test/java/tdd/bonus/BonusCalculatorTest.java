package tdd.bonus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusCalculatorTest {
    private BonusCalculator bonusCalculator;

    @BeforeEach
    void setUp() {
        bonusCalculator = new BonusCalculator();
    }

    @Test
    void should_calculate_individual_bonus_0_for_sales_equal_to_quota() {
        Salesman salesman = SalesmanHelper.exampleSalesman().build();

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void should_calculate_realization_of_sales() {
        Salesman salesman = SalesmanHelper.exampleSalesman()
                .sales(100)
                .quota(50)
                .build();

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(new BigDecimal(50));
    }

    @Test
    void should_calculate_0_for_sales_lower_then_quota() {
        Salesman salesman = SalesmanHelper.exampleSalesman()
                .sales(13000)
                .quota(15000)
                .commissionPercentage(10)
                .taxPercentage(10)
                .build();

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void should_calculate_bonus_without_tax() {
        Salesman salesman = SalesmanHelper.exampleSalesman()
                .sales(100)
                .quota(50)
                .commissionPercentage(10)
                .build();

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(new BigDecimal(5));
    }

    @Test
    void should_calculate_bonus_with_tax() {
        Salesman salesman = SalesmanHelper.exampleSalesman()
                .sales(12000)
                .quota(11000)
                .commissionPercentage(10)
                .taxPercentage(10)
                .build();

        BigDecimal result = bonusCalculator.calculateIndividualBonus(salesman);

        assertThat(result).isEqualByComparingTo(new BigDecimal(90));
    }

    @Test
    void should_calculate_team_bonus_of_0_for_sales_equal_to_quota_and_one_salesman() {
        Salesman salesman = SalesmanHelper.exampleSalesman().build();
        Team team = new Team(Collections.singletonList(salesman), 100);

        BigDecimal result = bonusCalculator.calculateTeamBonus(team);

        assertThat(result).isEqualByComparingTo(BigDecimal.ZERO);
    }

    @Test
    void should_calculate_team_bonus_for_sales_greater_then_quota_and_one_salesman() {
        Salesman salesman = SalesmanHelper.exampleSalesman()
                .sales(1000)
                .quota(500)
                .build();
        Team team = new Team(Collections.singletonList(salesman), 10);

        BigDecimal result = bonusCalculator.calculateTeamBonus(team);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(50));
    }

    @Test
    void should_calculate_team_bonus_for_sales_greater_then_quota_and_for_salesman() {
        List<Salesman> salesmen = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            salesmen.add(SalesmanHelper.exampleSalesman()
                    .sales(3000)
                    .quota(2750)
                    .build());
        }
        Team team = new Team(salesmen, 10);

        BigDecimal result = bonusCalculator.calculateTeamBonus(team);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(25));
    }

    @Test
    void should_calculate_team_bonus_of_0_for_sales_lower_then_quota_and_two_salesman() {
        Salesman teamMemberOne = SalesmanHelper.exampleSalesman()
                .sales(500)
                .quota(1000)
                .build();
        Salesman teamMemberTwo = SalesmanHelper.exampleSalesman()
                .sales(500)
                .quota(1000)
                .build();
        Team team = new Team(Arrays.asList(teamMemberOne, teamMemberTwo), 10);

        BigDecimal result = bonusCalculator.calculateTeamBonus(team);

        assertThat(result).isEqualByComparingTo(BigDecimal.valueOf(0));
    }

    @Test
    void should_calculate_team_bonus_of_0_for_team_without_members() {
        Team team = new Team(null, 100);

        BigDecimal result = bonusCalculator.calculateTeamBonus(team);

        assertThat(result).isEqualByComparingTo(BigDecimal.ZERO);
    }
}
