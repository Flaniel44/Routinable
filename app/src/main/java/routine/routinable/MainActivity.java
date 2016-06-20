package routine.routinable;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    Dialog addTask;
    TextView addTaskBtn, cancelBtn, clearBtn;
    EditText secondsInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //CREATE DIALOG
        createDialog();

        //Darken 'empty list' icon
        ImageView iv = (ImageView)findViewById(R.id.no_tasks_icon);
        if (iv != null) iv.setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP);

        //FAB button click
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                addTask.show();

            }
        });



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

    private void createDialog()
    {
        addTask=new Dialog(this);

        //set content
        addTask.setContentView(R.layout.add_task);

        addTaskBtn= (TextView) addTask.findViewById(R.id.confirmTxt);
        cancelBtn= (TextView) addTask.findViewById(R.id.cancelTxt);
        secondsInput =(EditText) addTask.findViewById(R.id.secondsInput);
        clearBtn = (TextView) addTask.findViewById(R.id.clearTxt);

        //SHOW_BTN CLICKED
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"CLICKED",Toast.LENGTH_LONG).show();
                addTask.dismiss();
            }
        });

        //Keyboard checkmark on last input field
        secondsInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toast.makeText(MainActivity.this,"CLICKED",Toast.LENGTH_LONG).show();
                addTask.dismiss();
                return true;
            }
        });

        //CANCEL
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask.dismiss();
            }
        });

        //CLEAR
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText) addTask.findViewById(R.id.hoursInput)).setText("");
                ((EditText) addTask.findViewById(R.id.minutesInput)).setText("");
                ((EditText) addTask.findViewById(R.id.secondsInput)).setText("");
            }
        });
    }

}
