package com.example.program7;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.app.Service;
import android.widget.Toast;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import androidx.core.app.NotificationCompat;
public class MyService extends Service {
    boolean isRunning = false;
    MyThread thread;
    @Override
    public void onCreate() {
        super.onCreate();
        isRunning = true;
        Toast.makeText(getBaseContext(),"Service Created", Toast.LENGTH_SHORT).show();
        thread = new MyThread();
        thread.start();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Toast.makeText(getBaseContext(),"Service Started", Toast.LENGTH_SHORT).show();
        Bundle b = intent.getExtras();
        isRunning = b.getBoolean("isStart");
        if(!thread.isAlive()) {
            thread = new MyThread();
            thread.start();
        }
        return Service.START_NOT_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy() {
        isRunning = false;
        Toast.makeText(getBaseContext(),"Service Stopped", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
    Handler hand = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder=new NotificationCompat.Builder(getBaseContext());
            builder.setContentTitle("From Service");
            builder.setContentText("Hi! " + msg.what);
            builder.setSmallIcon(R.drawable.ic_launcher_foreground);
            builder.setContentIntent(PendingIntent.getActivity(getBaseContext(), 1, new Intent(getBaseContext(),MainActivity.class),Intent.FILL_IN_ACTION));
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("1", "MyChannel", NotificationManager.IMPORTANCE_HIGH);
                manager.createNotificationChannel(channel);
                builder.setChannelId("1");
            }
            manager.notify(1, builder.build());
        }
    };
    private class MyThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (isRunning){
                try {
                    Thread.sleep(5000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                hand.sendEmptyMessage(i++);
            }
        }
    }
}