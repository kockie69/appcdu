package com.example.appcdu;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Light extends Activity {
    public static int targetExecMarginLeft;
    public static int targetExecMarginTop;
    public static int targetMsgMarginLeft;
    public static int targetMsgMarginTop;
    public static int targetDspyMarginLeft;
    public static int targetDspyMarginTop;
    public static int targetFailMarginLeft;
    public static int targetFailMarginTop;
    public static int targetOfstMarginLeft;
    public static int targetOfstMarginTop;
    public int lightsCdu;
    public boolean blankTime=true;
    private int lightValueBuffer=0;



    public void setMargins(int tEML, int tEMT, int tMML, int tMMT,int tDML,int tDMT,int tFML,int tFMT,int tOML,int tOMT) {
        targetExecMarginLeft = tEML;
        targetExecMarginTop = tEMT;
        targetMsgMarginLeft = tMML;
        targetMsgMarginTop = tMMT;
        targetDspyMarginLeft = tDML;
        targetDspyMarginTop = tDMT;
        targetFailMarginLeft = tFML;
        targetFailMarginTop = tFMT;
        targetOfstMarginLeft = tOML;
        targetOfstMarginTop = tOMT;
    }

    public void setCdu(String cduPos) {

        if (cduPos.equals("R")) {
            lightsCdu=88;
        } else if (cduPos.equals("C")) {
            lightsCdu=87;
        } else {
            lightsCdu=86;
        }
    }

    public void handle(Context c) {
        Context context = c;
        handle(c,lightValueBuffer);
    }

    public void clear(Context c) {
        Context context = c;
        final AppCompatActivity activity = (AppCompatActivity) context;

        MainActivity.handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView img5 = (ImageView) activity.findViewById(R.id.image_exec);
                img5.setVisibility(View.INVISIBLE);
            }
        });
        MainActivity.handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView img4 = (ImageView) activity.findViewById(R.id.image_msg);
                img4.setVisibility(View.INVISIBLE);
            }
        });
        MainActivity.handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView img3 = (ImageView) activity.findViewById(R.id.image_dspy);
                img3.setVisibility(View.INVISIBLE);
            }
        });
        MainActivity.handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView img2 = (ImageView) activity.findViewById(R.id.image_fail);
                img2.setVisibility(View.INVISIBLE);
            }
        });
        MainActivity.handler.post(new Runnable() {
            @Override
            public void run() {
                ImageView img1 = (ImageView) activity.findViewById(R.id.image_ofst);
                img1.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void handle(Context c, int l) {
            //int parseMark, String message) {

        Context context = c;
        final AppCompatActivity activity = (AppCompatActivity) context;
        int lightValue = l;



            lightValueBuffer=lightValue;
            if ((lightValue & 1) == 1) {
                System.out.println("Exec button doen");
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img5 = (ImageView) activity.findViewById(R.id.image_exec);
                        System.out.println("targetExecMarginTop " + targetExecMarginTop);

                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img5.getLayoutParams();
                        params.setMargins(targetExecMarginLeft, targetExecMarginTop, 70, 24); //substitute parameters for left, top, right, bottom
                        img5.setLayoutParams(params);

                        img5.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img5 = (ImageView) activity.findViewById(R.id.image_exec);
                        img5.setVisibility(View.INVISIBLE);
                    }
                });
            }
            if ((lightValue & 8) == 8) {
                System.out.println("Msg light doen");
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img4 = (ImageView) activity.findViewById(R.id.image_msg);
                        System.out.println("targetMsgMarginLeft " + targetMsgMarginLeft);
                        System.out.println("targetMsgMarginTop " + targetMsgMarginTop);

                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img4.getLayoutParams();
                        params.setMargins(targetMsgMarginLeft, targetMsgMarginTop, 48, 103); //substitute parameters for left, top, right, bottom
                        img4.setLayoutParams(params);

                        img4.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img4 = (ImageView) activity.findViewById(R.id.image_msg);
                        img4.setVisibility(View.INVISIBLE);
                    }
                });
            }
            if ((lightValue & 2) == 2) {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img3 = (ImageView) activity.findViewById(R.id.image_dspy);
                        System.out.println("targetDspyMarginTop " + targetDspyMarginTop);

                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img3.getLayoutParams();
                        params.setMargins(targetDspyMarginLeft, targetDspyMarginTop, 35, 100); //substitute parameters for left, top, right, bottom
                        img3.setLayoutParams(params);
                        img3.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img3 = (ImageView) activity.findViewById(R.id.image_dspy);
                        img3.setVisibility(View.INVISIBLE);
                    }
                });
            }
            if ((lightValue & 4) == 4) {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img2 = (ImageView) activity.findViewById(R.id.image_fail);
                        System.out.println("targetFailMarginTop " + targetFailMarginTop);

                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img2.getLayoutParams();
                        params.setMargins(targetFailMarginLeft, targetFailMarginTop, 48, 103); //substitute parameters for left, top, right, bottom
                        img2.setLayoutParams(params);

                        img2.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img2 = (ImageView) activity.findViewById(R.id.image_fail);
                        img2.setVisibility(View.INVISIBLE);
                    }
                });
            }
            if ((lightValue & 16) == 16) {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img1 = (ImageView) activity.findViewById(R.id.image_ofst);
                        System.out.println("targetOfstMarginTop " + targetOfstMarginTop);

                        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img1.getLayoutParams();
                        params.setMargins(targetOfstMarginLeft, targetOfstMarginTop, 48, 103); //substitute parameters for left, top, right, bottom
                        img1.setLayoutParams(params);

                        img1.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img1 = (ImageView) activity.findViewById(R.id.image_ofst);
                        img1.setVisibility(View.INVISIBLE);
                    }
                });

            }
            if ((lightValue & 8192) == 8192) {
                MainActivity.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ImageView img1 = (ImageView) activity.findViewById(R.id.image_ofst);
                        ImageView img2 = (ImageView) activity.findViewById(R.id.image_fail);
                        ImageView img3 = (ImageView) activity.findViewById(R.id.image_dspy);
                        ImageView img4 = (ImageView) activity.findViewById(R.id.image_msg);
                        ImageView img5 = (ImageView) activity.findViewById(R.id.image_exec);

                        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) img1.getLayoutParams();
                        params1.setMargins(targetOfstMarginLeft, targetOfstMarginTop, 48, 103); //substitute parameters for left, top, right, bottom
                        img1.setLayoutParams(params1);

                        img1.setVisibility(View.VISIBLE);

                        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) img2.getLayoutParams();
                        params2.setMargins(targetFailMarginLeft, targetFailMarginTop, 48, 103); //substitute parameters for left, top, right, bottom
                        img2.setLayoutParams(params2);

                        img2.setVisibility(View.VISIBLE);

                        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) img3.getLayoutParams();
                        params3.setMargins(targetDspyMarginLeft, targetDspyMarginTop, 35, 100); //substitute parameters for left, top, right, bottom
                        img3.setLayoutParams(params3);
                        img3.setVisibility(View.VISIBLE);

                        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) img4.getLayoutParams();
                        params4.setMargins(targetMsgMarginLeft, targetMsgMarginTop, 48, 103); //substitute parameters for left, top, right, bottom
                        img4.setLayoutParams(params4);

                        img4.setVisibility(View.VISIBLE);

                        RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) img5.getLayoutParams();
                        params5.setMargins(targetExecMarginLeft, targetExecMarginTop, 70, 24); //substitute parameters for left, top, right, bottom
                        img5.setLayoutParams(params5);

                        img5.setVisibility(View.VISIBLE);
                    }
                });


        }
    }
}
