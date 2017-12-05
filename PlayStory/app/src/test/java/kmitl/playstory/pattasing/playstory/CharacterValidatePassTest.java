package kmitl.playstory.pattasing.playstory;

import org.junit.Test;

import kmitl.playstory.pattasing.playstory.test.ValidateCharacterNull;

import static junit.framework.Assert.assertFalse;

public class CharacterValidatePassTest {
    @Test
    public void characterNotNull(){
        ValidateCharacterNull validateCharacterNull = new ValidateCharacterNull();
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconCha%2Fscottish_man1.png?alt=media&token=f6db157f-20b4-4a67-8bd8-906153c37a58";
        boolean result  = validateCharacterNull.idValidate(imageUrl);
        assertFalse("pass", result);
    }
}
