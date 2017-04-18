package org.ocs.android.agent.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.ocs.android.actions.OCSLog;
import org.ocs.android.actions.OCSSettings;

import java.util.Calendar;

public class OCSBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context ctx, final Intent intent) {
        Log.d("OCSBOOT", "on Receive called");
        OCSSettings ocssetting = OCSSettings.getInstance(ctx);
        OCSLog ocslog = OCSLog.getInstance();
        ocslog.debug("OCSBootReceiver : " + intent.getAction());
        if (ocssetting == null) {
            ocslog.error("NULL OSSETTING");
            return;
        }

        if (!ocssetting.isAutoMode()) {
            return;
        }
        int interval = ocssetting.getFreqWake();
        ocslog.debug("OCSBootReceiver interval : " + interval);

        AlarmManager alarmManager = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(ctx, OCSEventReceiver.class);

        PendingIntent intentExecuted = PendingIntent.getBroadcast(ctx, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
        Calendar start = Calendar.getInstance();
        start.add(Calendar.SECOND, 5);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, start.getTimeInMillis(), interval * 60000L, intentExecuted);
    }
}