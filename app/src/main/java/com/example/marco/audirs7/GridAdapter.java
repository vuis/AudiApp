package com.example.marco.audirs7;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.marco.audirs7.R;

public class GridAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.rs3,
            R.drawable.rs31,
            R.drawable.rs32,
            R.drawable.rs5,
            R.drawable.rs51,
            R.drawable.rs52,
            R.drawable.rs6,
            R.drawable.rs61,
            R.drawable.rs62,
            R.drawable.rs7,
            R.drawable.rs71,
            R.drawable.rs72,
            R.drawable.rsq3,
            R.drawable.rsq31,
            R.drawable.rsq32


    };

    // Constructor
    public GridAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(450, 450));
        return imageView;
    }

}