package com.example.appcdu;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Settings {
    public String host;
    public Integer port;
    public String cduPos;
    public Integer targetTopMargin;
    public Integer targetLeftMargin;
    public Integer targetFontSize;
    public Integer lineMargin;
    public Integer targetMsgMarginTop;
    public Integer targetMsgMarginLeft;
    public Integer targetExecMarginTop;
    public Integer targetExecMarginLeft;
    public Integer targetDspyMarginTop;
    public Integer targetDspyMarginLeft;
    public Integer targetFailMarginTop;
    public Integer targetFailMarginLeft;
    public Integer targetOfstMarginTop;
    public Integer targetOfstMarginLeft;

    Context context;

    Settings(Context c) {
       context = c;
    }

    public void loadPref() {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        host = sharedPref.getString("host_preference", "10.10.10.10");
        port = Integer.parseInt(sharedPref.getString("port_preference", "10747"));

        cduPos = sharedPref.getString("cdu_preference", "L");

        targetTopMargin = Integer.parseInt(sharedPref.getString("TopMargin_preference", "81"));
        targetLeftMargin = Integer.parseInt(sharedPref.getString("LeftMargin_preference", "118"));
        targetFontSize = Integer.parseInt(sharedPref.getString("FontSize_preference", "39"));
        lineMargin = Integer.parseInt(sharedPref.getString("LineMargin_preference", "3"));

        //if (!sharedPref.getString("MsgMarginTop_preference", "240").equals(""))
        targetMsgMarginTop = Integer.parseInt(sharedPref.getString("MsgMarginTop_preference", "785"));
        //if (!sharedPref.getString("MsgMarginLeft_preference", "240").equals(""))
        targetMsgMarginLeft = Integer.parseInt(sharedPref.getString("MsgMarginLeft_preference", "717"));
        //if (!sharedPref.getString("ExecMarginTop_preference", "340").equals(""))
        targetExecMarginTop = Integer.parseInt(sharedPref.getString("ExecMarginTop_preference", "660"));
        // if (!sharedPref.getString("ExecMarginLeft_preference", "340").equals(""))
        targetExecMarginLeft = Integer.parseInt(sharedPref.getString("ExecMarginLeft_preference", "610"));
        //if (!sharedPref.getString("MsgMarginTop_preference", "240").equals(""))
        targetDspyMarginTop = Integer.parseInt(sharedPref.getString("DspyMarginTop_preference", "800"));
        //if (!sharedPref.getString("MsgMarginLeft_preference", "240").equals(""))
        targetDspyMarginLeft = Integer.parseInt(sharedPref.getString("DspyMarginLeft_preference", "56"));
        //if (!sharedPref.getString("ExecMarginTop_preference", "340").equals(""))
        targetFailMarginTop = Integer.parseInt(sharedPref.getString("FailMarginTop_preference", "885"));
        // if (!sharedPref.getString("ExecMarginLeft_preference", "340").equals(""))
        targetFailMarginLeft = Integer.parseInt(sharedPref.getString("FailMarginLeft_preference", "56"));
        //if (!sharedPref.getString("ExecMarginTop_preference", "340").equals(""))
        targetOfstMarginTop = Integer.parseInt(sharedPref.getString("OfstMarginTop_preference", "881"));
        // if (!sharedPref.getString("ExecMarginLeft_preference", "340").equals(""))
        targetOfstMarginLeft = Integer.parseInt(sharedPref.getString("OfstMarginLeft_preference", "719"));
    }
}
