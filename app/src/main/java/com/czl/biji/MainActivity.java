package com.czl.biji;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.baoyz.actionsheet.ActionSheet;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    private int count = 1;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setLabelVisibilityMode(1);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_one,R.id.navigation_two, R.id.navigation_three, R.id.navigation_four)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==event.KEYCODE_BACK){
            if (count<2) {
                ActionSheet.createBuilder(this, getSupportFragmentManager())
                        .setTag("您确定要退出？")
                        .setCancelButtonTitle("取消")
                        .setOtherButtonTitles("退出")
                        .setCancelableOnTouchOutside(true)
                        .setListener(new ActionSheet.ActionSheetListener() {
                            @Override
                            public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
                                //Toast.makeText(getApplicationContext(), "dismissed isCancle = " + isCancel, Toast.LENGTH_SHORT).show();
                                count = 1;
                            }

                            @Override
                            public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                                count = 1;
                                if (index == 0) {
                                    new Thread(){
                                        @Override
                                        public void run() {
                                            try {
                                                sleep(1000);
                                                android.os.Process.killProcess(android.os.Process.myPid());
                                                System.exit(0);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                                System.exit(0);
                                            }
                                            super.run();
                                        }
                                    }.start();
                                }
                            }
                        }).show();
                count++;
            }

        }
        return false;
    }
}
