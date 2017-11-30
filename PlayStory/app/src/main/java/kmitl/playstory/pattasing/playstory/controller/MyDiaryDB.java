package kmitl.playstory.pattasing.playstory.controller;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MyDiaryTable.class}, version = 1)
public abstract class MyDiaryDB extends RoomDatabase{
    public abstract MyDiaryDAO getMyDiaryDAO();
}
