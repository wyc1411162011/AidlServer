package com.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

/**
 * Created by ufsoft on2020-12-23
 * describle:
 */
public class PoolService extends Service {
    IBinderPool.Stub binderPool = new IBinderPool.Stub() {

        @Override
        public IBinder queryBinder(int type) throws RemoteException {
            if(type==0){
                return new Computer();
            }else{
                return new SecurityCenter();
            }
        }
    };
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binderPool;
    }
}
