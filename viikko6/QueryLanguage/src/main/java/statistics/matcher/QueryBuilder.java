/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

public class QueryBuilder {

    private Matcher pino;
    
    public QueryBuilder() {
        pino = new All();
    }

    public QueryBuilder playsIn(String team) {
        this.pino = new And(new PlaysIn(team), pino);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.pino = new And(new HasAtLeast(value, category), pino);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.pino = new And(new HasFewerThan(value, category), pino);
        return this;
    }
    public QueryBuilder oneOf(Matcher... m1) {
        this.pino = new Or(m1);
        return this;
    }
    
    

    public Matcher build() {
        Matcher currentMatcher = pino;
        pino = new All();
   
        return currentMatcher;
    }
}
