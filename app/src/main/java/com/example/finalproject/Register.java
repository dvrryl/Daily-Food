package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalproject-187c8-default-rtdb.asia-southeast1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = findViewById(R.id.usernameRegis);
        final EditText emailRegis = findViewById(R.id.emailRegister);
        final EditText phoneRegis = findViewById(R.id.phoneRegister);
        final EditText passwordRegis = findViewById(R.id.passwordRegister);
        final EditText confirmPassword = findViewById(R.id.passwordConfirmRegister);
        final Button regis = findViewById(R.id.regisBtn);
        final TextView loginNow = findViewById(R.id.loginNow);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String usernametxt = username.getText().toString();
                final String emailtxt = emailRegis.getText().toString();
                final String phonetxt = phoneRegis.getText().toString();
                final String paswordtxt = passwordRegis.getText().toString();
                final String confirmtxt = confirmPassword.getText().toString();


                if(usernametxt.isEmpty() || emailtxt.isEmpty() || phonetxt.isEmpty() || paswordtxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill", Toast.LENGTH_SHORT).show();

                }else if (!paswordtxt.equals(confirmtxt)){
                    Toast.makeText(Register.this, "Password Wrong", Toast.LENGTH_SHORT).show();

                }else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(usernametxt)){
                                Toast.makeText(Register.this, "Email already register", Toast.LENGTH_SHORT).show();
                            }else{
                                databaseReference.child("users").child(usernametxt).child("email").setValue(emailtxt);
                                databaseReference.child("users").child(usernametxt).child("phone").setValue(phonetxt);
                                databaseReference.child("users").child(usernametxt).child("password").setValue(paswordtxt);

                                Toast.makeText(Register.this,"User Succces Register", Toast.LENGTH_SHORT).show();
                                finish();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });



                }


            }
        });

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}