package com.kiwilss.buglyone;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiwilss.buglyone.utils.OpenAutoStartUtil;
import com.kiwilss.buglyone.utils.SystemUtil;
import com.tencent.bugly.beta.Beta;
import com.zhy.base.fileprovider.FileProvider7;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author kiwilss
 */
public class MainActivity extends AppCompatActivity {

    private String mCurrentPhotoPath;
    private android.widget.ImageView ivphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ivphoto = (ImageView) findViewById(R.id.iv_photo);


        TextView tvVersion = findViewById(R.id.tv_main_version);
        tvVersion.setText(BuildConfig.VERSION_NAME);


        //自定义对话框


        String mobileType = OpenAutoStartUtil.getMobileType();
        String deviceBrand = SystemUtil.getDeviceBrand();
        Log.e("MMM", "onCreate: "+mobileType+"---------"+deviceBrand );

    }

    public void dowloadClick(View view) {
        //http://app-global.pgyer.com/a356255214ded0585049ea2f7321dff2.apk?attname=app-release18.apk&sign=7b025cd87a80ddb9687e4692014f5631&t=5c3c0475
        //http://app-global.pgyer.com/a356255214ded0585049ea2f7321dff2.apk?attname=app-release18.apk&sign=7b025cd87a80ddb9687e4692014f5631&t=5c3c0475
        //http://app-global.pgyer.com/a356255214ded0585049ea2f7321dff2.apk?attname=app-release18.apk&sign=ffcc607239676d6948d134776c6b4b3f&t=5c3c0a2b
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri uri = Uri.parse
                ("https://www.pgyer.com/apiv2/app/install?" +
                        "_api_key=eea89db205dfadc4b04f1c708f404180&appKey=a283b77357c23a735205646b658d3ce1");
        intent.setData(uri);
        startActivity(intent);
    }

    public void bugListener(View view) {
//        String bug = null;
//        Toast.makeText(this, "bug", Toast.LENGTH_SHORT).show();
//        int length = bug.length();

        SystemUtil.getWechatApi(this);
    }

    public void takePhoto(View view) {//需要相机和存储权限
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            String filename = new SimpleDateFormat("yyyyMMdd-HHmmss", Locale.CHINA)
                    .format(new Date()) + ".png";
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            mCurrentPhotoPath = file.getAbsolutePath();
            // 仅需改变这一行
            Uri fileUri = FileProvider7.getUriForFile(this, file);

            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(takePictureIntent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            ivphoto.setImageBitmap(BitmapFactory.decodeFile(mCurrentPhotoPath));
        }
    }

    public void installApk(View view) {
//        File file = new File(Environment.getExternalStorageDirectory(),
//                "app-release2.apk");
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        // 仅需改变这一行
//        FileProvider7.setIntentDataAndType(this,
//                intent, "application/vnd.android.package-archive", file, true);
//        startActivity(intent);

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setView(R.layout.upgrade_dialog);
//
//        builder.show();

        //startActivity(new Intent(this, UpdateActivity.class));

        Beta.checkUpgrade();
        /**
         * @param isManual  用户手动点击检查，非用户点击操作请传false
         * @param isSilence 是否显示弹窗等交互，[true:没有弹窗和toast] [false:有弹窗或toast]
         */
        //public static synchronized void checkUpgrade(boolean isManual, boolean isSilence)

    }
}
