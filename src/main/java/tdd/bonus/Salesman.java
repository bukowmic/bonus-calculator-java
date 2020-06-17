package tdd.bonus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Salesman {
    int sales;
    int quota;
    int commissionPercentage;
    int taxPercentage;
}