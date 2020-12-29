package com.aidlserver;

import android.os.RemoteException;
import android.util.Log;

/**
 * Created by ufsoft on2020-12-23
 * describle:
 */
public class Computer extends IComputer.Stub{
    @Override
    public int add(int a, int b) throws RemoteException {
        Log.e("tag","server端 Computer 的add方法");
        return  a + b;
    }
}
