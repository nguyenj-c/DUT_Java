package fr.univ_amu.iut.exercice4;

import java.util.List;

public class RobotSimulator {
    private Robot robot;
    private String instructions;

    public RobotSimulator(Robot robot, String instructions) {
        this.robot = robot;
        this.instructions = instructions;
    }

    public void simulate() {
        throw new RuntimeException("Not yet implemented !");
    }

    public List<Movement> getMovements() {throw new RuntimeException("Not yet implemented !"); }
}
