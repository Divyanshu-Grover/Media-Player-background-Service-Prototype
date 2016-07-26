package com.example.divyanshu.project1demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;



public class MainActivity extends ActionBarActivity {
NotificationManager nm;
Notification notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notify = new Notification(R.drawable.ic_launcher,"div",System.currentTimeMillis());
        Intent i = new Intent(getApplicationContext(),secondActivity.class);
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(),2,i,0);
        notify.setLatestEventInfo(getApplicationContext(),"Xyz","Wait...",pi);

    }

    public void startme(View v){

        Intent i = new Intent(this,divService.class);
        startService(i);

    }

    public void stopme(View v){

        Intent i = new Intent(this,divService.class);
        stopService(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showme(View view){
       nm.notify(3,notify);

    }
}
