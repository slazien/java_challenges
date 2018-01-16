package com.slazien;

import java.util.logging.SocketHandler;

public class Main {

    public static void main(String[] args) {
        LeagueTable<Team<FootballPlayer>> footballLeague = new LeagueTable<>("AFL");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");

        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
//        footballLeague.add(baseballTeam);

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);

        footballLeague.showLeagueTable();

        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(beckham); // unchecked warning
        rawTeam.addPlayer(pat); // unchecked warning

        footballLeague.add(rawTeam);

        LeagueTable<Team> rawLeague = new LeagueTable<>("Raw");
        rawLeague.add(adelaideCrows); // no warning
        rawLeague.add(baseballTeam); // no warning
        rawLeague.add(rawTeam);

        LeagueTable reallyRaw = new LeagueTable("Really raw");
        reallyRaw.add(adelaideCrows); // unchecked warning
        reallyRaw.add(baseballTeam); //unchecked warning
        reallyRaw.add(rawTeam); // unchecked warning
    }
}
