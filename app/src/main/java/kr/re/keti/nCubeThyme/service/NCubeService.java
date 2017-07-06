package kr.re.keti.nCubeThyme.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import kr.re.keti.nCubeThyme.R;
import kr.re.keti.nCubeThyme.service.nCubeCore.ThymeMain;
import kr.re.keti.nCubeThyme.setting.NCubeSettingDataShare;

/**
 * Created by Sung on 2015-03-03.
 */
public class NCubeService extends Service {

    Thread thymeMainThread;

    private boolean destroyFlag = false;
    private boolean state = true;

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("service", "onBinded");
        return nCubeServiceBinder;
    }

    @Override
    public void onCreate() {
        Log.d("service", "onCreate실행");
    }

    @Override
    public void onDestroy() {
        Log.d("service", "onDestroy실행");

        if (destroyFlag) {
            stopForeground(true);
            System.exit(0);
        }

        else {
            onCreate();
        }
    }

    private final INCubeService.Stub nCubeServiceBinder = new INCubeService.Stub() {
        public void setStopService() throws RemoteException {
            Log.d("IBinder", "setStopService");
            destroyFlag = true;
        }

        public boolean checkRunningState() throws RemoteException {
            Log.d("IBinder", "checkRunningState");
            return state;
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "onStartCommand실행");
        Notification notice = new Notification.Builder(getApplicationContext())
                .setContentTitle("&CUBE Lavender Service")
                .setContentText("&CUBE Lavender Service is running")
                .setSmallIcon(R.drawable.ncube_lavender_notify)
                .setTicker("&CUBE Lavender Service is start!!")
                .setAutoCancel(false)
                .build();
        startForeground(startId, notice);
        NCubeSettingDataShare regData = (NCubeSettingDataShare) intent.getSerializableExtra("regData");
        thymeMainThread = new ThymeMain(regData.configData);
        thymeMainThread.start();

        return START_REDELIVER_INTENT;
    }
}
