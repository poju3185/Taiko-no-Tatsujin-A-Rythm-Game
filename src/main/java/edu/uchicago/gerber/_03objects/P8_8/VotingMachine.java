package edu.uchicago.gerber._03objects.P8_8;

public class VotingMachine {
    private int nRepublican;
    private int nDemocrat;

    public VotingMachine() {
        nRepublican = 0;
        nDemocrat = 0;
    }

    public void voteRepublican() {
        nRepublican += 1;
    }

    public void voteDemocrat() {
        nDemocrat += 1;
    }

    public void reset(){
        nRepublican = 0;
        nDemocrat = 0;
    }

    public String getTellies() {
        return "Republican: " + nRepublican + " votes. Democrat: " + nDemocrat + " votes.";
    }
}
