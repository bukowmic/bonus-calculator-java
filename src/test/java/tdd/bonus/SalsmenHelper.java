package tdd.bonus;

class SalesmanHelper {
    private SalesmanHelper() {
    }

    static Salesman.SalesmanBuilder exampleSalesman() {
        return Salesman.builder()
                .sales(10)
                .quota(10)
                .commissionPercentage(100)
                .taxPercentage(0);
    }
}
