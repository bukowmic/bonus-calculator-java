package tdd.bonus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class Team {
    private final List<Salesman> salesmen;
    @Getter
    private final int teamCommissionPercentage;

    public int geTeamSale() {
        return Optional.ofNullable(salesmen).orElse(Collections.emptyList())
                .stream()
                .map(Salesman::getSales)
                .reduce(0, Integer::sum);
    }

    public int geTeamQuota() {
        return Optional.ofNullable(salesmen).orElse(Collections.emptyList())
                .stream()
                .map(Salesman::getQuota)
                .reduce(0, Integer::sum);
    }

    public int teamMembersNumber() {
        return Optional.ofNullable(salesmen).orElse(Collections.emptyList())
                .size();
    }
}
