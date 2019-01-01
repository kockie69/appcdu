package com.example.appcdu;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KockR on 18-4-2015.
 */
public class Keyboard {

    private String keybCdu;

    Keyboard() {
    }

    public void setKeybCdu(String cduPos) {

        if (cduPos.equals("R")) {
            keybCdu = "Qh403";
        } else if (cduPos.equals("C")) {
            keybCdu = "Qh402";
        } else {
            keybCdu = "Qh401";
        }
    }

    public String getMessage(MotionEvent event, boolean CLRPressed, boolean ATCPressed,ImageView iv) {
        String message="";

        if (event.getAction() != MotionEvent.ACTION_DOWN) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                message = keybCdu+"=-1";
            }
        } else {
            // Get the colour of the clicked coordinates
            // And yes, I spell it coloUr.

            int x = (int) event.getX();
            int y = (int) event.getY();
            Map<Integer, String> colorMap = new HashMap<Integer, String>();
            colorMap.put(-3014655, keybCdu + "=0");
            colorMap.put(-990032, keybCdu + "=1");
            colorMap.put(-4987365, keybCdu + "=2");
            colorMap.put(-6759704, keybCdu + "=3");
            colorMap.put(-102, keybCdu + "=4");
            colorMap.put(-3620633, keybCdu + "=5");
            colorMap.put(-12845056, keybCdu + "=6");
            colorMap.put(-10878976, keybCdu + "=7");
            colorMap.put(-24679, keybCdu + "=8");
            colorMap.put(-6191318, keybCdu + "=9");
            colorMap.put(-16761856, keybCdu + "=10");
            colorMap.put(-16754176, keybCdu + "=11");
            colorMap.put(-16746751, keybCdu + "=12");
            colorMap.put(-16738816, keybCdu + "=13");
            colorMap.put(-16665599, keybCdu + "=14");
            colorMap.put(-16592384, keybCdu + "=15");
            colorMap.put(-16715520, keybCdu + "=16");
            colorMap.put(-16776929, keybCdu + "=17");
            colorMap.put(-16777156, keybCdu + "=18");
            colorMap.put(-16777126, keybCdu + "=19");
            colorMap.put(-16777096, keybCdu + "=20");
            colorMap.put(-16777066, keybCdu + "=21");
            colorMap.put(-16776780, keybCdu + "=22");
            colorMap.put(-16777006, keybCdu + "=23");
            colorMap.put(-16711439, keybCdu + "=24");
            colorMap.put(-16769296, keybCdu + "=25");
            colorMap.put(-16761360, keybCdu + "=26");
            colorMap.put(-16753937, keybCdu + "=27");
            colorMap.put(-16746254, keybCdu + "=28");
            colorMap.put(-6185319, keybCdu + "=29");
            colorMap.put(-13457240, keybCdu + "=30");
            colorMap.put(-16722959, keybCdu + "=31");
            colorMap.put(-16649744, keybCdu + "=32");
            colorMap.put(-14745359, keybCdu + "=33");
            colorMap.put(-12779279, keybCdu + "=34");
            colorMap.put(-10878479, keybCdu + "=35");
            colorMap.put(-8912399, keybCdu + "=36");
            colorMap.put(-6946319, keybCdu + "=37");
            colorMap.put(-4849168, keybCdu + "=38");
            colorMap.put(-2883342, keybCdu + "=39");
            colorMap.put(-14811136, keybCdu + "=40");
            colorMap.put(-1040655, keybCdu + "=41");
            colorMap.put(-1098512, keybCdu + "=42");
            colorMap.put(-1025295, keybCdu + "=43");
            colorMap.put(-1083154, keybCdu + "=44");
            colorMap.put(-1009936, keybCdu + "=45");
            colorMap.put(-1002256, keybCdu + "=46");
            colorMap.put(-3947581, keybCdu + "=47");
            colorMap.put(-4752553, keybCdu + "=48");
            colorMap.put(-86327, keybCdu + "=49");
            colorMap.put(-144883, keybCdu + "=50");
            colorMap.put(-994319, keybCdu + "=51");
            colorMap.put(-986896, keybCdu + "=52");
            colorMap.put(-16649954, keybCdu + "=53");
            colorMap.put(-16650181, keybCdu + "=54");
            colorMap.put(-16715685, keybCdu + "=55");
            colorMap.put(-16715912, keybCdu + "=56");
            colorMap.put(-14438067, keybCdu + "=57");
            colorMap.put(-16777216, keybCdu + "=58");
            colorMap.put(-12630068, keybCdu + "=59");
            colorMap.put(-69120, keybCdu + "=60");
            colorMap.put(-8421505, keybCdu + "=61");
            colorMap.put(-7864298, keybCdu + "=62");
            colorMap.put(-1238236, keybCdu + "=63");
            colorMap.put(-32986, keybCdu + "=64");
            colorMap.put(-16735256, keybCdu + "=65");
            colorMap.put(-6075997, keybCdu + "=66");
            colorMap.put(-4980736, keybCdu + "=67");
            colorMap.put(-16704000, keybCdu + "=68");
//            colorMap.put(-982799, "Config");

            int touchColour = getHitboxColour(x, y, iv);
            for (Integer col : colorMap.keySet()) {
                if (closeMatch(col, touchColour)) {
                    message = colorMap.get(col);
                }
            }
            Log.e("touchColour", Integer.toString(touchColour));
            StringBuilder sb = new StringBuilder();
            sb.append("ARGB(");
            sb.append(Color.alpha(touchColour));
            sb.append(",");
            sb.append(Color.red(touchColour));
            sb.append(",");
            sb.append(Color.green(touchColour));
            sb.append(",");
            sb.append(Color.blue(touchColour));
            sb.append(")");
            Log.e("Clicked", sb.toString());
        }
        return message;
    }


    public boolean closeMatch(int color1, int color2) {

        int tolerance = 25;

        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance) {
            return false;
        }


        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance) {
            return false;
        }


        if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) > tolerance) {
            return false;
        }

        return true;
    }

    public int getHitboxColour(int x, int y, ImageView iv) {

        // Fix any offsets by the positioning of screen elements such as Activity titlebar.
        // This part was causing me issues when I was testing out Bill Lahti's code.

        Bitmap bmpHotspots;
        int pixel;
        int[] location = new int[2];

        iv.getLocationOnScreen(location);
        x -= location[0];
        y -= location[1];

        // Prevent crashes, return background noise

        if ((x < 0) || (y < 0)) {
            return Color.WHITE;
        }
        // Draw the scaled bitmap into memory

        iv.setDrawingCacheEnabled(true);
        bmpHotspots = Bitmap.createBitmap(iv.getDrawingCache());
        iv.setDrawingCacheEnabled(false);
        pixel = bmpHotspots.getPixel(x, y);
        bmpHotspots.recycle();
        return pixel;
    }
}



