package kmitl.playstory.pattasing.playstory.model;

public class SelectIconTime {
    private static SelectIconTime selectIconTimeInstance;
    private String urlIcon;
    private String urlIconCha;

    public static SelectIconTime getSelectIconTimeInstance(){
        if (selectIconTimeInstance == null){
            selectIconTimeInstance = new SelectIconTime();
        }
        return selectIconTimeInstance;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public String getUrlIconCha() {
        return urlIconCha;
    }

    public void setUrlIconCha(String urlIconCha) {
        this.urlIconCha = urlIconCha;
    }
}
