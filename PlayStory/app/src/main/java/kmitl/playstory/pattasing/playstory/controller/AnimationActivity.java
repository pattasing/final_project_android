package kmitl.playstory.pattasing.playstory.controller;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.adapter.CustomListItemAdapter;
import kmitl.playstory.pattasing.playstory.adapter.IconTimeAnimationAdapter;
import kmitl.playstory.pattasing.playstory.model.SelectTimeToShow;

public class AnimationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView textTime;
    private TextView textLocation;
    private TextView textMesasse;
    private List<MyDiaryTable> myDiaryTableListGlobal;

    private TextView textDate;
    private TextView textBack;

    private ImageView imageAnimation;

    private String userEmail;
    private String datePlay;

    private CustomListItemAdapter adapter;
    private ListView list;
    private float tempPosY = 0.0f;

    SelectTimeToShow selectTimeToShow;

    RecyclerView recyclerView;
    IconTimeAnimationAdapter iconTimeAnimationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        textBack = (TextView) findViewById(R.id.textBackAnima);
        textDate = (TextView) findViewById(R.id.dateAnima);
        Typeface font = Typeface.createFromAsset(getAssets(), "waffle_regular.otf");
        textDate.setTypeface(font);
        textBack.setTypeface(font);

        userEmail = MainActivity.userEmail;

        Intent intent = getIntent();
        datePlay = intent.getStringExtra("datePlay");
        textDate.setText(datePlay);

        textTime = (TextView) findViewById(R.id.textViewTimeAnima);
        textLocation = (TextView) findViewById(R.id.textViewLocationAnima);
        textMesasse = (TextView) findViewById(R.id.textViewMessageAnima);

        queryTimeIndate();

        imageAnimation = (ImageView) findViewById(R.id.imageAnimation);

        imageAnimation.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) imageAnimation.getBackground()).start();
            }
        });

        list = (ListView) findViewById(R.id.listItemIconTime);
        list.setOnItemClickListener(this);

    }

    private void queryTimeIndate() {
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
                adapter = new CustomListItemAdapter(AnimationActivity.this,
                        R.layout.icon_animation_page, myDiaryTables);

                list.setAdapter(adapter);

             }
        }.execute();
    }

    public void buttonBackAnima(View view) {
        finish();
    }

    public void runAnimation(float posY){
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f, tempPosY,
                posY);
        tempPosY = posY;
        animation.setDuration(2000);
        animation.setRepeatCount(0);
//        animation.setRepeatMode(2);
        animation.setFillAfter(true);
        imageAnimation.startAnimation(animation);
    }

    public void setStory(int position){
        textTime.setText(myDiaryTableListGlobal.get(position).getTime());
        textLocation.setText(myDiaryTableListGlobal.get(position).getLocation());
        textMesasse.setText(myDiaryTableListGlobal.get(position).getMessage());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        float posY = view.getY();
        setStory(position);
        runAnimation(posY);
    }
}