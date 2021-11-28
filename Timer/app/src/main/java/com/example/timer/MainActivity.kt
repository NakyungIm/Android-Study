package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.timer.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var total = 0
    var started = false

    val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {  // 스레드를 통해 total에 쓴 값을, msg를 통해 화면에 표시
            val minute = String.format("%02d", total/60)
            val second = String.format("%02d", total%60)

            binding.textTimer.text = "$minute:$second"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            btnStart.setOnClickListener {
                started = true
                thread(start = true) { // sub thread
                    while (started) {
                        Thread.sleep(1000)
                        if (started) {
                            total += 1
                            handler?.sendEmptyMessage(0)
                        }
                    }
                }
            }

            btnStop.setOnClickListener {
                if(started){
                    started = false
                    total = 0
                    textTimer.text = "00:00"
                }
            }
        }
    }
}