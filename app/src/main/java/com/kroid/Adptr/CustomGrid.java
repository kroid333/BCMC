package com.kroid.Adptr;
import com.kroid.bcmc.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final int[] Imageid;
    
    ImageView imageView ;
    
      public CustomGrid(Context c,int[] Imageid ) {
          mContext = c;
          this.Imageid = Imageid;
      }
    @Override
    public int getCount() {
      // TODO Auto-generated method stub
      return Imageid.length;
    }
    @Override
    public Object getItem(int position) {
      // TODO Auto-generated method stub
      return null;
    }
    @Override
    public long getItemId(int position) {
      // TODO Auto-generated method stub
      return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      // TODO Auto-generated method stub
      View grid = null;
      
      LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

      if (grid == null)
      {
        grid = new View(mContext);
        grid = inflater.inflate(R.layout.grid_single, null);
         imageView = (ImageView) grid.findViewById(R.id.grid_image);
        
      } 
      else
      {
        grid = (View) convertView;
      }
      imageView.setImageResource(Imageid[position]);
      return grid;
    }
}