package com.aidlserver;

import android.os.RemoteException;
import android.util.Log;

/**
 * Created by ufsoft on2020-12-23
 * describle:
 */
public class SecurityCenter extends ISecurityCenter.Stub{
    @Override
    public String encrypt(String content) throws RemoteException {
        Log.e("tag","server端的 "+ " 加密");
        return "加密";
    }

    @Override
    public String decrypt(String password) throws RemoteException {
        Log.e("tag","server端的 "+ " 解密");
        return "解密";
    }
}
