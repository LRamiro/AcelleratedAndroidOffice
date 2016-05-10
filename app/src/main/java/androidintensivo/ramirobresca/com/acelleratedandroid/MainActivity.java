package androidintensivo.ramirobresca.com.acelleratedandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button dateButton;
    Button editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LIFECYCE","on Create Start");
        dateButton = (Button) findViewById(R.id.dateButton);
        dateButton.setOnClickListener(this);
        editText = (Button) findViewById(R.id.editTextButton);
        editText.setOnClickListener(this);
    }
    public void onClick(View pulssed_control){
        if(pulssed_control == dateButton){
            SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm:ss:mmm");
            Date currentDate = Calendar.getInstance().getTime();
            String s = formatDate.format(currentDate);
            dateButton.findViewById(R.id.dateButton);
            dateButton.setText(s);
        }
        else {
            lanzarNuevaActividad(editText);
        }
    }
    public void lanzarNuevaActividad(View v){
        Intent i = new Intent(this, TextEdit.class);
        startActivity(i);
    }
    public void choosePhoto(View view){
        Intent intentToExchangeInfoBetweenActivity = new Intent(this, ChoosePhotoActivity.class);
        startActivity(intentToExchangeInfoBetweenActivity);
    }

    //This methos is invocated for the botton's exercise 6(timer button)
    public void timerActivity(View v){
        Intent intentToStartTheTimers = new Intent(this, StartedTimersActivity.class);
        startActivity(intentToStartTheTimers);
    }

}

