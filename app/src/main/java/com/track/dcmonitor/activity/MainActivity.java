package com.track.dcmonitor.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

import com.track.dcmonitor.R;
import com.track.dcmonitor.biz.DcBiz;
import com.track.dcmonitor.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.appList)
    ListView appList;

    @BindView(R.id.appPro)
    ProgressBar appPro;

    @BindView(R.id.dcName)
    EditText dcName;

    @BindView(R.id.dcAddBtn)
    Button dcAddBtn;

    public static boolean isStartService = false;

    /**
     * 默认入口
     * 1，先将之前的添加的数据查一遍出来，放到list中展示
     * 2，
     * 3，
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        dcAddBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Log.i("MainActivity",dcName.getText().toString());
//                new Thread(){
//                    @Override
//                    public void run() {
//                        List<String> list  = new ArrayList<String>();
//                        list.add("XAIUSDT");
//                        list.add("ETHUSDT");
//                        list.add("BTCUSDT");
//                        list.add("PEOPLEUSDT");
//                        DcBiz.qurDcByAPI(list,"MINI","3m");
//                    }
//                }.start();
//            }
//        });
    }

}
