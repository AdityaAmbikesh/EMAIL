package com.example.aditya.email;

/**
 * Created by aditya on 14/6/18.
 */

import android.os.Bundle;

import android.app.Activity;

import android.os.Environment;
import android.util.Log;

import android.view.Menu;

import android.view.View;

import android.widget.Button;

import android.widget.Toast;



public class MainActivity extends Activity {

    Button send;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        send = (Button) findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

               // Toast.makeText(MainActivity.this, "here", Toast.LENGTH_SHORT).show();
                // TODO Auto-generated method stub

                new Thread(new Runnable() {

                    public void run() {

                        try {

                            GMailSender sender = new GMailSender(

                                    "enter your email id",

                                    "enter your password");



                           sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");

                            sender.sendMail("Test mail", "This mail has been sent from android app along with attachment",

                                    "from email id",

                                    "to email id");
                          //  Toast.makeText(MainActivity.this, "here", Toast.LENGTH_SHORT).show();









                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();



                        }

                    }

                }).start();

            }

        });



    }



}