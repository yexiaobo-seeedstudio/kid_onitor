package cc.seeed.stu.seeedhackathon12;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;
    private ImageButton imageButton9;

    private String mNumber = "smsto:15875567204";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // for SMS ImageButton
        imageButton1 = (ImageButton) findViewById(R.id.imageButton_1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton_2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton_3);
        imageButton4 = (ImageButton) findViewById(R.id.imageButton_4);
        imageButton5 = (ImageButton) findViewById(R.id.imageButton_5);
        imageButton6 = (ImageButton) findViewById(R.id.imageButton_6);
        imageButton7 = (ImageButton) findViewById(R.id.imageButton_7);
        imageButton8 = (ImageButton) findViewById(R.id.imageButton_8);
        imageButton9 = (ImageButton) findViewById(R.id.imageButton_9);

        imageButton1.setOnClickListener(new MyOnClickListener());
        imageButton2.setOnClickListener(new MyOnClickListener());
        imageButton3.setOnClickListener(new MyOnClickListener());
        imageButton4.setOnClickListener(new MyOnClickListener());
        imageButton5.setOnClickListener(new MyOnClickListener());
        imageButton6.setOnClickListener(new MyOnClickListener());
        imageButton7.setOnClickListener(new MyOnClickListener());
        imageButton8.setOnClickListener(new MyOnClickListener());
        imageButton9.setOnClickListener(new MyOnClickListener());

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
        // automatically handle clicks on the Home/Up imageButton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            showInputDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // func for SMS
    private void sendSMStoMyMum(String s){
        Uri uri = Uri.parse(mNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", s);
        startActivity(intent);
    }

    // func for listening Button action
    class MyOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imageButton_1:
                    sendSMStoMyMum("0");
                    break;
                case R.id.imageButton_2:
                    sendSMStoMyMum("1");
                    break;
                case R.id.imageButton_3:
                    sendSMStoMyMum("2");
                    break;
                case R.id.imageButton_4:
                    sendSMStoMyMum("3");
                    break;
                case R.id.imageButton_5:
                    sendSMStoMyMum("4");
                    break;
                case R.id.imageButton_6:
                    sendSMStoMyMum("5");
                    break;
                case R.id.imageButton_7:
                    sendSMStoMyMum("6");
                    break;
                case R.id.imageButton_8:
                    sendSMStoMyMum("7");
                    break;
                case R.id.imageButton_9:
                    sendSMStoMyMum("8");
                    break;
                default:
                    break;
            }
        }
    }

    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "Send to " + editText.getText(), Toast.LENGTH_SHORT).show();
                        mNumber = "smsto:" + editText.getText().toString();
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
