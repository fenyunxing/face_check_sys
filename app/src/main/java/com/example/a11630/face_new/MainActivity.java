package com.example.a11630.face_new;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_change,btn_opt,btn_in,btn_delete,btn_out;
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查询按钮
       btn_change=findViewById(R.id.change);
        btn_change.setOnClickListener(this);
        //录入按钮
        btn_in=findViewById(R.id.in);
        btn_in.setOnClickListener(this);
        //打卡按钮
        btn_opt=findViewById(R.id.opt);
        btn_opt.setOnClickListener(this);
       //删除按钮
       btn_delete=findViewById(R.id.delete);
        btn_delete.setOnClickListener(this);
       //退出按钮
        btn_out=findViewById(R.id.out);
        btn_out.setOnClickListener(this);

        MyHelper hhh=new MyHelper(MainActivity.this);
        readRequest();
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.change){
            //进入查询界面
            startActivity(new Intent(this,change.class));
        }
        else if(v.getId()==R.id.in){
            //进入录入界面
            startActivity(new Intent(this,in.class));
        }else  if(v.getId()==R.id.opt){
            //打卡界面
            startActivity(new Intent(this,opt.class));
        }else if(v.getId()==R.id.delete){
            //删除界面跳转
            startActivity(new Intent(this,delete.class));
        }else{
            //退出程序
            System system = null;
            system.exit(0);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    void readRequest() {             //获取相机拍摄读写权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, 1);
            }
        }
    }
}
