package com.example.hongda.rongyunsdktest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.hongda.rongyunsdktest.R;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class LoginActivity extends AppCompatActivity {

    /**
     * token 的主要作用是身份授权和安全，因此不能通过客户端直接访问融云服务器获取 token，
     * 您必须通过 Server API 从融云服务器 获取 token 返回给您的 App，并在之后连接时使用
     */
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        token = "X50W7X3ohrk+gtfKGTGqGPgexAdqvb9hcKGVQbyaqfOwg8rbHG9EEKL2za/sffaBWZJM9v4xEUQ7mA+Ioh8twA==";
        Log.i("LHD", "LoginActivity  "+token);
        RongIM.connect(token, new RongIMClient.ConnectCallback() {

            /**
             * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
             *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
             */
            @Override
            public void onTokenIncorrect() {
                Log.i("LHD", "--onTokenIncorrect");
            }

            /**
             * 连接融云成功
             * @param userid 当前 token 对应的用户 id
             */
            @Override
            public void onSuccess(String userid) {
                Log.i("LHD", "--onSuccess" + userid);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }

            /**
             * 连接融云失败
             * @param errorCode 错误码，可到官网 查看错误码对应的注释
             */
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.i("LHD", "onError: " + errorCode);
            }
        });
    }

}
