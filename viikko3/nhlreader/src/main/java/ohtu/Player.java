
package ohtu;

public class Player implements Comparable<Player> {
    
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    
    
    public void setName(String name) {
        this.name = name;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return this.nationality;
    }

    public String getName() {
        return name;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @param assists the assists to set
     */
    public void setAssists(int assists) {
        this.assists = assists;
    }

    @Override
    public int compareTo(Player t) {
        return ((this.goals + this.assists) - (t.goals+t.assists));
    }
    
    @Override
    public String toString() {
        return name + " | " + team + " | " + goals + " + " + assists + " = " + (goals+assists);
    }
      
}
