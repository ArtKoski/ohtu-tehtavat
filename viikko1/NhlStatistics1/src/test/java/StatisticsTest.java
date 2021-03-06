/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ohtuesimerkki.*;

/**
 *
 * @author artkoski
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPlayerThatExists() {
        String examplePlayer = "Kurri";
        assertNotNull(stats.search(examplePlayer));
    }

    @Test
    public void searchPlayerThatDoesntExist() {
        String examplePlayer = "KurriKoira";
        assertNull(stats.search(examplePlayer));
    }

    @Test
    public void ListPlayersFromTeam() {
        String exampleTeam = "EDM";
        List<Player> exampleList = stats.team(exampleTeam);
        
        for(Player p : exampleList) {
            assertTrue(p.getTeam().equals(exampleTeam));
        }
        

    }

    @Test
    public void ListTopScorers() {
        int exampleAmount = 3;
        List<Player> exampleList = stats.topScorers(exampleAmount);
        
        int old;
        for(Player p : exampleList) {
            old = p.getPoints();
            assertTrue(p.getPoints()<=old);
        }
        

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
