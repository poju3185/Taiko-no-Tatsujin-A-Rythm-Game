package edu.uchicago.gerber._03objects.P8_8;

public class VotingMachineDriver {
    public static void main(String[] args) {
        VotingMachine votingMachine = new VotingMachine();
        votingMachine.voteRepublican();
        votingMachine.voteDemocrat();
        System.out.println(votingMachine.getTellies());
    }
}
