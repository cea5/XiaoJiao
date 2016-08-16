package service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import java.util.Calendar;

import cea.xiaojiao.MainActivity;
import cea.xiaojiao.R;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class InformService extends Service {

    private String TAG = "InformService";
    private RequestQueue queue;
    private StringRequest stringRequest;
    private Context context = this;
    private static int UPDATED = 0;
    private static int NOT_UPDATED = 1;
    private static int UPDATING = 2;
    private int status = NOT_UPDATED;
    private Calendar calendar;
    private InformService informService = this;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return null;
    }
    public static boolean isConn(Context context){
        boolean bisConnFlag=false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if(network!=null){
            bisConnFlag=conManager.getActiveNetworkInfo().isAvailable();
        }
        return bisConnFlag;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        //全部后台运行？
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                while (true) {
//                    if (isConn(context)) {
//                        Notification.Builder builder = new Notification.Builder(context);
//                        builder.setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0))
//                                .setTicker("网络已连接")
//                                .setContentTitle("通知")
//                                .setContentText(System.currentTimeMillis() + "")
//                                .setSmallIcon(R.drawable.search)
//                                .setWhen(System.currentTimeMillis())
//                                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
//                        //                        Notification notification = builder.getNotification();
//                        notificationManager.notify(0, builder.build());
//                    }
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                calendar = Calendar.getInstance();
//                queue = Volley.newRequestQueue(context);
//                stringRequest = new StringRequest("http://www.yishizhizhu.cn/new_inform.php", new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String s) {
//                        if(s.equals("true")){
//                            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                            Notification.Builder builder = new Notification.Builder(context);
//                            builder.setContentIntent(PendingIntent.getService(context, 0, new Intent(context, InformService.class), 0))
//                                    .setTicker("交大有新的通知")
//                                    .setContentTitle("通知")
//                                    .setContentText("学校通知栏有新的更新，赶快看看吧~")
//                                    .setSmallIcon(R.drawable.search)
//                                    .setWhen(System.currentTimeMillis())
//                                    .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
//                            Notification notification = builder.getNotification();
//                            notificationManager.notify(0, notification);
//                            status = UPDATED;
//                        }
//                        else if(s.equals("false")){
//                            status = UPDATED;
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//
//                    }
//                });
//                Log.d(TAG, "onCreate: ");
//                //一直循环，
//                while (true){
//                    //isUpdated分为几个状态，没更新、更新中、更新了
//                    if (calendar.get(Calendar.HOUR_OF_DAY)>=9&&status==NOT_UPDATED){
//                        Log.d(TAG, "run: UPDATING");
//                        queue.add(stringRequest);
//                        status = UPDATING;
//                    }
//                    else if (status == NOT_UPDATED){
//                        try {
//                            Log.d(TAG, "run: NOT_UPDATED");
//                            Thread.sleep(1000*60*60);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                   else if(status == UPDATED){
//                        Log.d(TAG, "run: UPDATED");
//                        informService.stopSelf();
//                        break;
//                    }
//                }
//            }
//        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                while (true) {
                    if (isConn(context)) {
                        Notification.Builder builder = new Notification.Builder(context);
                        builder.setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0))
                                .setTicker("网络已连接")
                                .setContentTitle("通知")
                                .setContentText(System.currentTimeMillis() + "")
                                .setSmallIcon(R.drawable.search)
                                .setWhen(System.currentTimeMillis())
                                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                        //                        Notification notification = builder.getNotification();
                        notificationManager.notify(0, builder.build());
                    }
//                    else
//                        onDestroy();
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
