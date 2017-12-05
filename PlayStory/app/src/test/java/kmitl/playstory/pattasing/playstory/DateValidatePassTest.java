package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateDateNull;

import static junit.framework.Assert.assertFalse;

public class DateValidatePassTest {
    @Test
    public void dateNotNull(){
        ValidateDateNull validateDateNull = new ValidateDateNull();
        String date = "20 November 2017";
        boolean result = validateDateNull.idValidate(date);
        assertFalse("pass", result);
    }
}
