package com.malenikajkat.signal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WidgetRemoteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);


        Intent viewAppWidgetIntent = new Intent(context, YourActivity.class);
        viewAppWidgetIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);


        context.startActivity(viewAppWidgetIntent);
    }
}
