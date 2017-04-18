package org.ocs.android.actions;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class OCSLog {
    private static String TAG = "OCSLOG";
    private static OCSLog instance;
    private File logFile;

    public OCSLog() {
        File rep = Environment.getExternalStoragePublicDirectory("ocs");

        Log.d(TAG, Environment.getExternalStorageDirectory().getPath());

        if (!rep.isDirectory()) {
            rep.delete();
        }
        if (!rep.exists()) {
            if (!rep.mkdir()) {
                Log.e(TAG, "Cannot create directory : " + rep.getPath());
                return;
            } else {
                Log.d(TAG, rep.getPath() + " created");
            }
        }
        logFile = new File(rep, "ocslog.txt");
        if (logFile.length() > 100000L) {
            logFile.delete();
        }
    }

    public static OCSLog getInstance() {
        if (instance == null) {
            instance = new OCSLog();
        }
        return instance;
    }

    public void debug(String paramString) {
        if (paramString != null && OCSSettings.getInstance() != null && OCSSettings.getInstance().getDebug() && logFile != null) {
            Log.d("OCSLOG", paramString);
            log(paramString);
        }
    }

    public void error(String paramString) {
        if (paramString != null && OCSSettings.getInstance() != null) {
            Log.e("OCSLOG", paramString);
            log(paramString);
        }
    }

    private void log(String paramString) {
        if (logFile == null) {
            return;
        }
        Date localDate = new Date();
        String strDate = DateFormat.getInstance().format(localDate);
        try {
            FileWriter fileWriter = new FileWriter(logFile, true);
            fileWriter.append(strDate).append(":").append(paramString).append("\n");
            fileWriter.close();
        } catch (IOException e) {
        }
    }
}