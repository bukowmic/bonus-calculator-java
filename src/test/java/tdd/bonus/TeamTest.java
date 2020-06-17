package tdd.bonus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {
    @Test
    void should_return_sales_of_0_for_empty_team_member() {
        Team team = new Team(new ArrayList<>(), 10);

        int teamSale = team.geTeamSale();

        assertThat(teamSale).isEqualTo(0);
    }

    @Test
    void should_return_sales_for_one_team_member() {
        Salesman salesman = SalesmanHelper.exampleSalesman().sales(1000).build();
        Team team = new Team(Collections.singletonList(salesman), 10);

        int teamSale = team.geTeamSale();

        assertThat(teamSale).isEqualTo(1000);
    }

    @Test
    void should_return_quota_of_0_for_empty_team_member() {
        Team team = new Team(new ArrayList<>(), 10);

        int teamQuota = team.geTeamQuota();

        assertThat(teamQuota).isEqualTo(0);
    }

    @Test
    void should_return_quota_for_one_team_member() {
        Salesman salesman = SalesmanHelper.exampleSalesman().quota(1000).build();
        Team team = new Team(Collections.singletonList(salesman), 10);

        int teamQuota = team.geTeamQuota();

        assertThat(teamQuota).isEqualTo(1000);
    }

    @Test
    void should_return_team_member_of_0_for_empty_team_member() {
        Team team = new Team(new ArrayList<>(), 10);

        int membersNumber = team.teamMembersNumber();

        assertThat(membersNumber).isEqualTo(0);
    }

    @Test
    void should_return_member_number_1_for_one_team_member() {
        Salesman salesman = SalesmanHelper.exampleSalesman().build();
        Team team = new Team(Collections.singletonList(salesman), 10);

        int membersNumber = team.teamMembersNumber();

        assertThat(membersNumber).isEqualTo(1);
    }
}