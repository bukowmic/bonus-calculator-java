package tdd.bonus;

import java.math.BigDecimal;

public class BonusCalculator {

    public BigDecimal calculateIndividualBonus(Salesman salesman) {
        int salesRealization = calculateSalesRealization(salesman.getSales(), salesman.getQuota());
        double bonusCommission = calculateBonusCommission(salesRealization, salesman.getCommissionPercentage());
        double bonusWithTax = calculateIndividualBonus(bonusCommission, salesman.getTaxPercentage());
        return BigDecimal.valueOf(bonusWithTax);
    }

    private int calculateSalesRealization(int sales, int quota) {
        return sales > quota ? sales - quota : 0;
    }

    private double calculateBonusCommission(int salesRealization, int commissionPercentage) {
        return (salesRealization * commissionPercentage) / 100.0;
    }

    private double calculateIndividualBonus(double bonusCommission, int taxPercentage) {
        return bonusCommission - (bonusCommission * taxPercentage) / 100.0;
    }

    public BigDecimal calculateTeamBonus(Team team) {
        if (team == null || team.teamMembersNumber() == 0)
            return BigDecimal.ZERO;

        int salesRealization = calculateSalesRealization(team.geTeamSale(), team.geTeamQuota());
        double bonusCommission = calculateBonusCommission(salesRealization, team.getTeamCommissionPercentage());
        double bonusDividedByTeamMembersNumber = bonusCommission / team.teamMembersNumber();

        return BigDecimal.valueOf(bonusDividedByTeamMembersNumber);
    }
}
