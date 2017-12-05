package kmitl.playstory.pattasing.playstory.test;

public class ValidateIconNull implements MyValidator{
    @Override
    public boolean idValidate(String input) {
        return input == null;
    }

    @Override
    public String getErrorMessage() {
        return "Icon is null";
    }
}
