package kmitl.playstory.pattasing.playstory.test;

public class ValidateDateNull implements MyValidator{
    @Override
    public boolean idValidate(String input) {
        return input == null;
    }

    @Override
    public String getErrorMessage() {
        return "Date is null";
    }
}
