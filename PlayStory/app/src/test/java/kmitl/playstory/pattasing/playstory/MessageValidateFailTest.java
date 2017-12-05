package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateMessageNull;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MessageValidateFailTest {

    @Test
    public void messageIsNull(){
        ValidateMessageNull validateMessageNull = new ValidateMessageNull();
        String name = null;
        boolean result  =validateMessageNull.idValidate(name);
        String stringResult = validateMessageNull.getErrorMessage();
        assertTrue("not save", result);
        assertEquals("Message is null", stringResult);
    }
}
