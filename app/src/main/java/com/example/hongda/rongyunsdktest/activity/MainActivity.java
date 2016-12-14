package com.example.hongda.rongyunsdktest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.hongda.rongyunsdktest.R;

import io.rong.imkit.RongIM;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button conversation;
    private Button conversationlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        conversation = (Button) findViewById(R.id.jump_conversation);
        conversationlist = (Button) findViewById(R.id.jump_conversationlist);

        conversation.setOnClickListener(this);
        conversationlist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jump_conversation:
                if (RongIM.getInstance() != null) {
                    RongIM.getInstance().startPrivateChat(MainActivity.this, "123", "李鸿达2");
                }
                break;
            case R.id.jump_conversationlist:
                if (RongIM.getInstance() != null)
                    RongIM.getInstance().startConversationList(MainActivity.this);
                break;
        }

    }
}
