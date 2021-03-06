package kmitl.playstory.pattasing.playstory.controller;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDiaryDAO {

    @Insert
    void insert(MyDiaryTable myDiaryTable);

//    @Query("SELECT DISTINCT DATE, CHARACTER, id FROM MYDIARY WHERE EMAIL LIKE :userEmail")
//    public abstract List<MyDiaryTable> getDateAndCha(String userEmail);

//    @Query("SELECT * FROM MYDIARY WHERE EMAIL LIKE :userEmail")
//    public abstract List<MyDiaryTable> getDateAndCha(String userEmail);

    @Query("SELECT DATE, CHARACTER, id FROM MYDIARY WHERE EMAIL LIKE :userEmail GROUP BY DATE")
    public abstract List<MyDiaryTable> getDateAndCha(String userEmail);

    @Query("SELECT * FROM MYDIARY WHERE EMAIL LIKE :userEmail AND DATE LIKE :date")
    public abstract List<MyDiaryTable> getDatePlay(String userEmail, String date);
}
