package com.example.cfamilycontact;

  
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
  		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
              Window window = getWindow();
               window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS|WindowManager.LayoutParams.FLAG_FULLSCREEN );
                    }else {
                    	   Window window = getWindow();
                           window.addFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN );
              			     
              	 
  			             } 
        setContentView(R.layout.activity_main);
      
          new Handler().postDelayed(new Runnable() {
  			
  			@Override
  			public void run() {
  				  Intent in=new Intent(MainActivity.this,LoginActivity.class);
   			      startActivity(in);
   				  finish();
  			}
  		}, 2500);
   }
}
