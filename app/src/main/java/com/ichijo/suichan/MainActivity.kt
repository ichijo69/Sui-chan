package com.ichijo.suichan

import android.os.Build.ID
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import needle.Needle
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var editSuitext: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editSuitext=findViewById<EditText>(R.id.editSuitext)
//        Needle.onBackgroundThread().execute(Runnable {
//            var data=TalkToSuisei("Hi")
//            Needle.onMainThread().execute(Runnable { editSuitext.setText(data) })
//
//        })



    }


    fun TalkToSuisei(conversation:String): String {



        val talkInterface = SuichanBrainInterface.create()
        val response =talkInterface.getMessage(conversation)

        var talk=""
        if (response != null) {


                var res=response.execute()
                var suisei=res.body()
                if (suisei != null) {
                    talk= suisei.cnt
                    Log.e("TAG",talk+" ")


                }else{
                    talk="Suichan is feeling sick.. Dont want to talk "
                }



        }else{
            talk="Suichan is feeling sick.. Dont want to talk "
        }

        return talk
    }
}