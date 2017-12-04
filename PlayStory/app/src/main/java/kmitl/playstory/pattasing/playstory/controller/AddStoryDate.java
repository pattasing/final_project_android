package kmitl.playstory.pattasing.playstory.controller;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Calendar;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.adapter.ItemTimeAdapter;
import kmitl.playstory.pattasing.playstory.model.ItemTime;
import kmitl.playstory.pattasing.playstory.model.ItemTimeList;
import kmitl.playstory.pattasing.playstory.model.MyDiary;
import kmitl.playstory.pattasing.playstory.model.SelectIconTime;
import kmitl.playstory.pattasing.playstory.view.IconChaFragment;

public class AddStoryDate extends AppCompatActivity {

    protected static TextView dateShow;
    protected static Button buttonDate;
    private TextView textAddBar;
    private TextView textDateSelect;
    private TextView textCha;
    private TextView textStoryTime;
    private TextView textSaveDate;
    private TextView textCancelDate;
    private int RESULT_ADD_TIME = 101;
    private SelectIconTime selectIconTime;
    private ImageView imageInAddIcon;
    private String userEmail;

    protected static String dateDiary;

    ItemTimeAdapter itemTimeAdapter;
    RecyclerView recyclerView;

    private int checkHaveIcon = 0;

    private IconChaFragment iconChaFragment;
    private FragmentManager fragmentManager;

    private ItemTimeList itemTimeList= new ItemTimeList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_date);

        fragmentManager = getFragmentManager();
        iconChaFragment = new IconChaFragment();

        dateShow = (TextView) findViewById(R.id.textDateShow);
        buttonDate = (Button) findViewById(R.id.buttonDatePick);
        textAddBar = (TextView) findViewById(R.id.textAddTimeStory);
        textDateSelect = (TextView) findViewById(R.id.textDateSelect);
        textCha = (TextView) findViewById(R.id.textCha);
        textStoryTime = (TextView) findViewById(R.id.textStoryTime);
        textSaveDate = (TextView) findViewById(R.id.textSaveDate);
        textCancelDate = (TextView) findViewById(R.id.textCancelDate);
        imageInAddIcon = (ImageView) findViewById(R.id.imageInAddIcon);

        Typeface font = Typeface.createFromAsset(getAssets(), "waffle_regular.otf");
        dateShow.setTypeface(font);
        buttonDate.setTypeface(font);
        textAddBar.setTypeface(font);
        textDateSelect.setTypeface(font);
        textCha.setTypeface(font);
        textStoryTime.setTypeface(font);
        textSaveDate.setTypeface(font);
        textCancelDate.setTypeface(font);

        dateShow.setVisibility(View.GONE);

        itemTimeAdapter = new ItemTimeAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.listTimeDiary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemTimeAdapter.setItemTimeList(itemTimeList.getItemTimeList());
        recyclerView.setAdapter(itemTimeAdapter);

        Intent intent = getIntent();
        userEmail = intent.getStringExtra("userEmail");

    }
    public void datePick(View view){
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getFragmentManager(), "Select date");
    }

    public void dateShow(View view){
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getFragmentManager(), "Select date");
    }

    public void buttonAddTimeStory(View view) {
        Intent intent = new Intent(this, AddItemDate.class);
        intent.putExtra("testIntent", "Hello EIEI");
        startActivityForResult(intent, RESULT_ADD_TIME);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_ADD_TIME && resultCode == RESULT_OK) {
            ItemTime itemTime = new ItemTime();
            itemTime.setTime(data.getStringExtra("itemTime"));
            itemTime.setMessage(data.getStringExtra("itemMessage"));
            itemTime.setLocation(data.getStringExtra("itemLocation"));
            itemTime.setIconUrl(data.getStringExtra("itemIcon"));

            itemTimeList.setItemTime(itemTime);
            System.out.println("Testsize : "+itemTimeList.getItemTimeList().size());
            itemTimeAdapter.notifyDataSetChanged();
        }
    }

    public void getIconCha(String url) {
        selectIconTime = SelectIconTime.getSelectIconTimeInstance();
        if(selectIconTime.getUrlIconCha() != null){
            Glide.with(this).load(selectIconTime.getUrlIconCha()).into(imageInAddIcon);
            checkHaveIcon = 1;
        }
    }

    public void buttonAddDiary(View view) {
        final MyDiary myDiary = new MyDiary();


        System.out.println(myDiary.getDate());
        System.out.println(myDiary.getCharacter());
        System.out.println(myDiary.getCharacter());

        if(dateDiary == null || selectIconTime.getUrlIconCha() == null || itemTimeList.getItemTimeList() == null){
            Toast.makeText(this, "You Have Empty Field", Toast.LENGTH_LONG).show();
        }
        else{
            myDiary.setDate(dateDiary);
            myDiary.setCharacter(selectIconTime.getUrlIconCha());
            myDiary.setItemTimes(itemTimeList.getItemTimeList());

            System.out.println("888888888 : " + myDiary.getDate());

            for (int i = 0; i < myDiary.getItemTimes().size(); i++){
                final MyDiaryDB myDiaryDB = Room.databaseBuilder(this,
                        MyDiaryDB.class, "MYDIARY")
                        .build();

                final int finalI = i;
                new AsyncTask<Void, Void, MyDiaryTable>(){

                    @Override
                    protected MyDiaryTable doInBackground(Void... voids) {

//                for(int i = 0; i < myDiary.getItemTimes().size(); i++){
                        MyDiaryTable myDiaryTable = new MyDiaryTable();
                        myDiaryTable.setEmail(userEmail);
                        myDiaryTable.setDate(myDiary.getDate());
                        myDiaryTable.setCharacter(myDiary.getCharacter());
                        myDiaryTable.setTime(myDiary.getItemTimes().get(finalI).getTime());
                        myDiaryTable.setMessage(myDiary.getItemTimes().get(finalI).getMessage());
                        myDiaryTable.setLocation(myDiary.getItemTimes().get(finalI).getLocation());
                        myDiaryTable.setIcon(myDiary.getItemTimes().get(finalI).getIconUrl());
                        System.out.println(myDiaryTable.getId()+myDiaryTable.getCharacter());
                        myDiaryDB.getMyDiaryDAO().insert(myDiaryTable);
//                }

                        return null;
                    }
                }.execute();
            }

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }



    }

    public void buttonCancelDate(View view) {
        finish();
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String listMonth[] = {"January", "February", "March", "April", "May", "June", "July"
                    , "August", "September", "October", "November", "December"};

            String date = String.valueOf(dayOfMonth) + " " + listMonth[month] + " " + String.valueOf(year);
            dateShow.setText(date);

            dateDiary = date;

            dateShow.setVisibility(View.VISIBLE);
            buttonDate.setVisibility(View.GONE);
        }
    }

    public void buttonAddIcon (View view){
        if(checkHaveIcon == 0){
            iconChaFragment.show(fragmentManager, "Icon_Tag");
        }
    }
}
