package kmitl.playstory.pattasing.playstory.model;

import java.util.ArrayList;
import java.util.List;

public class MyDiary {

    private String date;
    private String character;
    private List<ItemTime> itemTimes;

    public MyDiary() {
        itemTimes = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public List<ItemTime> getItemTimes() {
        return itemTimes;
    }

    public void setItemTimes(List<ItemTime> itemTimes) {
        this.itemTimes = itemTimes;
    }
}
