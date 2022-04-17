package fr.univ_amu.iut.exercice4;

public enum Movement {
    LEFT('L'),
    RIGHT('R'),
    ADVANCE('A'),
    NONE(' ');

    char instruction;

    Movement(char instruction) {
        this.instruction = instruction;
    }

    public static Movement getMovement(char instruction) {
        switch (instruction) {
            case 'L':
                return LEFT;
            case 'R':
                return RIGHT;
            case 'A':
                return ADVANCE;
            default:
                return NONE;
        }
    }
}
