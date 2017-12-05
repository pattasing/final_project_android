package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateTimeNull;

import static junit.framework.Assert.assertFalse;

public class TimeValidatePassTest {
    @Test
    public void timeNotNull(){
        ValidateTimeNull validateTimeNull = new ValidateTimeNull();
        String time = "11:11";
        boolean result = validateTimeNull.idValidate(time);
        assertFalse("pass", result);
    }
}
