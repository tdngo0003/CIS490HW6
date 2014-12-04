package edu.louisville.cis490.broadcastreceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.PushService;


public class MainActivity extends Activity {

    TextView testdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "GHlqi5SOyzPGYVRIuLueGLErlpxa8aMqAXIXGqJo", "CGHRCdjP8zsfyURG347ZRWDlivSkT56gfescgKeo");
        // Also in this method, specify a default Activity to handle push notifications
        //noinspection deprecation
        PushService.setDefaultPushCallback(this, MainActivity.class);

        final ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
        query.getInBackground("vGEio4NTlG", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if(e==null){

                    testdata = (TextView) findViewById(R.id.textView);
                    testdata.setText(parseObject.toString());

                }
                else
                {
                    //Not Found
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // broadcast a custom intent
    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
