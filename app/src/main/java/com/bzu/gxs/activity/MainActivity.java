package com.bzu.gxs.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.RadioGroup;

import com.bzu.gxs.R;
import com.bzu.gxs.adapter.fragment.FragmentBoard;
import com.bzu.gxs.adapter.fragment.FragmentChat;
import com.bzu.gxs.adapter.fragment.FragmentCommunity;
import com.bzu.gxs.adapter.fragment.FragmentMe;

public class MainActivity extends FragmentActivity{

    private Fragment mContentFragment;
    private RadioGroup mRadioGroup;

    private FragmentBoard mFragmentBoard;
    private FragmentCommunity mFragmentCommunity;
    private FragmentChat mFragmentChat;
    private FragmentMe mFragmentMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFragmentBoard = new FragmentBoard();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,mFragmentBoard).commit();
        mRadioGroup = (RadioGroup) findViewById(R.id.tab_menu);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.Board:
                        mFragmentBoard = new FragmentBoard();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,mFragmentBoard).commit();
                        break;

                    case R.id.Community:
                        mFragmentCommunity = new FragmentCommunity();
                        Log.i("MyFragment","FragmentCommunity");
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,mFragmentCommunity).commit();
                        break;
                    case R.id.Chat:
                        mFragmentChat = new FragmentChat();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,mFragmentChat).commit();
                        break;
                    case R.id.Me:
                        mFragmentMe = new FragmentMe();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,mFragmentMe).commit();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
