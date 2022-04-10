package ro.pub.cs.systems.eim.lab03.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity{

    EditText textView;
    StringBuilder number = new StringBuilder();
    Button mClickButton1;
    Button mClickButton2;
    Button mClickButton3;
    Button mClickButton4;
    Button mClickButton5;
    Button mClickButton6;
    Button mClickButton7;
    Button mClickButton8;
    Button mClickButton9;
    Button mClickButton0;
    Button mClickButton_star;
    Button mClickButton_diez;
    ImageButton mClickButton_delete;
    ImageButton mClickButton_call;
    ImageButton mClickButton_decline;
    ImageButton mClickButton_contacts;
    final public static int PERMISSION_REQUEST_CALL_PHONE = 1;
    final public static int CONTACTS_MANAGER_REQUEST_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.editext);

        mClickButton1 = findViewById(R.id.button1);

        mClickButton2 = findViewById(R.id.button2);

        mClickButton3 = findViewById(R.id.button3);

        mClickButton4 = findViewById(R.id.button4);

        mClickButton5 = findViewById(R.id.button5);

        mClickButton6 = findViewById(R.id.button6);

        mClickButton7 = findViewById(R.id.button7);

        mClickButton8 = findViewById(R.id.button8);

        mClickButton9 = findViewById(R.id.button9);

        mClickButton0 = findViewById(R.id.button0);

        mClickButton_star = findViewById(R.id.button11);

        mClickButton_diez = findViewById(R.id.button10);

        mClickButton_delete = findViewById(R.id.imageButton);

        mClickButton_call = findViewById(R.id.imageButton3);

        mClickButton_decline = findViewById(R.id.imageButton2);

        mClickButton_contacts =  findViewById(R.id.imageButton4);


        mClickButton_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (number.length() > 0) {
                    number.deleteCharAt(number.length() - 1);
                    textView.setText(number.toString());
                }

            }
        });


        mClickButton_star.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('*');
                textView.setText(number.toString());

            }
        });

        mClickButton_diez.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('#');
                textView.setText(number.toString());

            }
        });

        mClickButton0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('0');
                textView.setText(number.toString());

            }
        });

        mClickButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('1');
                textView.setText(number.toString());

            }
        });

        mClickButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('2');
                textView.setText(number.toString());

            }
        });

        mClickButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('3');
                textView.setText(number.toString());

            }
        });
        mClickButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('4');
                textView.setText(number.toString());

            }
        });
        mClickButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('5');
                textView.setText(number.toString());

            }
        });
        mClickButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('6');
                textView.setText(number.toString());

            }
        });
        mClickButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('7');
                textView.setText(number.toString());

            }
        });
        mClickButton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('8');
                textView.setText(number.toString());

            }
        });
        mClickButton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                number.append('9');
                textView.setText(number.toString());

            }
        });

        mClickButton_call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CALL_PHONE);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + textView.getText().toString()));
                    startActivity(intent);
                }
            }
        });

        mClickButton_contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = textView.getText().toString();
                if (phoneNumber.length() > 0) {
                    System.out.println("ceva");
                    Intent intent = new Intent("ro.pub.cs.systems.eim.lab04.contactsmanager.intent.action.MainActivity");
                    intent.putExtra("ro.pub.cs.systems.eim.lab04.contactsmanager.PHONE_NUMBER_KEY", phoneNumber);
                    startActivityForResult(intent, CONTACTS_MANAGER_REQUEST_CODE);
                } else {
                    System.out.println("ceva1");
                    Toast.makeText(getApplication(), getResources().getString(R.string.phone_error), Toast.LENGTH_LONG).show();
                }
            }
        });


        mClickButton_decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}