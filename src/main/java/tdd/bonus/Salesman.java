package tdd.bonus;

import lombok.Value;

@Value
public class Salesman {
    int sales;
    int quota;
    int commissionPercentage;
    int taxPercentage;
}