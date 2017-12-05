package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateLocationNull;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class LocationValidateFailTest {
    @Test
    public void locationIsNull(){
        ValidateLocationNull validateLocationNull = new ValidateLocationNull();
        String location = null;
        boolean result = validateLocationNull.idValidate(location);
        String stringResult = validateLocationNull.getErrorMessage();
        assertTrue("not save", result);
        assertEquals("Location is null", stringResult);
    }
}
