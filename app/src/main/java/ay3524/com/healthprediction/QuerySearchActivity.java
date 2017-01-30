package ay3524.com.healthprediction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuerySearchActivity extends AppCompatActivity {

    TextView disease;
    Button panic,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        disease = (TextView) findViewById(R.id.disease);
        panic = (Button) findViewById(R.id.panic);
        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
        panic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuerySearchActivity.this, "Soon it will be added!!!", Toast.LENGTH_SHORT).show();
            }
        });

        AsyncTask<Void, Void, Void> updateTask = new AsyncTask<Void, Void, Void>(){
            ProgressDialog dialog = new ProgressDialog(QuerySearchActivity.this);
            @Override
            protected void onPreExecute() {
                // what to do before background task
                dialog.setTitle("Loading...");
                dialog.setMessage("Please wait.");
                dialog.setIndeterminate(true);
                dialog.setCancelable(false);
                dialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                // do your background operation here
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                // what to do when background task is completed
                disease.setText("You have fever!!!");
                dialog.dismiss();
            };

            @Override
            protected void onCancelled() {
                dialog.dismiss();
                super.onCancelled();
            }
        };
        updateTask.execute((Void[])null);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
