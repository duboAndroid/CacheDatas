package com.example.dubo.cachedatas;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by dubo on 2017/9/10.
 */

public class DialogUtils {
    /**
     * 普通对话框
     *
     * @param message
     * @param listener
     * @return
     */
    public static AlertDialog showNormalDialog(Context context, String message, DialogInterface.OnClickListener listener) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        //builder.setIcon(R.mipmap.ic_launcher);
        //builder.setTitle("温馨提示");
        builder.setMessage(message);
        //builder.setMessage(Html.fromHtml(message));
        builder.setCancelable(false);//外部不可点击
        builder.setPositiveButton("确定", listener);
        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog = builder.create();
        // 显示
        alertDialog.show();
        return alertDialog;
    }
}
