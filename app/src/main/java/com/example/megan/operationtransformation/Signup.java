package com.example.megan.operationtransformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Megan on 22/04/2016.
 */
public class Signup extends Activity {


    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.Bsignupbutton)
        {
            //gets name, email, username, password and password confirmation
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText uname = (EditText)findViewById(R.id.TFuname);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            //Compare passwords
            if(!pass1str.equals(pass2str))
            {
                //pop up message
                Toast pass = Toast.makeText(Signup.this, "Password's Don't Match!", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //else Insert details into database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
            }

        }
    }
}
