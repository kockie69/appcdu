package com.example.appcdu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


/**
 * Created by KockR on 18-4-2015.
 */
public class Screen extends Activity {
    Typeface typeFaceL;
    Typeface typeFaceS;
    private SpannableStringBuilder line1 = new SpannableStringBuilder("");
    private SpannableStringBuilder line2 = new SpannableStringBuilder("");
    private SpannableStringBuilder line3 = new SpannableStringBuilder("");
    private SpannableStringBuilder line4 = new SpannableStringBuilder("");
    private SpannableStringBuilder line5 = new SpannableStringBuilder("");
    private SpannableStringBuilder line6 = new SpannableStringBuilder("");
    private SpannableStringBuilder line7 = new SpannableStringBuilder("");
    private SpannableStringBuilder line8 = new SpannableStringBuilder("");
    private SpannableStringBuilder line9 = new SpannableStringBuilder("");
    private SpannableStringBuilder line10 = new SpannableStringBuilder("");
    private SpannableStringBuilder line11 = new SpannableStringBuilder("");
    private SpannableStringBuilder line12 = new SpannableStringBuilder("");
    private SpannableStringBuilder line13 = new SpannableStringBuilder("");
    private SpannableStringBuilder line14 = new SpannableStringBuilder("");
    public int targetLeftMargin;
    public int targetTopMargin;
    public int targetFontSize;
    public int lineMargin;
    public int cduLine;
    public boolean blankTime = true;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    Screen(Typeface tFL, Typeface tFS) {
        typeFaceL = tFL;
        typeFaceS = tFS;
    }

    public void setMargins(int tLM, int tTM, int tFS, int lM) {
        targetLeftMargin = tLM;
        targetTopMargin = tTM;
        targetFontSize = tFS;
        lineMargin = lM;
    }

    public void setScreenCdu(String cduPos) {

        if (cduPos.equals("R")) {
            cduLine = 90;
        } else if (cduPos.equals("C")) {
            cduLine = 76;
        } else {
            cduLine = 62;
        }
    }

    public void drawLine(AppCompatActivity act, SpannableStringBuilder ss, int tvLine, int tvLineA, int m) {

        final SpannableStringBuilder styledString = ss;
        final AppCompatActivity activity = act;
        final int tView = tvLine;
        final int tViewA = tvLineA;
        final int margin = m;

        if (styledString.length() > 0) {
            MainActivity.handler.post(new Runnable() {
                @Override
                public void run() {

                    TextView tv = (TextView) activity.findViewById(tView);
                    tv.setLineSpacing(margin, 3);
        //            tv.setLeft(targetLeftMargin);
                    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

                    params1.setMargins(targetLeftMargin, margin, 0, 0);  // left, top, right, bottom
                    tv.setLayoutParams(params1);
                    tv.setTextSize(targetFontSize);
                    tv.setText(styledString);

                    TextView tva = (TextView) activity.findViewById(tViewA);
                    tva.setLineSpacing(margin, 1);
                    //tva.setLeft(targetLeftMargin + 1);
                    params1.setMargins(targetLeftMargin+1, margin, 0, 0);  // left, top, right, bottom
                    tva.setLayoutParams(params1);
                    tva.setTextSize(targetFontSize);
                    tva.setText(styledString);

                }
            });
        } else {
            MainActivity.handler.post(new Runnable() {
                @Override
                public void run() {

                    TextView tv = (TextView) activity.findViewById(tView);
                    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

                    params1.setMargins(targetLeftMargin, margin, 0, 0);  // left, top, right, bottom

                    tv.setLayoutParams(params1);
                    tv.setLineSpacing(margin, 1);
    //                tv.setLeft(targetLeftMargin);
                    tv.setTextSize(targetFontSize);
                    tv.setText("");

                    TextView tva = (TextView) activity.findViewById(tViewA);
                    params1.setMargins(targetLeftMargin+1, margin, 0, 0);  // left, top, right, bottom

                    tva.setLayoutParams(params1);
                    tva.setLineSpacing(margin, 1);
   //                 tva.setLeft(targetLeftMargin + 1);
                    tva.setTextSize(targetFontSize);
                    tva.setText("");
                }
            });
        }
    }

    public void redraw(Context context) {
        final AppCompatActivity activity = (AppCompatActivity) context;

        drawLine(activity, line1, R.id.textView1, R.id.textView1a, lineMargin);
        drawLine(activity, line2, R.id.textView2, R.id.textView2a, lineMargin);
        drawLine(activity, line3, R.id.textView3, R.id.textView3a, lineMargin);
        drawLine(activity, line4, R.id.textView4, R.id.textView4a, lineMargin);
        drawLine(activity, line5, R.id.textView5, R.id.textView5a, lineMargin);
        drawLine(activity, line6, R.id.textView6, R.id.textView6a, lineMargin);
        drawLine(activity, line7, R.id.textView7, R.id.textView7a, lineMargin);
        drawLine(activity, line8, R.id.textView8, R.id.textView8a, lineMargin);
        drawLine(activity, line9, R.id.textView9, R.id.textView9a, lineMargin);
        drawLine(activity, line10, R.id.textView10, R.id.textView10a, lineMargin);
        drawLine(activity, line11, R.id.textView11, R.id.textView11a, lineMargin);
        drawLine(activity, line12, R.id.textView12, R.id.textView12a, lineMargin);
        drawLine(activity, line13, R.id.textView13, R.id.textView13a, lineMargin);
        drawLine(activity, line14, R.id.textView14, R.id.textView14a, lineMargin);


    }


    public void draw(int qIndex, int parseMark, String message, Context context) {

        final AppCompatActivity activity = (AppCompatActivity) context;
        final SpannableStringBuilder styledString;
        char fontType = 'U';
        char[] styleText;
        char style;
        int theLength;
        int endSpan;

        String theText;

//        if (!blankTime) {
        theLength = message.length();
        if (theLength < parseMark + 24) {
            theText = message.substring(parseMark, theLength);
        } else theText = message.substring(parseMark, parseMark + 24);
        theText = theText.replace('_', ' ');
        theText = theText.replace('b', '_');
        theText = theText.replace('o', 'g');
        System.out.println(theText);
        styledString = new SpannableStringBuilder(theText);
        if (theText.length() == 0) {
            endSpan = 0;
        } else endSpan = theText.length() - 1;

        if (((qIndex == cduLine) || (qIndex == cduLine + 2) || (qIndex == cduLine + 4) || (qIndex == cduLine + 6) || (qIndex == cduLine + 8) || (qIndex == cduLine + 10) || (qIndex == cduLine + 12) || (qIndex == cduLine + 13)) && (theLength <= parseMark + 24)) {
            fontType = 'L';
//               styledString.setSpan(new CustomTypefaceSpan("", typeFaceL), 0, theText.length(), 0);
            System.out.println(theText.length());
            styledString.setSpan(new CustomTypefaceSpan("", typeFaceL), 0, theText.length(), 0);

        } else if (((qIndex == cduLine + 1) || (qIndex == cduLine + 3) || (qIndex == cduLine + 5) || (qIndex == cduLine + 7) || (qIndex == cduLine + 9) || (qIndex == cduLine + 11)) && (theLength == parseMark + 24)) {
            fontType = 'S';
//                styledString.setSpan(new CustomTypefaceSpan("", typeFaceS), 0, theText.length(), 0);
            System.out.println(theText.length());
            styledString.setSpan(new CustomTypefaceSpan("", typeFaceS), 0, theText.length(), 0);

        } else {
            //Parse the styling at the end of the text (++++++------++++)
            styleText = message.substring(parseMark + 24, message.length()).toCharArray();
            System.out.println("Styling: " + new String(styleText));
            int count = 1;
            int start = 0;
            int length = styleText.length;
            if (styleText[0] == '+') {
                style = 'L';
            } else style = 'S';
            System.out.println("Lengte: " + length);
            while (count < length - 1) {
                if (styleText[count] == '+') {
                    if (style == 'S') {
                        styledString.setSpan(new CustomTypefaceSpan("", typeFaceS), start, count, 0);
                        System.out.println("Start: " + start);
                        System.out.println("End: " + count);
                        start = count;
                        style = 'L';
                        System.out.println("StoL at: " + count);
                    }
                } else {
                    if (style == 'L') {
                        styledString.setSpan(new CustomTypefaceSpan("", typeFaceL), start, count, 0);
                        System.out.println("Start: " + start);
                        System.out.println("End: " + count);
                        start = count;
                        style = 'S';
                        System.out.println("LtoS at: " + count);
                    }
                }
                count++;
            }
            if (style == 'S') {
                System.out.println("Start: " + start);
                System.out.println("End: " + theText.length());
                styledString.setSpan(new CustomTypefaceSpan("", typeFaceS), start, theText.length(), 0);
//                    styledString.setSpan(new CustomTypefaceSpan("", typeFaceS), start, endSpan, 0);

            } else {
                if (style == 'L') {
                    System.out.println("Start: " + start);
                    System.out.println("End: " + theText.length());
                    styledString.setSpan(new CustomTypefaceSpan("", typeFaceL), start, theText.length(), 0);
//                        styledString.setSpan(new CustomTypefaceSpan("", typeFaceL), start, endSpan, 0);

                }
            }
        }


        if (qIndex == cduLine) {
            line1 = styledString;
            drawLine(activity, styledString, R.id.textView1, R.id.textView1a, targetTopMargin);
        } else if (qIndex == cduLine + 1) {
            line2 = styledString;
            drawLine(activity, styledString, R.id.textView2, R.id.textView2a, targetTopMargin+targetFontSize+lineMargin);
        } else if (qIndex == cduLine + 2) {
            line3 = styledString;
            drawLine(activity, styledString, R.id.textView3, R.id.textView3a, targetTopMargin+2*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 3) {
            line4 = styledString;
            drawLine(activity, styledString, R.id.textView4, R.id.textView4a, targetTopMargin+3*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 4) {
            line5 = styledString;
            drawLine(activity, styledString, R.id.textView5, R.id.textView5a, targetTopMargin+4*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 5) {
            line6 = styledString;
            drawLine(activity, styledString, R.id.textView6, R.id.textView6a, targetTopMargin+5*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 6) {
            line7 = styledString;
            drawLine(activity, styledString, R.id.textView7, R.id.textView7a, targetTopMargin+6*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 7) {
            line8 = styledString;
            drawLine(activity, styledString, R.id.textView8, R.id.textView8a, targetTopMargin+7*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 8) {
            line9 = styledString;
            drawLine(activity, styledString, R.id.textView9, R.id.textView9a, targetTopMargin+8*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 9) {
            line10 = styledString;
            drawLine(activity, styledString, R.id.textView10, R.id.textView10a, targetTopMargin+9*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 10) {
            line11 = styledString;
            drawLine(activity, styledString, R.id.textView11, R.id.textView11a, targetTopMargin+10*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 11) {
            line12 = styledString;
            drawLine(activity, styledString, R.id.textView12, R.id.textView12a, targetTopMargin+11*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 12) {
            line13 = styledString;
            drawLine(activity, styledString, R.id.textView13, R.id.textView13a, targetTopMargin+12*(targetFontSize+lineMargin));
        } else if (qIndex == cduLine + 13) {
            line14 = styledString;
            drawLine(activity, styledString, R.id.textView14, R.id.textView14a, targetTopMargin+13*(targetFontSize+lineMargin));
        }
        //       }
    }


    public void clear(Context context) {

        final AppCompatActivity activity = (AppCompatActivity) context;
        SpannableStringBuilder styledString = new SpannableStringBuilder("");

        drawLine(activity, styledString, R.id.textView1, R.id.textView1a, targetTopMargin);
        drawLine(activity, styledString, R.id.textView2, R.id.textView2a, lineMargin);
        drawLine(activity, styledString, R.id.textView3, R.id.textView3a, lineMargin);
        drawLine(activity, styledString, R.id.textView4, R.id.textView4a, lineMargin);
        drawLine(activity, styledString, R.id.textView5, R.id.textView5a, lineMargin);
        drawLine(activity, styledString, R.id.textView6, R.id.textView6a, lineMargin);
        drawLine(activity, styledString, R.id.textView7, R.id.textView7a, lineMargin);
        drawLine(activity, styledString, R.id.textView8, R.id.textView8a, lineMargin);
        drawLine(activity, styledString, R.id.textView9, R.id.textView9a, lineMargin);
        drawLine(activity, styledString, R.id.textView10, R.id.textView10a, lineMargin);
        drawLine(activity, styledString, R.id.textView11, R.id.textView11a, lineMargin);
        drawLine(activity, styledString, R.id.textView12, R.id.textView12a, lineMargin);
        drawLine(activity, styledString, R.id.textView13, R.id.textView13a, lineMargin);
        drawLine(activity, styledString, R.id.textView14, R.id.textView14a, lineMargin);
   /* else if (qIndex==89) {
                                                    handler.post(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                        tv1.setText("");
                                                        tv2.setText("");
                                                        tv3.setText("");
                                                        tv4.setText("");
                                                        tv5.setText("");
                                                        tv6.setText("");
                                                        tv7.setText("");
                                                        tv8.setText("");
                                                        tv9.setText("");
                                                        tv10.setText("");
                                                        tv11.setText("");
                                                        tv12.setText("");
                                                        tv13.setText("");
                                                        tv14.setText("");
                                                    }
                                                });
                                            } */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Screen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.appcdu/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Screen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.appcdu/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
