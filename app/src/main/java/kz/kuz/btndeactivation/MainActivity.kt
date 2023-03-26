package kz.kuz.btndeactivation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    // в этом упражнении деактивирую кнопку через некоторое время
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = Handler(Looper.getMainLooper()) // создаю Handler в главном потоке
        findViewById<View>(R.id.button1).setOnClickListener {
            var a = Integer.valueOf((findViewById<View>(R.id.textView1) as TextView).text.toString())
            a++
            val b = a.toString()
            (findViewById<View>(R.id.textView1) as TextView).text = b
        }
        findViewById<View>(R.id.button2).setOnClickListener {
            val executorService = Executors.newSingleThreadExecutor()
            executorService.execute {
                var c: Int
                for (d in 0..999999999) {
                    c = d
                }
                handler.post { (findViewById<View>(R.id.button1)).isEnabled = false }
            }
        }
    }
}