package fr.univ_amu.iut.exercice4;

import java.util.ArrayList;
import java.util.List;

public class RobotSimulator {
    private Robot robot;
    private String instructions;

    public RobotSimulator(Robot robot, String instructions) {
        this.robot = robot;
        this.instructions = instructions;
    }

    public void simulate() {
        List<Movement> mouvements = getMovements();
        for (Movement m : mouvements) {
            switch(m) {
                case ADVANCE:
                    robot.advance();
                    break;
                case LEFT:
                    robot.turnLeft();
                    break;
                case RIGHT:
                    robot.turnRight();
                    break;
                case NONE:
                    break;
            }
        }
    }

    public List<Movement> getMovements() {
        List<Movement> listeMouvements = new ArrayList<>();

        for (int i = 0; i < instructions.length(); ++i) {
            Movement instruction = Movement.getMovement(instructions.charAt(i));
            if (instruction == Movement.NONE) continue;
            listeMouvements.add(Movement.getMovement(instructions.charAt(i)));
        }

        return listeMouvements;
    }
}
