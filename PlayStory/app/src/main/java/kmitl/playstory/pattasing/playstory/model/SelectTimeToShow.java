package kmitl.playstory.pattasing.playstory.model;

public class SelectTimeToShow {
    private static SelectTimeToShow selectTimeToShowInstance;
    private int indexTime;
    private float PosY;

    public interface OnItemChangeListener{
        void onItemChange(SelectTimeToShow selectTimeToShow);
    }

    private OnItemChangeListener listener;

    public void setListener(OnItemChangeListener listener){
        this.listener = listener;
    }

    public static SelectTimeToShow getSelectTimeToShowInstance(){
        if (selectTimeToShowInstance == null){
            selectTimeToShowInstance = new SelectTimeToShow();
        }
        return selectTimeToShowInstance;
    }

    public int getIndexTime() {
        return indexTime;
    }

    public void setIndexTime(int indexTime) {
        this.indexTime = indexTime;
    }

    public float getPosY() {
        return PosY;
    }

    public void setPosY(float posY) {
        PosY = posY;
    }
}
