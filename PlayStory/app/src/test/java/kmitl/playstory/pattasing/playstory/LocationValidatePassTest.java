package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateLocationNull;

import static junit.framework.Assert.assertFalse;

public class LocationValidatePassTest {
    @Test
    public void locationNotNull(){
        ValidateLocationNull validateLocationNull = new ValidateLocationNull();
        String location = "IT KMITL";
        boolean result = validateLocationNull.idValidate(location);
        assertFalse("pass", result);
    }
}
