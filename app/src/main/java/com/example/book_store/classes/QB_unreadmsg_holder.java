package com.example.book_store.classes;

import android.os.Bundle;

public class QB_unreadmsg_holder {
    private static QB_unreadmsg_holder instance;
    private Bundle bundle;

    public static synchronized QB_unreadmsg_holder getInstance() {
        QB_unreadmsg_holder qb_unreadmsg_holder;
        synchronized (QB_unreadmsg_holder.class) {
            if (instance == null)
                instance = new QB_unreadmsg_holder();
                qb_unreadmsg_holder = instance;

            return qb_unreadmsg_holder;


        }

    }

    private  QB_unreadmsg_holder(){
         bundle = new Bundle();

    }

    public void setBundle(Bundle bundle){
        this.bundle = bundle;

    }

    public Bundle getBundle(){

        return this.bundle;
    }

    public int getUnreadmessagebydialuge(String id){

        return this.bundle.getInt(id);
    }

}
