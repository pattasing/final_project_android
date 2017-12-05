package kmitl.playstory.pattasing.playstory.test;

public class ValidateMessageNull implements MyValidator{
    @Override
    public boolean idValidate(String input) {
        return input == null;
    }

    @Override
    public String getErrorMessage() {
        return "Message is null";
    }
}
