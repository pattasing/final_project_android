package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateCharacterNull;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class CharacterValidateFailTest {

    @Test
    public void characterIsNull(){
        ValidateCharacterNull validateCharacterNull = new ValidateCharacterNull();
        String imageUrl = null;
        boolean result = validateCharacterNull.idValidate(imageUrl);
        String stringResult = validateCharacterNull.getErrorMessage();
        assertTrue("not save", result);
        assertEquals("Character is null", stringResult);
    }
}
