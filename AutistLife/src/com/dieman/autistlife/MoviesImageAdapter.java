package com.dieman.autistlife;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MoviesImageAdapter extends BaseAdapter{

private Context mContext;
	
	public MoviesImageAdapter(Context c) {
        mContext = c;
    }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		
		if(convertView == null)
		{
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(80,80));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(5, 5, 5, 5);
		}
		else
		{
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}


	private Integer[] mThumbIds = {
			R.drawable.mrbean,
			R.drawable.rapunzelomovie,R.drawable.spiderman,
            R.drawable.batmanmovie,
            R.drawable.superman,
            R.drawable.tomjerry,
            R.drawable.chachaandfamily
            
    };
}
