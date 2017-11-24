package kmitl.playstory.pattasing.playstory;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView textName;
    private TextView textHi;
    private TextView textDate;
    private TextView textMyStory;
    private ImageView imageProfile;
    private ImageView imageAdd;
    private Button buttonLogout;

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
            Glide.with(this).load(photoUrl).into(imageProfile);

        } else{
            goLoginScreen();
        }

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
        startActivity(intent);
    }
}
