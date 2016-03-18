package com.kroid.bcmc;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		Handler handler;
		Runnable delayRunnable;

		handler = new Handler();
		delayRunnable = new Runnable() {

		     @Override
		     public void run() {
		    // TODO Auto-generated method stub  

		           //Add your intent here for Second Activity
		           Intent i = new Intent(MainActivity.this,WorkZone_K3.class);
		             startActivity(i);
		             finish();
		    }
		};      
		handler.postDelayed(delayRunnable, 3000);
	}

}
