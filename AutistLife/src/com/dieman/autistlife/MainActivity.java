package com.dieman.autistlife;

import android.support.v7.app.ActionBarActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

	//Anuj Kumar Singh
	
	MyReceiver myReceiver=null;
	Intent i;
	static final String LOG_TAG = "ServiceActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timer = new Thread(){
        	public void run()
            {
        		try
        		{
        			sleep(2000);
        		}
        		catch(InterruptedException e)
        		{
        			e.printStackTrace();
        		}
        		finally
        		{
        			Intent openCategories = new Intent("com.diemen.autistlife.CATEGORIES");
        			startActivity(openCategories);
        		}
            }
        	
        };
        timer.start();
        i= new Intent(this, com.dieman.autistlife.TheService.class);
        
    }
    
    @Override
    protected void onPause()
   {
//    	super.onPause();
//         stopService(i);
//
//         if (myReceiver != null)unregisterReceiver(myReceiver);      
//    	finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override 
    public void onResume(){
        super.onResume();
        Log.d( LOG_TAG, "onResume/registering receiver" );  
        //Register BroadcastReceiver to receive accelerometer data from service
        //if (myReceiver == null){
            myReceiver = new MyReceiver();
            IntentFilter intentFilter = new IntentFilter();      
            intentFilter.addAction(TheService.MY_ACTION);
            startService(i);  
            registerReceiver(myReceiver, intentFilter);
        //}     
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d( LOG_TAG, "onStop" );
        if (myReceiver != null) unregisterReceiver (myReceiver);
        stopService(i);
    }
    
    private class MyReceiver extends BroadcastReceiver{
        static final String Log_Tag = "MyReceiver";
        @Override
        public void onReceive(Context arg0, Intent arg1){
            Log.d( LOG_TAG, "onReceive" );
            String measurement = arg1.getStringExtra("measurement");        
            System.out.println("I am here");
        }
        
		}
    
    
}
