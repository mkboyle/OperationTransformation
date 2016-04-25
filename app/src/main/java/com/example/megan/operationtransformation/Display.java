package com.example.megan.operationtransformation;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Megan on 19/04/2016.
 */
public class Display extends AppCompatActivity{


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);

    }

    public void onClickButton(View v)
    {
        if (v.getId() == R.id.Btracker)
        {
            Intent i = new Intent(Display.this, Tracker.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.Bfitness)
        {
            Intent i = new Intent(Display.this, Fitness.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.Bdiet)
        {
            Intent i = new Intent(Display.this, Diet.class);
            startActivity(i);
        }
        else if (v.getId() == R.id.Bfacebook)
        {
            //Intent i = new Intent(Display.this, Facebook.class);
            //startActivity(i);
            // Only Works if there is no tab open in internet
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.facebook.com/OpTranRTE/"));
            startActivity(intent);
        }
    }
}
