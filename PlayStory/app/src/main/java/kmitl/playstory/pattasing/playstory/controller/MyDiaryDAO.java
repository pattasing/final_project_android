package kmitl.playstory.pattasing.playstory.controller;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDiaryDAO {

    @Query("SELECT * FROM MYDIARY")
    List<MyDiaryTable> getAll();

    @Insert
    void insert(MyDiaryTable myDiaryTable);

    @Query("SELECT DISTINCT DATE,CHARACTER FROM MYDIARY WHERE EMAIL LIKE :userEmail")
    public abstract List<MyDiaryTable> getDateAndCha(String userEmail);
}
