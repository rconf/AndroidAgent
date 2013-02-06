package org.ocsinventory.android.agent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
 
public class OCSEventReceiver extends BroadcastReceiver {
	private static final String LOGTAG = "OCSEventReceiver";
 
	@Override
	public void onReceive(final Context ctx, final Intent intent) {
		Log.d(LOGTAG, "Called");
		Intent eventService = new Intent(ctx, OCSAgentService.class);
		ctx.startService(eventService);
	}
 
}