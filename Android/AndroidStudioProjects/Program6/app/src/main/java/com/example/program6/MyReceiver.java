package com.example.program6;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.content.BroadcastReceiver;
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage [] m = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for(int i = 0; i < m.length; i++){
            Bundle b = new Bundle();
            b.putString("num", m[i].getOriginatingAddress());
            b.putString("msg", m[i].getMessageBody());
            Intent it = new Intent(context, MainActivity.class);
            it.putExtras(b);
            it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(it);
        }
    }
}