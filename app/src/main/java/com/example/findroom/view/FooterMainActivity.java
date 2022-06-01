package com.example.findroom.view;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.findroom.R;

public class FooterMainActivity extends AppCompatActivity {
    private ImageView add_room ;
    private Button btnTest ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footer_main);

        add_room =findViewById(R.id.add_room);
        btnTest =findViewById(R.id.btn_submit);



        add_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FooterMainActivity.this, "hello", Toast.LENGTH_LONG).show();
                Intent intent =new Intent(FooterMainActivity.this, AddRoomActivity.class);
                startActivity(intent);
            }
        });

    }
}