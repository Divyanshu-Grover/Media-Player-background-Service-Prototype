package com.example.divyanshu.project1demo;

import android.app.Service;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.content.Intent;
import android.widget.Toast;

public class divService extends Service {
    MediaPlayer mp;
    public IBinder onBind(Intent arg)
    {
        return null;
    }
public void onStart(Intent intent,int startId)
{
    super.onStart(intent,startId);
    Toast.makeText(this, "Service Started",Toast.LENGTH_LONG).show();
    mp.start();
}

public void onCreate(){
    super.onCreate();
    mp = MediaPlayer.create(this,R.raw.justadream);
}

public void onDestroy(){
    super.onDestroy();
    Toast.makeText(this, "Service Stopped",Toast.LENGTH_LONG).show();
    mp.stop();
}



}
