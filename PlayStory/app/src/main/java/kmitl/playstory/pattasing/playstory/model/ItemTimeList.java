package kmitl.playstory.pattasing.playstory.model;

import java.util.ArrayList;
import java.util.List;

public class ItemTimeList {

    List<ItemTime> itemTimeList;
    ItemTime itemTime;

    public ItemTimeList() {
        itemTimeList = new ArrayList<>();
    }

    public void setItemTime(ItemTime itemTime) {
        this.itemTime = itemTime;
        itemTimeList.add(itemTime);
    }

    public List<ItemTime> getItemTimeList() {
        return itemTimeList;
    }
}
