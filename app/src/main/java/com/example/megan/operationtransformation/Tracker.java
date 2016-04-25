package com.example.megan.operationtransformation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Megan on 24/04/2016.
 */
public class Tracker extends Activity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracker);

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        readWeights();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

    }

    public void onAddWeight(View v) {
        EditText etNewWeight = (EditText) findViewById(R.id.etNewWeight);
        String weightText = etNewWeight.getText().toString();
        itemsAdapter.add(weightText);
        etNewWeight.setText("");
        writeWeights();
    }

    private void readWeights() {
        File filesDir = getFilesDir();
        File weightFile = new File(filesDir, "weight.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(weightFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }
    private void writeWeights() {
        File filesDir = getFilesDir();
        File weightFile = new File(filesDir, "weight.txt");
        try {
            FileUtils.writeLines(weightFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
