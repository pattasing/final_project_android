package kmitl.playstory.pattasing.playstory.test;

public class ValidateTimeNull implements MyValidator{
    @Override
    public boolean idValidate(String input) {
        return input == null;
    }

    @Override
    public String getErrorMessage() {
        return "Time is null";
    }
}
