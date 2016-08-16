package adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class BootReceiver extends BroadcastReceiver {
    final static String TAG = "BootReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        //重启手机后service没有自动运行？
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
//            Toast.makeText(context, "已完成重启", Toast.LENGTH_SHORT).show();
//            context.startService(new Intent(context, InformService.class));
            Log.d(TAG, "onReceive: Service starts");
        }
    }
}
