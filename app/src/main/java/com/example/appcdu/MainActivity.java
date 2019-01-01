package com.example.appcdu;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Handler handler = new Handler();
    public static Keyboard keyBoard = new Keyboard();
    public static Screen screen;
    public static Light light;
    public static Context context;
    public static Context activity;
    public static String id="Unknown";
    public static String version="Unknown";
public static Settings settings;

    public NetThread netThread=null;

    public static boolean restartNetThread = false;
    public static boolean reloadPrefs = false;
    public static boolean firstTime = true;

    public Boolean CLRPressed=false;
    public Boolean ATCPressed=false;

    public MainActivity() {
    }

    //@Override
    //public void onDestroy() {
    //    netThread.sendToServer("exit");
    //}

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Typeface typeFaceL = Typeface.createFromAsset(getAssets(), "fonts/awnxfmcl_fans05.ttf");
        Typeface typeFaceS = Typeface.createFromAsset(getAssets(), "fonts/AWNXFMCS_FANS05.TTF");

        screen = new Screen(typeFaceL,typeFaceS);
        light = new Light();

        context = getApplicationContext();
        Settings settings = new Settings(context);
        settings.loadPref();

        // final RelativeLayout relativeLayout = new RelativeLayout(activity);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.my_frame);

 //       relativeLayout.setLayoutParams();
 //       FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        params1.setMargins(settings.targetLeftMargin, settings.targetTopMargin, 0, 0);  // left, top, right, bottom

 //       relativeLayout.setLayoutParams(params1);
        setContentView(relativeLayout,params1);

        screen.setScreenCdu(settings.cduPos);
        screen.setMargins(settings.targetLeftMargin,settings.targetTopMargin,settings.targetFontSize,settings.lineMargin);

        light.setMargins(settings.targetExecMarginLeft,settings.targetExecMarginTop,settings.targetMsgMarginLeft,settings.targetMsgMarginTop,settings.targetDspyMarginLeft,settings.targetDspyMarginTop,settings.targetFailMarginLeft,settings.targetFailMarginTop,settings.targetOfstMarginLeft,settings.targetOfstMarginTop);
        light.setCdu(settings.cduPos);


        keyBoard.setKeybCdu(settings.cduPos);

        activity = MainActivity.this;

        if (netThread == null){
            netThread = new NetThread(settings.host,settings.port,activity);
            netThread.start();
        } else
        {
            System.out.println("NetThread not null");
        }




    };
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
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SettingsActivity.class);
            startActivityForResult(intent, 0);
            return true;
        }
        if (id == R.id.action_about) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onTouchEvent(MotionEvent event) {
        String message;

        ImageView iv = (ImageView) findViewById(R.id.image_areas);
        message = keyBoard.getMessage(event,CLRPressed, ATCPressed, iv);

        Log.e("Message", message);
        netThread.sendToServer(message);

        return super.onTouchEvent(event);
    }


}


