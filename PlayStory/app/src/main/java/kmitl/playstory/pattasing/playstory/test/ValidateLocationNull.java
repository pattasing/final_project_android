package kmitl.playstory.pattasing.playstory.test;

public class ValidateLocationNull implements MyValidator{
    @Override
    public boolean idValidate(String input) {
        return input == null;
    }

    @Override
    public String getErrorMessage() {
        return "Location is null";
    }
}
