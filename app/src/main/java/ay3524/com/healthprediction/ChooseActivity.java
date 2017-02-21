package ay3524.com.healthprediction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import ay3524.com.healthprediction.authentication.LoginActivity;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView doctor, patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_who_you_are);

        doctor = (ImageView) findViewById(R.id.doctor);
        patient = (ImageView) findViewById(R.id.patient);

        doctor.setOnClickListener(this);
        patient.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.doctor:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
            case R.id.patient:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                break;
        }
    }
}
