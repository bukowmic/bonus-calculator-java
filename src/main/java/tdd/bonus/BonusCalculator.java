package tdd.bonus;

import java.math.BigDecimal;

public class BonusCalculator {

    public BigDecimal calculateIndividualBonus(Salesman salesman) {
        int salesRealization = getSalesRealization(salesman.getSales(), salesman.getQuota());
        double bonusWithoutTax = (salesRealization * salesman.getCommissionPercentage()) / 100.0;
        double bonusWithTax = (bonusWithoutTax * salesman.getTaxPercentage()) / 100.0;
        return new BigDecimal(bonusWithTax);
    }

    private int getSalesRealization(int sales, int quota) {
        return sales > quota ? sales - quota : 0;
    }
}
