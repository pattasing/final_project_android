package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateIconNull;

import static junit.framework.Assert.assertFalse;

public class IconValidatePassTest {
    @Test
    public void iconNotNull(){
        ValidateIconNull validateIconNull = new ValidateIconNull();
        String time = "https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconTime%2F001-pencil-case.png?alt=media&token=37a09e4d-269d-4377-b19a-3e0597bb930e";
        boolean result = validateIconNull.idValidate(time);
        assertFalse("pass", result);
    }
}
