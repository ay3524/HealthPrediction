package ay3524.com.healthprediction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PredictionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp;
    List<String> spinnerList;
    List<String> searchQuery;
    Button search, add, clear;
    TextView queryParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        sp = (Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
        search = (Button) findViewById(R.id.search);
        add = (Button) findViewById(R.id.addButton);
        clear = (Button) findViewById(R.id.clear);
        queryParam = (TextView) findViewById(R.id.queryParam);

        spinnerList = new ArrayList<>();
        searchQuery = new ArrayList<>();

        spinnerList.add("Headache");
        spinnerList.add("Dehydration");
        spinnerList.add("Sweating");
        spinnerList.add("Muscle aches");
        spinnerList.add("Loss of appetite");
        spinnerList.add("General Weakness");
        spinnerList.add("Chills");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerList);
        sp.setAdapter(arrayAdapter);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchQuery.size() < 3) {
                    Toast.makeText(PredictionActivity.this, "Add at least 3 queries in the box to search", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(getApplicationContext(), QuerySearchActivity.class));
                    Toast.makeText(PredictionActivity.this, "Searching Please Wait....", Toast.LENGTH_SHORT).show();
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchQuery.size() >= 4) {
                    Toast.makeText(PredictionActivity.this, "Do Not add more than 4 queries", Toast.LENGTH_SHORT).show();
                } else {
                    String item = (String) sp.getSelectedItem();
                    searchAndAdd(item);
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryParam.setText("");
                searchQuery.clear();
            }
        });

    }

    private void searchAndAdd(String item) {
        //List <String> listClone = new ArrayList<String>();
        for (String string : searchQuery) {
            if (string.matches(item)) {
                Toast.makeText(this, "Its Already Added", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        searchQuery.add(item);
        queryParam.append(item + "\n");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //searchQuery.add();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}