package com.dieman.autistlife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Movies extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.movies);
		 
		 GridView moviesGV = (GridView)findViewById(R.id.movies_gridView);
		 moviesGV.setAdapter(new MoviesImageAdapter(getApplicationContext()));
		 
		 moviesGV.setOnItemClickListener(new OnItemClickListener() {
		        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		            
		        	Toast.makeText(Movies.this, "Hey! We'll Update this Soon.", Toast.LENGTH_SHORT).show();
		        }
		    });
		    

	}

	
}
