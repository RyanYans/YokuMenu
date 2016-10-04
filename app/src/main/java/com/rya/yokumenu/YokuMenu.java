package com.rya.yokumenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rya.yokumenu.utils.YokuMenuUtil;

public class YokuMenu extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rl_1;
    private RelativeLayout rl_2;
    private RelativeLayout rl_3;
    private ImageButton ibtn_home;
    private ImageButton ibtn_menu;
    private boolean isHomeShow = true;
    private boolean isMenuShow = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoku_menu);

        initUI();

    }

    private void initUI() {
        rl_1 = (RelativeLayout) findViewById(R.id.rl_1);
        rl_2 = (RelativeLayout) findViewById(R.id.rl_2);
        rl_3 = (RelativeLayout) findViewById(R.id.rl_3);
        ibtn_home = (ImageButton) findViewById(R.id.ibtn_home);
        ibtn_menu = (ImageButton) findViewById(R.id.ibtn_menu);

        ibtn_home.setOnClickListener(this);
        ibtn_menu.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtn_home:
                if (YokuMenuUtil.getIsRunning() > 0) {
                    return;
                }
                if (isHomeShow) {
                    if (isMenuShow) {
                        YokuMenuUtil.viewOut(rl_3, 0);
                        isMenuShow = false;
                    }
                    YokuMenuUtil.viewOut(rl_2, 200);
                } else {
                    YokuMenuUtil.viewIn(rl_2, 0);
                    YokuMenuUtil.viewIn(rl_3, 200);
                    isMenuShow = true;
                }
                isHomeShow = !isHomeShow;
                break;
            case R.id.ibtn_menu:
                if (YokuMenuUtil.getIsRunning() > 0) {
                    return;
                }
                if (isMenuShow) {
                    YokuMenuUtil.viewOut(rl_3, 0);
                } else {
                    YokuMenuUtil.viewIn(rl_3, 0);
                }
                isMenuShow = !isMenuShow;
                break;
        }
    }
}
