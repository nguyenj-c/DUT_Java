package fr.univ_amu.iut.exercice4;

import static fr.univ_amu.iut.exercice4.Movement.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class RobotTest {

    @Disabled
    @Test
    public void testRobotIsCreatedWithCorrectInitialPosition() {
        final GridPosition initialGridPosition = new GridPosition(0, 0);
        final Robot robot = new Robot(initialGridPosition, Orientation.NORTH);
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testRobotIsCreatedWithCorrectInitialOrientation() {
        final Orientation initialOrientation = Orientation.NORTH;
        final Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningRightDoesNotChangePosition() {
        final GridPosition initialGridPosition = new GridPosition(0, 0);
        final Robot robot = new Robot(initialGridPosition, Orientation.NORTH);
        robot.turnRight();
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromNorthToEast() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        robot.turnRight();
        final Orientation expectedOrientation = Orientation.EAST;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromEastToSouth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);
        robot.turnRight();
        final Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromSouthToWest() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);
        robot.turnRight();
        final Orientation expectedOrientation = Orientation.WEST;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromWestToNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);
        robot.turnRight();
        final Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(expectedOrientation ,robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningLeftDoesNotChangePosition() {
        final GridPosition initialGridPosition = new GridPosition(0, 0);
        final Robot robot = new Robot(initialGridPosition, Orientation.NORTH);
        robot.turnLeft();
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromNorthToWest() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        robot.turnLeft();
        final Orientation expectedOrientation = Orientation.WEST;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromWestToSouth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);
        robot.turnLeft();
        final Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromSouthToEast() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);
        robot.turnLeft();
        final Orientation expectedOrientation = Orientation.EAST;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromEastToNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);
        robot.turnLeft();
        final Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testAdvancingDoesNotChangeOrientation() {
        final Orientation initialOrientation = Orientation.NORTH;
        final Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);
        robot.advance();
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testAdvancingWhenFacingNorthIncreasesYCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        robot.advance();
        final GridPosition expectedGridPosition = new GridPosition(0, 1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testAdvancingWhenFacingSouthDecreasesYCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);
        robot.advance();
        final GridPosition expectedGridPosition = new GridPosition(0, -1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testAdvancingWhenFacingEastIncreasesXCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);
        robot.advance();
        final GridPosition expectedGridPosition = new GridPosition(1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testAdvancingWhenFacingWestDecreasesXCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);
        robot.advance();
        final GridPosition expectedGridPosition = new GridPosition(-1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
    }

    @Disabled
    @Test
    public void testInstructionsToMoveWestAndNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        RobotSimulator simulator = new RobotSimulator(robot, "LAAARALA");
        simulator.simulate();
        final GridPosition expectedGridPosition = new GridPosition(-4, 1);
        final Orientation expectedOrientation = Orientation.WEST;
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testInstructionsToMoveWestAndSouth() {
        final Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);
        final RobotSimulator simulator = new RobotSimulator(robot, "RRAAAAALA");
        simulator.simulate();
        final GridPosition expectedGridPosition = new GridPosition(-3, -8);
        final Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testInstructionsToMoveEastAndNorth() {
        final Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);
        final RobotSimulator simulator = new RobotSimulator(robot, "LAAARRRALLLL");
        simulator.simulate();
        final GridPosition expectedGridPosition = new GridPosition(11, 5);
        final Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Disabled
    @Test
    public void testListInstructionsToMoveWestAndNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        RobotSimulator simulator = new RobotSimulator(robot, "LAARALA");
        List<Movement> movements = simulator.getMovements();
        assertThat(movements).containsSequence(LEFT, ADVANCE, ADVANCE, RIGHT, ADVANCE, LEFT, ADVANCE);
    }

    @Disabled
    @Test
    public void testListInstructionsToMoveWestAndNorthBis() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        RobotSimulator simulator = new RobotSimulator(robot, "L A A R A L A");
        List<Movement> movements = simulator.getMovements();
        assertThat(movements).containsSequence(LEFT, ADVANCE, ADVANCE, RIGHT, ADVANCE, LEFT, ADVANCE);
    }
    
    @Disabled
    @Test
    public void testListInstructionsToMoveWestAndNorthTer() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);
        RobotSimulator simulator = new RobotSimulator(robot, "LAA  RA   LA");
        List<Movement> movements = simulator.getMovements();
        assertThat(movements).containsSequence(LEFT, ADVANCE, ADVANCE, RIGHT, ADVANCE, LEFT, ADVANCE);
    }
}
