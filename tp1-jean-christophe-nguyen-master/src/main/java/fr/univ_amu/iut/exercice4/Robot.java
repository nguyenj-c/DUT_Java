package fr.univ_amu.iut.exercice4;


public class Robot {
    private GridPosition gridPosition;
    private Orientation orientation;

    public Robot(GridPosition gridPosition, Orientation orientation) {
        this.gridPosition = gridPosition;
        this.orientation = orientation;
    }

    public GridPosition getGridPosition() {
        return gridPosition;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void turnRight() {
        switch(orientation) {
            case NORTH:
                orientation = Orientation.EAST;
                break;
            case EAST:
                orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                orientation = Orientation.WEST;
                break;
            case WEST:
                orientation = Orientation.NORTH;
                break;
        }
    }

    public void turnLeft() {
        switch(orientation) {
            case NORTH:
                orientation = Orientation.WEST;
                break;
            case EAST:
                orientation = Orientation.NORTH;
                break;
            case SOUTH:
                orientation = Orientation.EAST;
                break;
            case WEST:
                orientation = Orientation.SOUTH;
                break;
        }
    }

    public void advance() {
        switch(orientation) {
            case NORTH:
                gridPosition.setY(gridPosition.getY() + 1);
                break;
            case SOUTH:
                gridPosition.setY(gridPosition.getY() - 1);
                break;
            case EAST:
                gridPosition.setX(gridPosition.getX() + 1);
                break;
            case WEST:
                gridPosition.setX(gridPosition.getX() - 1);
                break;

            default: break;
        }
    }
}

