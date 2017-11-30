package kmitl.playstory.pattasing.playstory.controller;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.adapter.ItemDayAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textHi;
    private TextView textDate;
    private TextView textMyStory;
    private ImageView imageProfile;
    private ImageView imageAdd;
    private Button buttonLogout;
    private String userEmail;
    private List<MyDiaryTable> myDiaryTableListGlobal;

    ItemDayAdapter itemDayAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String currentDate = DateFormat.getDateInstance(DateFormat.LONG).format(new Date());

        textName = (TextView) findViewById(R.id.textName);
        textDate = (TextView) findViewById(R.id.textDate);
        textHi = (TextView) findViewById(R.id.textHi);
        textMyStory = (TextView) findViewById(R.id.textMyStory);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        imageProfile = (ImageView) findViewById(R.id.imageProfile);
        imageAdd = (ImageView) findViewById(R.id.imageAdd);

        textDate.setText(currentDate);
        buttonLogout.setText("Log Out");

        Typeface font = Typeface.createFromAsset(getAssets(), "waffle_regular.otf");
        textName.setTypeface(font);
        textDate.setTypeface(font);
        textHi.setTypeface(font);
        textMyStory.setTypeface(font);
        buttonLogout.setTypeface(font);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            String uid = user.getUid();

            textName.setText(name);
            userEmail = email;
            Glide.with(this).load(photoUrl).into(imageProfile);

        } else{
            goLoginScreen();
        }

        queryDateAndCha();

    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    public void buttonAdd(View view){
        Intent intent = new Intent(this, AddStoryDate.class);
        intent.putExtra("userEmail", userEmail);
        startActivity(intent);
    }

    public void queryDateAndCha(){
        final MyDiaryDB myDiaryDB = Room.databaseBuilder(this,
                MyDiaryDB.class, "MYDIARY")
                .build();

        new AsyncTask<Void, Void, List<MyDiaryTable>>() {
            @Override
            protected List<MyDiaryTable> doInBackground(Void... voids) {
                List<MyDiaryTable> myDiaryTableList = myDiaryDB.getMyDiaryDAO().getDateAndCha(userEmail);
                myDiaryTableListGlobal = myDiaryTableList;
                System.out.println("doinbackground :"+ myDiaryTableListGlobal.size());
                return myDiaryTableList;
            }

            @Override
            protected void onPostExecute(List<MyDiaryTable> myDiaryTables) {
                myDiaryTableListGlobal = myDiaryTables;
                itemDayAdapter = new ItemDayAdapter(MainActivity.this);
                recyclerView = (RecyclerView) findViewById(R.id.listDate);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                itemDayAdapter.setItemDayList(myDiaryTableListGlobal);
                recyclerView.setAdapter(itemDayAdapter);
                System.out.println("aaaaaaaaaaa :"+ userEmail);
                System.out.println("aaaaaaaaaaa :"+ myDiaryTableListGlobal.size());
            }
        }.execute();
    }
}
