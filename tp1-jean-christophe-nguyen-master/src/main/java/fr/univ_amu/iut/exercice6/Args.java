package fr.univ_amu.iut.exercice6;

import static fr.univ_amu.iut.exercice6.ArgsException.ErrorCode.INVALID_ARGUMENT_NAME;

public class Args {
    public Args(String schema, String[] args) throws ArgsException {
        parseSchema(schema);
        parseArgumentStrings(args);
        throw new RuntimeException("Not yet implemented !");
    }

    public boolean has(char arg) {
        throw new RuntimeException("Not yet implemented !");
    }

    public int cardinality() {
        throw new RuntimeException("Not yet implemented !");
    }

    public boolean getBoolean(char arg) {
        throw new RuntimeException("Not yet implemented !");
    }

    public String getString(char arg) {
        throw new RuntimeException("Not yet implemented !");
    }

    public int getInt(char arg) {
        throw new RuntimeException("Not yet implemented !");
    }

    public double getDouble(char arg) {
        throw new RuntimeException("Not yet implemented !");
    }

    private void parseSchema(String schema) throws ArgsException {
        for (String element : schema.split(","))
            if (element.length() > 0)
                parseSchemaElement(element.trim());
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId))
            throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
    }

    private void parseSchemaElement(String element) throws ArgsException {
        throw new RuntimeException("Not yet implemented !");
    }

    private void parseArgumentStrings(String[] argsList) throws ArgsException {
        throw new RuntimeException("Not yet implemented !");
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException {
        throw new RuntimeException("Not yet implemented !");
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException {
        throw new RuntimeException("Not yet implemented !");
    }
}
