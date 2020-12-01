package com.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by ufsoft on2020-12-01
 * describle:
 */
public class AidlService extends Service {
    private List<Book>bookList;

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData(){
        bookList = new ArrayList<>();
        for(int i= 0;i<3;i++){
            Book book = new Book("第"+ i +"  本书");
            bookList.add(book);
        }

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
    private  final BookController.Stub stub = new BookController.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return bookList;
        }

        @Override
        public void addBookInOut(Book book) throws RemoteException {
            if(book != null){
                Log.e("tag","获取client发送过来的书的名字  " +book.getName());
                bookList.add(book);
            }else{
                Log.e("tag","获取client发送过来的书为空  " );
            }
        }
    };
}
