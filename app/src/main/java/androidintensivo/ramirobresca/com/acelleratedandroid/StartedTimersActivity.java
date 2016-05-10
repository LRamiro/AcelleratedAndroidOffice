package androidintensivo.ramirobresca.com.acelleratedandroid;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
public class StartedTimersActivity extends AppCompatActivity {
    //Define the variable that controll the on/off timer
    boolean activityTimer = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_timers);
    }
    //This method is invocated by Init Thread button(@+id/initThreadButton)
    public void throwTimer(View view){
        activityTimer = true;
        //This variable is to format the date showed in textField
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss:mmm");
        Date time = Calendar.getInstance().getTime();
        //This variable is a thread
        Thread t = new Thread();
        //This variables is to controll the time
        int second = 0;
        int minute = 0;
        int hour = 0;
        String timeToShow;
        while(activityTimer) {
            try {
                t.sleep(1000);
                second += 1;
                if (second > 59) {
                    minute += 1;
                    second = 0;
                    if (minute > 59) {
                        hour += 1;
                    }
                }
                long timeInMill;
                timeInMill = (second * 1000) + (minute * 60) * 1000 + (hour * 360) * 1000;
                time.setTime(timeInMill);

                timeToShow = formatTime.format(time);
                System.out.println(timeToShow);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Now, we define a thread
        /*new Thread(new Runnable() {
            @Override
            public void run() {
            }
        }).start();*/
    }
    //This method is invocated by Stop button(@+id/stopThreadButton)
    public void stopTimer(View view){
    }
}
