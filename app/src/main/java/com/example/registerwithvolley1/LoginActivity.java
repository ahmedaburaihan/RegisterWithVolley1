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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    Button btn_login, btn_register;
    EditText et_email, et_password;
    ProgressBar loading;
    private static final String LOGIN_URL = "http://192.168.8.104/RegisterWithVolley1/login.php";

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(this);

        et_email    = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        loading     = findViewById(R.id.loading);

        btn_login   = findViewById(R.id.btn_login);
        btn_register= findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_email.getText().toString().isEmpty() || et_password.getText().toString().isEmpty()){
                        et_email.setError("Email cannot be empty");
                        et_password.setError("Password cannot be empty");
                }else{
                    String email = et_email.getText().toString();
                    String pass  = et_password.getText().toString();

                    login(email, pass);

                }
            }
        });



    }



    public void login(final String email, final String pass){
//        String email = et_email.getText().toString().trim();
//        String pass  = et_password.getText().toString().trim();

        loading.setVisibility(View.VISIBLE);
        btn_login.setVisibility(View.GONE);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");

                            if(success.equals("1")){
                                for(int i=0; i<jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String name = object.getString("name").trim();
                                    String email= object.getString("email").trim();
                                    String id= object.getString("id").trim();

                                    sessionManager.createSession(name, email, id);

                                    Toast.makeText(LoginActivity.this,
                                            "Success Login! \nYour Name: " +
                                                    ""+name+"\n Your Email: "+email, Toast.LENGTH_LONG).show();

                                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("email", email);
                                    startActivity(intent);

                                }
                            }
                        }catch(Exception e){
                            btn_login.setVisibility(View.VISIBLE);
                            Toast.makeText(LoginActivity.this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        btn_login.setVisibility(View.VISIBLE);
                        Toast.makeText(LoginActivity.this, "Error: "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password",pass);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }




}

























