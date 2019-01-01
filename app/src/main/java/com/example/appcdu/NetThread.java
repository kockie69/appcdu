package com.example.appcdu;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetThread extends Thread {

    private Context context;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter ou = null;
    private boolean remoteExit;
    private String targetHost;
    private int targetPort;
    Light light;
    public NetThread netThread;

    NetThread(String host, int port, Context mContext) {
        targetHost = host;
        targetPort = port;
        context = mContext;
    }

    public void sendToServer(String s) {
        if (socket != null && s != null)
            ou.println(s);
    }

/*    void send(String s) {
        if (ou != null) {
            ou.println(s);
            if (ou.checkError()){}
            finalJobs();
        }
    }
*/

    public void run() {

        String message = "";
        char qCategory;
        int parseMark;
        int qIndex;

        // *********************************************************************
        // Reader:



        try {
            System.out.println("Weer bij Run");
            Settings settings = new Settings(MainActivity.context);
            settings.loadPref();

            MainActivity.screen.clear(context);

            MainActivity.screen.setScreenCdu(settings.cduPos);
            MainActivity.light.setCdu(settings.cduPos);
            MainActivity.keyBoard.setKeybCdu(settings.cduPos);

            //targetHost="192.168.2.8";

            socket = new Socket(settings.host, settings.port);
            ou = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (UnknownHostException e) {
            // MainActivity.restartNetThread = true;
            // MainActivity.backFromSettings = true;
            System.out.println("Oeps, foutje");
            System.out.println(e);

        } catch (IOException e) {
            // MainActivity.restartNetThread = true;
            // MainActivity.backFromSettings = true;
            System.out.println("Oeps, foutje nr 2");
            System.out.println(e);
        }


            while (true)
                if (MainActivity.reloadPrefs || MainActivity.restartNetThread) {

                    MainActivity.reloadPrefs = false;
                    Settings settings = new Settings(MainActivity.context);
                    settings.loadPref();

                    MainActivity.screen.setScreenCdu(settings.cduPos);
                    MainActivity.screen.setMargins(settings.targetLeftMargin, settings.targetTopMargin, settings.targetFontSize, settings.lineMargin);

                    MainActivity.light.setMargins(settings.targetExecMarginLeft, settings.targetExecMarginTop, settings.targetMsgMarginLeft, settings.targetMsgMarginTop, settings.targetDspyMarginLeft, settings.targetDspyMarginTop, settings.targetFailMarginLeft, settings.targetFailMarginTop, settings.targetOfstMarginLeft, settings.targetOfstMarginTop);
                    MainActivity.light.setCdu(settings.cduPos);

                    MainActivity.keyBoard.setKeybCdu(settings.cduPos);
                    MainActivity.screen.redraw(context);
                    MainActivity.light.handle(context);

                    if (MainActivity.restartNetThread) {
                        try {
                            ou.println("exit");
                        } catch (NullPointerException e) {
                        }

                        try {
                            MainActivity.restartNetThread = false;
                            //targetHost="192.168.2.8";
                            socket = new Socket(settings.host, settings.port);
                            ou = new PrintWriter(socket.getOutputStream(), true);
                            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        } catch (UnknownHostException e) {
                            // MainActivity.restartNetThread = true;
                            // MainActivity.backFromSettings = true;
                            System.out.println("Oeps, foutje");
                            System.out.println(e);
                            MainActivity.screen.clear(context);
                            MainActivity.light.clear(context);

                        } catch (IOException e) {
                            // MainActivity.restartNetThread = true;
                            // MainActivity.backFromSettings = true;
                            System.out.println("Oeps, foutje nr 2");
                            System.out.println(e);
                            MainActivity.screen.clear(context);
                            MainActivity.light.clear(context);

                        }
                    }


                    try {
                        ou.println("bang");
                    } catch (NullPointerException e) {
                        MainActivity.screen.clear(context);
                    }
                } else
                    try {
                        if ((message = in.readLine()) != null) {
                            try {
                                if (message.charAt(0) == 'Q') {
                                    parseMark = message.indexOf('=');
                                    try {
                                        qCategory = message.charAt(1);
                                        qIndex = Integer.parseInt(message.substring(2, parseMark));
                                        parseMark++;

                                        if (qCategory == 's') {
                                            if ((qIndex >= MainActivity.screen.cduLine) && (qIndex <= MainActivity.screen.cduLine + 13)) {
                                                MainActivity.screen.draw(qIndex, parseMark, message, context);
                                            }

                                        } else if (qCategory == 'i') {
                                            if (MainActivity.light.lightsCdu == qIndex) {
                                                MainActivity.light.handle(context, (Integer.parseInt(message.substring(parseMark, message.length()))));
                                            } else if ((qIndex == 89) || (qIndex == 90) || (qIndex == 91)) {
                                                if (Integer.parseInt(message.substring(parseMark, message.length())) != 0) {
                                                    MainActivity.light.blankTime = true;
                                                    MainActivity.screen.blankTime = true;
                                                } else {
                                                    MainActivity.light.blankTime = false;
                                                    MainActivity.screen.blankTime = false;
                                                }
                                            }
                                        } else if (qCategory == 'h') {
                                        }

                                    } catch (NumberFormatException nfe) {
                                        nfe.printStackTrace();
                                    }
                                    //}
                                } else if (message.charAt(0) == 'L') {


                                } else if (message.substring(0, 3).equals("id=")) {

                                    try {
                                        System.out.println("Connection OK. Our client id: " + message);
                                        MainActivity.id = message;
                                    } catch (NumberFormatException nfe) {
                                        nfe.printStackTrace();
                                    }

                                } else if (message.length() > 8
                                        && message.substring(0, 8).equals("version=")) {
                                    MainActivity.version = message;
                                } else if (message.equals("load1")) {
                                    // Situation loading phase 1 (paused and reading variables)
                                } else if (message.equals("load2")) {
                                    // Situation loading phase 2 (reading model options)
                                } else if (message.equals("load3")) {
                                    // Situation loading phase 3 (unpaused)
                                } else if (message.equals("exit")) {
                                    remoteExit = true;
                                    break;
                                } else if (message.startsWith("metar=")) {
                                    // METAR feeder status message
                                }
                            } catch (StringIndexOutOfBoundsException sioobe) {
                                sioobe.printStackTrace();
                            }
                        }
                    } catch (NullPointerException e) {
                        System.out.print("NullPointerException caught");
                    } catch (IOException e) {
                        System.out.println("Bam, een fout");
                        System.out.println(e);
                    }
        }

    void finalJobs() {
        try {
            if (!remoteExit && ou != null) {
                ou.println("exit");
                try {
                    java.lang.Thread.sleep(20);
                } catch (InterruptedException e) {
                }
                ou.close();
            }
            if (in != null)
                in.close();
            if (socket != null)
                socket.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}