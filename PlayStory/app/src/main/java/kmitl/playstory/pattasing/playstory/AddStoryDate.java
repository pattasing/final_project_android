package kmitl.playstory.pattasing.playstory;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class AddStoryDate extends AppCompatActivity {

    protected static TextView dateShow;
    protected static Button buttonDate;
    private TextView textAddBar;
    private TextView textDateSelect;
    private TextView textCha;
    private TextView textStoryTime;
    private TextView textSaveDate;
    private TextView textCancelDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_story_date);

        dateShow = (TextView) findViewById(R.id.textDateShow);
        buttonDate = (Button) findViewById(R.id.buttonDatePick);
        textAddBar = (TextView) findViewById(R.id.textAddTimeStory);
        textDateSelect = (TextView) findViewById(R.id.textDateSelect);
        textCha = (TextView) findViewById(R.id.textCha);
        textStoryTime = (TextView) findViewById(R.id.textStoryTime);
        textSaveDate = (TextView) findViewById(R.id.textSaveDate);
        textCancelDate = (TextView) findViewById(R.id.textCancelDate);

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
        startActivity(intent);
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
            dateShow.setText(String.valueOf(dayOfMonth) + " " + listMonth[month] + " " + String.valueOf(year));
            dateShow.setVisibility(View.VISIBLE);
            buttonDate.setVisibility(View.GONE);
        }
    }

    public void buttonAddIcon (View view){

    }

}