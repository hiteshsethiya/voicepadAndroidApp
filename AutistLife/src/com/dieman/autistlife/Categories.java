package com.dieman.autistlife;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class Categories extends Activity{

	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.categories);

	    GridView gridview = (GridView) findViewById(R.id.category_gridview);
	    gridview.setAdapter(new ImageAdapter(getApplicationContext()));
	    
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(Categories.this, "WTF" + position, Toast.LENGTH_SHORT).show();
	            
	            Intent toIntent = new Intent("com.diemen.autistlife.CATEGORIES");
	            
	            switch(position)
	            {
	            case 1:
	            }
	        }
	    });
	    
	}
	
}
