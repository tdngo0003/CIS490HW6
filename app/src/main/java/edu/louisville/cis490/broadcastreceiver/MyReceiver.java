package edu.louisville.cis490.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Tuan Ngo on 12/2/2014.
 */
public class MyReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "Intent Detetected.", Toast.LENGTH_LONG).show();
    }
}
