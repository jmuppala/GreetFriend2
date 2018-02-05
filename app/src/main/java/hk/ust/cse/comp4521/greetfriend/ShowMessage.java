package hk.ust.cse.comp4521.greetfriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowMessage extends AppCompatActivity {

    private static final String TAG = "ShowMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        // We first get a reference to the Intent that resulted in this activity
        // being started by the Android framework.
        Intent in = getIntent();

        // From the Intent we retrieve the message that was sent from MainActivity
        // Note the use of the same key, "message", to retrieve the message
        String message = in.getStringExtra("message");

        // Get the reference to the TextView on the ShowMessage UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        // set the text of the TextView to display the incoming greeting message
        textMessage.setText(message);

        Log.i(TAG, "in onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "in onStart()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in onDestroy()");
    }
}
