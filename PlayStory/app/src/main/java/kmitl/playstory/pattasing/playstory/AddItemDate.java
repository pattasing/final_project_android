package kmitl.playstory.pattasing.playstory;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;

import java.util.Calendar;

public class AddItemDate extends AppCompatActivity {

    private TextView textTime;
    protected static TextView textPickTime;
    private TextView textMessage;
    private EditText editMessage;
    private Button buttonPickTime;
    private TextView textLocation;
    private TextView textPickLocation;
    private Button buttonLocation;
    private TextView textIconTime;
    private TextView textAddTimeStory2;
    private TextView textSaveTime;
    private TextView textCancelTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_date);

        textTime = (TextView) findViewById(R.id.textViewTime);
        textPickTime = (TextView) findViewById(R.id.textTimePick);
        textMessage = (TextView) findViewById(R.id.textViewMessage);
        editMessage = (EditText) findViewById(R.id.editTextMessage);
        buttonPickTime = (Button) findViewById(R.id.buttonTimePick);
        textLocation = (TextView) findViewById(R.id.textLocation);
        textPickLocation = (TextView) findViewById(R.id.textLocationPick);
        buttonLocation = (Button) findViewById(R.id.buttonMapPick);
        textIconTime = (TextView) findViewById(R.id.textViewIcon);
        textAddTimeStory2 = (TextView) findViewById(R.id.textAddTimeStory2);
        textSaveTime = (TextView) findViewById(R.id.textSaveTime);
        textCancelTime = (TextView) findViewById(R.id.textCancelTime);

        Typeface font = Typeface.createFromAsset(getAssets(), "waffle_regular.otf");

        textTime.setTypeface(font);
        textPickTime.setTypeface(font);
        textMessage.setTypeface(font);
        editMessage.setTypeface(font);
        buttonPickTime.setTypeface(font);
        textLocation.setTypeface(font);
        textPickLocation.setTypeface(font);
        buttonLocation.setTypeface(font);
        textIconTime.setTypeface(font);
        textAddTimeStory2.setTypeface(font);
        textSaveTime.setTypeface(font);
        textCancelTime.setTypeface(font);
    }

    public void buttonTimePick(View view) {
        TimePickerFragment mTimePicker = new TimePickerFragment();
        mTimePicker.show(getFragmentManager(), "Select time");
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            String hourS = String.valueOf(hourOfDay);
            String minuteS = String.valueOf(minute);

            if(hourS.length() == 1 && minuteS.length() == 1) {
                textPickTime.setText("0" + String.valueOf(hourOfDay) + " : " + "0" + String.valueOf(minute));
            }
            else if(hourS.length() > 1 && minuteS.length() == 1){
                textPickTime.setText(String.valueOf(hourOfDay) + " : " +" 0" + String.valueOf(minute));
            }
            else if(hourS.length() == 1 && minuteS.length() > 1){
                textPickTime.setText("0" + String.valueOf(hourOfDay) + " : " + String.valueOf(minute));
            }
            else{
                textPickTime.setText(String.valueOf(hourOfDay) + " : " + String.valueOf(minute));
            }
        }
    }
}