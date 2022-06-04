package com.example.findroom.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findroom.models.RoomModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findroom.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    public static boolean logined ;
    EditText edtPhone, edtPass;
    TextView txtResetPass;
    Button btnLogin,btnRegister;

    FirebaseDatabase db;
    DatabaseReference myRef ;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AnhXa();

        //Init
        db = FirebaseDatabase.getInstance();
        myRef =  db.getReference();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnRegister =findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterView.class);
                startActivity(intent);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }
    private  void AnhXa(){
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtPass = (EditText) findViewById(R.id.edtPass);
        txtResetPass = (TextView) findViewById(R.id.txtResetPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        back = (ImageView) findViewById(R.id.back_main);
    }
    private void login(){
        if (edtPhone.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Vui lòng nhập số điện thoại", Toast.LENGTH_SHORT).show();
        } else if (edtPass.getText().toString().equals("")) {
            Toast.makeText(LoginActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
        }
        String sdt ="02827485";
        myRef = db.getReference("user").child(sdt);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child("pw").getValue().toString().trim().equals("123")){
                    Log.e("login","done");
                    logined = true;
                    Log.e("login",String.valueOf(logined));
                }else{
                    Log.e("login pw: ",snapshot.child("pw").getValue().toString());
                    Toast.makeText(LoginActivity.this, "Nhập Lại Mật Khẩu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}