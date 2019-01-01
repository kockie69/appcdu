package com.example.appcdu;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by kockr on 3-5-2015.
 */
public class AboutActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new AboutFragment()).commit();
    }

    @Override
    public void onBackPressed() {

        System.out.println("Back gedrukt vanuit about");
        // Otherwise defer to system default behavior.
        super.onBackPressed();
    }
}
