package com.example.registerwithvolley1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private EditText name, email, password, conf_password;
    private Button btn_register, btn_login;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conf_password = findViewById(R.id.conf_password);
        loading = findViewById(R.id.loading);
        btn_register = findViewById(R.id.btn_register);
        btn_login    = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
                    name.setError("Field cannot be empty");
                    email.setError("Field cannot be empty");
                }else if(password.getText().toString().equals(conf_password.getText().toString())){
                    registerUser();
                }else{
                    conf_password.setError("Password does not match");
                }

            }
        });


    }

    //Register Method//
    private void registerUser(){
        loading.setVisibility(View.VISIBLE);
        btn_register.setVisibility(View.GONE);
        final String name = this.name.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
//        final String conf_password = this.conf_password.getText().toString().trim();
        final StringRequest request = new StringRequest
                (Request.Method.POST, "http://192.168.8.104/RegisterWithVolley1/register.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try{
                                    JSONObject jsonObject = new JSONObject(response);
                                    String success = jsonObject.getString("success");

                                    if(success.equals("1")){
                                        Toast.makeText(MainActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                    Toast.makeText(MainActivity.this, "Register Error "+e.toString(), Toast.LENGTH_SHORT).show();
                                    loading.setVisibility(View.GONE);
                                    btn_register.setVisibility(View.VISIBLE);
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, "Register Error "+error.toString(), Toast.LENGTH_SHORT).show();
                                loading.setVisibility(View.GONE);
                                btn_register.setVisibility(View.VISIBLE);
                            }
                        })

                    {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("name", name);
                            params.put("email", email);
                            params.put("password", password);
                            return params;
                        }
                    };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}




















