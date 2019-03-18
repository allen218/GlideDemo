package com.dongnao.dnglide2;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.dongnao.dnglide2.glide2.Glide;
import com.dongnao.dnglide2.glide2.GlideBuilder;
import com.dongnao.dnglide2.glide2.cache.LruMemoryCache;
import com.dongnao.dnglide2.glide2.request.RequestOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.iv);
        ImageView iv1 = findViewById(R.id.iv1);
        ImageView iv2 = findViewById(R.id.iv2);
        Glide.with(this).load("https://ss1.bdstatic" +
                ".com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2669567003," +
                "3609261574&fm=27&gp=0.jpg22222222asads")
                .apply(new RequestOptions().error(R.drawable.ic_launcher_background).placeholder
                        (R.mipmap.ic_launcher).override(500, 500))
                .into(iv);


        Glide.with(this).load("/sdcard/a.jpg").into(iv1);
        // VSYNC
//        iv2.getWidth();
        Glide.with(this).load(new File("/sdcard/b.jpg")).into(iv2);

    }


    /**
     * 说明MarkInputStream作用
     */
    void test() {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FileInputStream fis = new FileInputStream(new File("/sdcard/a.jpg"));
            //需要去读一些字节 比如读了10个字节
            BitmapFactory.decodeStream(fis, null, options);

            //少了10个字节 解析失败
            options.inJustDecodeBounds = false;
            BitmapFactory.decodeStream(fis, null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void toNext(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
