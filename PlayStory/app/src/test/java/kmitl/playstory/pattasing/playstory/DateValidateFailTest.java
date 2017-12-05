package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateDateNull;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class DateValidateFailTest {
    @Test
    public void dateIsNull(){
        ValidateDateNull validateDateNull = new ValidateDateNull();
        String date = null;
        boolean result = validateDateNull.idValidate(date);
        String stringResult = validateDateNull.getErrorMessage();
        assertTrue("not save", result);
        assertEquals("Date is null", stringResult);
    }
}
