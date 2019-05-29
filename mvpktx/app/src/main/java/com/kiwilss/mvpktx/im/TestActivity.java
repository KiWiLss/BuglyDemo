package com.kiwilss.mvpktx.im;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mob.imsdk.MobIM;
import com.mob.imsdk.MobIMCallback;
import com.mob.imsdk.model.IMConversation;

import java.util.List;

/**
 * @author : Lss kiwilss
 * @FileName: TestActivity
 * @e-mail : kiwilss@163.com
 * @time : 2019/3/13
 * @desc : {DESCRIPTION}
 */
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        UMSGUI.showLogin(new OperationCallback<User>(){
//            @Override
//            public void onSuccess(User user) {
//                super.onSuccess(user);
//            }
//        });

        MobIM.getChatManager().getAllLocalConversations(new MobIMCallback<List<IMConversation>>() {
            @Override
            public void onSuccess(List<IMConversation> imConversations) {

            }

            @Override
            public void onError(int i, String s) {

            }
        });

    }
}
