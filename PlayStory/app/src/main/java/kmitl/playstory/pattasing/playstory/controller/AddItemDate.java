package kmitl.playstory.pattasing.playstory.controller;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import java.util.Calendar;

import kmitl.playstory.pattasing.playstory.R;
import kmitl.playstory.pattasing.playstory.model.ItemTime;
import kmitl.playstory.pattasing.playstory.model.SelectIconTime;
import kmitl.playstory.pattasing.playstory.view.IconTimeListFragment;

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
    private ImageView imageAddIconTime;
    private SelectIconTime selectIconTime;

    protected static ItemTime itemTime;

    private int checkHaveIcon = 0;

    private IconTimeListFragment iconTimeListFragment;
    private FragmentManager fragmentManager;

    private final static int MY_PERMISSION_FINE_LOCATION = 101;
    private final static int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_date);

        fragmentManager = getFragmentManager();
        iconTimeListFragment = new IconTimeListFragment();

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
        imageAddIconTime = (ImageView) findViewById(R.id.imageAddIconTime);

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

        itemTime = new ItemTime();

        requestPermission();

    }

    private void requestPermission() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
            }
        }
    }

    public void buttonTimePick(View view) {
        TimePickerFragment mTimePicker = new TimePickerFragment();
        mTimePicker.show(getFragmentManager(), "Select time");
    }

    public void buttonPickMap(View view) {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            Intent intent = builder.build(AddItemDate.this);
            startActivityForResult(intent, PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    public void addIconTime(View view) {
        if(checkHaveIcon == 0){
            iconTimeListFragment.show(fragmentManager, "Icon_Tag");
        }

    }

    public void getIconTime(String imageIcon){
        selectIconTime = SelectIconTime.getSelectIconTimeInstance();
        if (selectIconTime.getUrlIcon() != null){
            Glide.with(this).load(selectIconTime.getUrlIcon()).into(imageAddIconTime);
            itemTime.setIconUrl(selectIconTime.getUrlIcon());
            checkHaveIcon = 1;
        }
    }

    public void buttonSave(View view) {
        itemTime.setMessage(editMessage.getText().toString());
        System.out.println(itemTime.getTime());
        System.out.println(itemTime.getLocation());
        System.out.println(itemTime.getMessage());
        System.out.println(itemTime.getIconUrl());

        if(itemTime.getTime() == null || itemTime.getLocation() == null ||
                itemTime.getMessage() == null || itemTime.getIconUrl() == null){
            Toast.makeText(this, "Null", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this, AddStoryDate.class);
            intent.putExtra("itemTime", itemTime.getTime());
            intent.putExtra("itemMessage", itemTime.getMessage());
            intent.putExtra("itemLocation", itemTime.getLocation());
            intent.putExtra("itemIcon", itemTime.getIconUrl());
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void buttonCancel(View view) {
        finish();
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
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
            String time;

            if (hourS.length() == 1 && minuteS.length() == 1) {
                time = "0" + String.valueOf(hourOfDay) + " : " + "0" + String.valueOf(minute);
                textPickTime.setText(time);
            } else if (hourS.length() > 1 && minuteS.length() == 1) {
                time = String.valueOf(hourOfDay) + " : " + " 0" + String.valueOf(minute);
                textPickTime.setText(time);
            } else if (hourS.length() == 1 && minuteS.length() > 1) {
                time = "0" + String.valueOf(hourOfDay) + " : " + String.valueOf(minute);
                textPickTime.setText(time);
            } else {
                time = String.valueOf(hourOfDay) + " : " + String.valueOf(minute);
                textPickTime.setText(time);
            }

            itemTime.setTime(time);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSION_FINE_LOCATION:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "This app requires location permissions to be granted", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(AddItemDate.this, data);
                textPickLocation.setText(place.getName());
                itemTime.setLocation(String.valueOf(place.getName()));
            }
        }
    }

}
