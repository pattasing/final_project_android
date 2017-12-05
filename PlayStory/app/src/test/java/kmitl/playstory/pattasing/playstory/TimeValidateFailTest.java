package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateTimeNull;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TimeValidateFailTest {
    @Test
    public void timeIsNull(){
        ValidateTimeNull validateTimeNull = new ValidateTimeNull();
        String time = null;
        boolean result = validateTimeNull.idValidate(time);
        String stringResult = validateTimeNull.getErrorMessage();
        assertTrue("not save", result);
        assertEquals("Time is null", stringResult);
    }
}
