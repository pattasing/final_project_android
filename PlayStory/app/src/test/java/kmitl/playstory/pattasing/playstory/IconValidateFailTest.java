package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateIconNull;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class IconValidateFailTest {
    @Test
    public void iconIsNull(){
        ValidateIconNull validateIconNull = new ValidateIconNull();
        String imageUrl = null;
        boolean result = validateIconNull.idValidate(imageUrl);
        String stringResult = validateIconNull.getErrorMessage();
        assertTrue("not save", result);
        assertEquals("Icon is null", stringResult);
    }
}
