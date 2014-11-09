package com.dieman.autistlife;
import java.util.List;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TheService extends Service implements SensorEventListener{
 final static String MY_ACTION = "MY_ACTION";
   private TextView output;
   private String reading;
   private SensorManager mgr;
   private List<Sensor> sensorList;
   static final String LOG_TAG = "SimpleService";
   Intent intent = new Intent("com.practice.SimpleService.MY_ACTION");

   @Override
   //public void onStartCommand() {
   public void onCreate() {
      Log.d( LOG_TAG, "onStartCommand" );
      mgr = (SensorManager) getSystemService(SENSOR_SERVICE);
      sensorList = mgr.getSensorList(Sensor.TYPE_ACCELEROMETER);
      for (Sensor sensor : sensorList) {
         mgr.registerListener(this, sensor,
                 SensorManager.SENSOR_DELAY_NORMAL);
      }
   }

   @Override
   public void onDestroy() {
        Log.d( LOG_TAG, "onDestroy" );
        mgr.unregisterListener(this);       
        super.onDestroy();
   }

@Override
public IBinder onBind(Intent arg0) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void onAccuracyChanged(Sensor sensor, int accuracy) {
    // TODO Auto-generated method stub      
}

@Override
public void onSensorChanged(SensorEvent event) {
      Log.d( LOG_TAG, "onSensorChanged" );
      
      MediaPlayer favsong=MediaPlayer.create(TheService.this, R.raw.testmusic);
      
    //  Toast.makeText(TheService.this,""+event.values[0], Toast.LENGTH_SHORT).show();
  //    StringBuilder builder = new StringBuilder();

      for (int i = 0; i < event.values.length; i++) {
        
    	  if(event.values[i]>3.5 && !favsong.isPlaying())
    	  {
    		  Toast.makeText(TheService.this,""+event.values[i], Toast.LENGTH_SHORT).show();
    	  favsong.start();
    	  }
    	    
      }

   //   reading=builder.toString();

      //Send back reading to Activity
     // intent.putExtra("measurement", reading);
     // sendBroadcast(intent);        
}
}