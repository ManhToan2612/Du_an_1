package com.example.du_an_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.du_an_1.Dao.AdminDAO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edUserName, edPassword;
    TextInputLayout in_user, in_pass;
    Button btnLogin;
    TextView btnDangky;
    CheckBox chkRememberPass;
    AdminDAO adminDAO;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adminDAO = new AdminDAO(this);
        edUserName = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassword);
        in_user = findViewById(R.id.in_User);
        in_pass = findViewById(R.id.in_Pass);
        btnLogin = findViewById(R.id.btnLogin);
        btnDangky = findViewById(R.id.btnDangky);
        chkRememberPass = findViewById(R.id.chkRememberPass);
        checkRemember();
//        AdminDAO adminDAO = new AdminDAO(getApplicationContext());
        btnLogin.setOnClickListener(view -> {
            String maAD= edUserName.getText().toString();
            String matKhau= edPassword.getText().toString();

            if (maAD.isEmpty()){
                in_user.setError("Không được để trống");
            }
            if (matKhau.isEmpty()){
                in_pass.setError("Không được để trống");
                return;
            }
            if(adminDAO.checkLogin(maAD, matKhau)){
                if (chkRememberPass.isChecked()){
                    editor.putString("maAD", maAD);
                    editor.putString("matKhau", matKhau);
                    editor.putBoolean("isChecked", chkRememberPass.isChecked());
                    editor.apply();
                }else {
                    editor.clear();
                    editor.apply();
                }
                edUserName.setText("");
                edPassword.setText("");
                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(intent);
                this.finish();

            }else {
                in_user.setError("Tên đăng nhập không đúng");
                in_pass.setError("Mật khẩu không đúng");
            }
        });

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, Dangky.class);
                startActivity(intent);
            }
        });

    }

        private void checkRemember(){
            sharedPreferences= this.getSharedPreferences("USER", MODE_PRIVATE);
            editor = sharedPreferences.edit(); // Thêm dòng này để khởi tạo đối tượng editor
            boolean isCheck= sharedPreferences.getBoolean("isCheck", false);
            if(isCheck){
                edUserName.setText(sharedPreferences.getString("user", ""));
                edPassword.setText(sharedPreferences.getString("pass", ""));
                chkRememberPass.setChecked(isCheck);

        }
    }
}