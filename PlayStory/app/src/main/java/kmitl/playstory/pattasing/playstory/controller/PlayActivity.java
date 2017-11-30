package kmitl.playstory.pattasing.playstory.controller;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.adapter.ItemDayAdapter;
import kmitl.playstory.pattasing.playstory.adapter.ItemPlayAdapter;

public class PlayActivity extends AppCompatActivity {

    private TextView textDate;
    private TextView textBack;
    private List<MyDiaryTable> myDiaryTableListGlobal;
    private String userEmail;
    private String datePlay;

    RecyclerView recyclerView;
    ItemPlayAdapter itemPlayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        textBack = (TextView) findViewById(R.id.textBack);
        textDate = (TextView) findViewById(R.id.datePlay);
        Typeface font = Typeface.createFromAsset(getAssets(), "waffle_regular.otf");
        textDate.setTypeface(font);
        textBack.setTypeface(font);

        userEmail = MainActivity.userEmail;

        Intent intent = getIntent();
        datePlay = intent.getStringExtra("datePlay");
        textDate.setText(datePlay);

        queryTimeInDate();
    }

    public void queryTimeInDate(){
        final MyDiaryDB myDiaryDB = Room.databaseBuilder(this,
                MyDiaryDB.class, "MYDIARY")
                .build();

        new AsyncTask<Void, Void, List<MyDiaryTable>>() {
            @Override
            protected List<MyDiaryTable> doInBackground(Void... voids) {
                List<MyDiaryTable> myDiaryTableList = myDiaryDB.getMyDiaryDAO().getDatePlay(userEmail, datePlay);
                myDiaryTableListGlobal = myDiaryTableList;
                System.out.println("doinbackground :"+ myDiaryTableListGlobal.size());
                return myDiaryTableList;
            }

            @Override
            protected void onPostExecute(List<MyDiaryTable> myDiaryTables) {
                myDiaryTableListGlobal = myDiaryTables;
                itemPlayAdapter = new ItemPlayAdapter(PlayActivity.this);
                recyclerView = (RecyclerView) findViewById(R.id.listInPlay);
                recyclerView.setLayoutManager(new LinearLayoutManager(PlayActivity.this));
                itemPlayAdapter.setItemDayList(myDiaryTableListGlobal);
                recyclerView.setAdapter(itemPlayAdapter);
            }
        }.execute();
    }

    public void buttonBack(View view) {
        finish();
    }
}
