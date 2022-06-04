package com.example.findroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findroom.R;
import com.example.findroom.controler.DatabaseControler;
import com.example.findroom.controler.RegisterController;
import com.example.findroom.models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterView<_> extends AppCompatActivity {
    private RegisterController cRegis;
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef ;
    Button btnLogin, btnRegis ;
    EditText edName , edSdt , edPw , edRpw ;

    DatabaseControler cdb =new DatabaseControler();
    UserModel userModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);

        Bind();

        Log.e("test",edSdt.getText().toString());

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userModel =new UserModel(edSdt.getText().toString().trim(),edPw.getText().toString().trim(),edName.getText().toString().trim());
                Log.e("regis:",edName.getText().toString());
                Log.e("regis:",edSdt.getText().toString());
                Log.e("regis:",edRpw.getText().toString());
                Log.e("regis:",userModel.getSdt());
                Regis(userModel);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterView.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Regis(UserModel user){
        mRef = mDatabase.getReference("user");
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.e("test n",snapshot.child(user.getSdt().toString()).getValue().toString());
//                if(snapshot.child(user.getSdt()).getValue().equals(user.getSdt())){
//                    Toast.makeText(RegisterView.this, "Số điện thoại đã được sử dụng", Toast.LENGTH_SHORT).show();
//                }else{
//                    cdb.PushDataUser(user);
//                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("done",user.getSdt());
            }
        });

    }



    private void Bind(){
        btnLogin =findViewById(R.id.btnLogin);
        btnRegis =findViewById(R.id.btnRegister);
        edName = findViewById(R.id.edt_name);
        edPw =findViewById(R.id.edt_pass_regis);
        edRpw =findViewById(R.id.edt_regis_pass_again);
        edSdt =findViewById(R.id.edt_phone);
    }
}