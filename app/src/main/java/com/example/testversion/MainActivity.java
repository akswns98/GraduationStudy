package com.example.testversion;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerView;
    private TextView tvDate;
      //화면 전환
    private ImageButton pm;
    private ImageButton temp;
    private Button pmbu;
    private Button hubu;
    //private Button btnRefresh;
    TextView tempm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //main에 파싱
        tempm=findViewById(R.id.tempm);

//시간출력 관련 코드(나중에 온도 미세먼지값 실시간까지 추가)
        tvDate = (TextView) findViewById(R.id.tvTime);
        //btnRefresh = (Button) findViewById(R.id.btnRefresh);
        tvDate.setText(getTime());
        //btnRefresh.setOnClickListener(this);

        Button btnRefresh = (Button)findViewById(R.id.btnRefresh);
        // 화면 전환 관련 버튼 모음
        pm = findViewById(R.id.pm);
        temp = findViewById(R.id.temp);
        pmbu=findViewById(R.id.pmbu);
        hubu=findViewById(R.id.hubu) ;

        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pm.class);
                startActivity(intent);
            }
        });
        pmbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,pm.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,temphumi.class ) ;
                startActivity(intent);
            }
        });
        hubu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,temphumi.class);
                startActivity(intent);
            }
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnRefresh:
                        tvDate.setText(getTime());   //시간 리셋
                        break;
                }

            }
        });
        //파싱관련 코드





































// 메뉴바 관련 코드

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);  //메뉴바 생성
        drawerView = (View) findViewById(R.id.drawer);

        Button btn_menu = (Button)findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_close = (Button)findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
    private String getTime(){    //실시간 출력
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String getTime = dateFormat.format(date);
        return getTime;
    }








    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}

