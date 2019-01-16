package iqbal.app.projectku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FutsalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futsal);


        Button btnArena = (Button) findViewById(R.id.btn_arena);
        Button btnGsc = (Button) findViewById(R.id.btn_gsc);

        btnArena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arena = new Intent(FutsalActivity.this, ArenaActivity.class);
                startActivity(arena);
            }
        });

        btnGsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gsc = new Intent(FutsalActivity.this, GscFutsalActivity.class);
                startActivity(gsc);
            }
        });
    }
}
