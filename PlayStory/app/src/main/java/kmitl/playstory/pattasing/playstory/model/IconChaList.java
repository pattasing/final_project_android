package kmitl.playstory.pattasing.playstory.model;

import java.util.ArrayList;
import java.util.List;

public class IconChaList {

    private List<String> iconChaList = new ArrayList<>();

    public IconChaList() {
        this.iconChaList.add("https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconCha%2Fscottish_1.png?alt=media&token=bd5afd77-8a08-420a-b616-6a2da447e5a6");
        this.iconChaList.add("https://firebasestorage.googleapis.com/v0/b/playstory-ad4c1.appspot.com/o/IconCha%2Fscottish_man1.png?alt=media&token=f6db157f-20b4-4a67-8bd8-906153c37a58");
    }

    public List<String> getIconChaList() {
        return iconChaList;
    }
}
