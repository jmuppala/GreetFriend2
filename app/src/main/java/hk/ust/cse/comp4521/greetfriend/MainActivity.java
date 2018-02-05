package hk.ust.cse.comp4521.greetfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button greetButton;
    String [] names;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Construct a string array from the String Array resource "friends" in the
        // strings.xml file
        names = getResources().getStringArray(R.array.friends);

        ListView friendListView = (ListView) findViewById(R.id.friendListView);

        // This method call sets the names string array as the source of the names
        // for the list of items in the listview. The ArrayAdapter object is used
        // to adapt the string array and construct a list of layout items that are
        // then used by the ListView of the ListActivity to construct the list of friends.
        // The layout of each item is specified by the friend_item.xml file
        friendListView.setAdapter( new ArrayAdapter<String>(this, R.layout.friend_item, names));
        friendListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        // The parameter "id" indicates the index of the item that was selected from
                        // the list of friends. This is used to index into the names[] array to get
                        // the name of the friend selected. Rest of the code is similar to the earlier
                        // exercise.

                        // create a new intent. The first parameter is the Context which is the current Activity.
                        // Hence we use "this". The second parameter is the Activity class that we wish to start.
                        // Hence it is specified as ShowMessage.class
                        Intent in = new Intent(getApplicationContext(), ShowMessage.class);

                        // Add the message as a payload to the Intent. We add data to be carried by the intern using
                        // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                        // the key, specified as a string, and the second parameter is the value.
                        in.putExtra("message", getString(R.string.greetstring) + " " + names[(int) id] + "!");

                        // We start the new activity by calling this method to inform the Android framework to start
                        // the new activity. The parameter is the Intent we just created earlier
                        startActivity(in);
                    }

                }
        );

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
