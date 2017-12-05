package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateMessageNull;

import static junit.framework.Assert.assertFalse;

public class MessageValidatePassTest {

    @Test
    public void messageNotNull(){
    ValidateMessageNull validateMessageNull = new ValidateMessageNull();
    String message = "Test";
    boolean result = validateMessageNull.idValidate(message);
    assertFalse("pass", result);
    }
}
