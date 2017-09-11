package com.example.dubo.cachedatas;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView cache_data;
    private String dataSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cache_data = (TextView) findViewById(R.id.cache_data);
        //获取缓存大小
        dataSize = getDataSize();
        cache_data.setText("缓存大小为: "+dataSize);
        cache_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清除缓存
                DialogUtils.showNormalDialog(MainActivity.this, "是否清空缓存？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //清楚缓存不清除共享参数
                        DubCache.cleanApplicationDataNoSP(MainActivity.this);
                        dataSize = getDataSize();//获取缓存大小
                        cache_data.setText("缓存大小为: "+dataSize);
                        //ToastUtils.getInstance().toast("清空完成");
                    }
                });
            }
        });
    }

    //计算缓存
    private String getDataSize() {
        long fileSize = 0;
        File filesDir = getFilesDir();
        File cacheDir = getCacheDir();

        fileSize += DubCache.getDirSize(filesDir);
        fileSize += DubCache.getDirSize(cacheDir);
        String formatSize = DubCache.getFormatSize(fileSize);
        return formatSize;
    }
}
