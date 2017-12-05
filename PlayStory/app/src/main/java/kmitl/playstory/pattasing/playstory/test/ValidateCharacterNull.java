package kmitl.playstory.pattasing.playstory.test;

public class ValidateCharacterNull implements MyValidator{
    @Override
    public boolean idValidate(String input) {
        return input == null;
    }

    @Override
    public String getErrorMessage() {
        return "Character is null";
    }
}
