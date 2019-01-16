package iqbal.app.projectku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BadmintonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badminton);

        Button btnGscBadminton = (Button) findViewById(R.id.btn_gsc_badminton);
        Button btnCihuni = (Button) findViewById(R.id.btn_cihuni);

        btnGscBadminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gscBadminton = new Intent(BadmintonActivity.this, GscBadmintonActivity.class);
                startActivity(gscBadminton);
            }
        });

        btnCihuni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cihuni = new Intent(BadmintonActivity.this, CihuniActivity.class);
                startActivity(cihuni);
            }
        });
    }
}
