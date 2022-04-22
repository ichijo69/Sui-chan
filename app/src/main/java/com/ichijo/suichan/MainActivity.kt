package com.ichijo.suichan

import android.os.Build.ID
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import needle.Needle
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       
    }
    fun talkher(conversation: String) = runBlocking {
        doWorld(conversation)
    }
    // Concurrently executes both sections
    suspend fun doWorld(conversation: String) = coroutineScope { // this: CoroutineScope
        launch {
            delay(2000L)
            var data=TalkToSuisei(conversation)


        }


    }

    fun TalkToSuisei(conversation:String): String {



        val talkInterface = SuichanBrainInterface.create()
        Log.e("TAG",conversation+" ")
        val response =talkInterface.getMessage(conversation)

        var talk=""
        val countDownLatch = CountDownLatch(1)
        if (response != null) {
            Log.e("TAG",conversation+" ")

            Needle.onBackgroundThread().execute {
                var res=response.execute()
                var suisei=res.body()
                if (suisei != null) {
                    talk= suisei.cnt
                    Log.e("TAG",talk+" ")


                }else{
                    talk="Suichan is feeling sick.. Dont want to talk "
                }
            }


        }else{
            talk="Suichan is feeling sick.. Dont want to talk "
        }

        return talk
    }
}