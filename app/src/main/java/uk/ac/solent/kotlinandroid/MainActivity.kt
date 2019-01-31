package uk.ac.solent.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val b : Button  = findViewById(R.id.btnDownload)

        btnDownload.setOnClickListener {
            val artistName = artistInput.text.toString()
            toast ("You searched $artistName")
            doAsync {
                val url = URL(" http://www.free-map.org.uk/course/ws/hits.php?artist=$artistName")
                val response = url.readText()
                uiThread {
                    textViewResults.text = response
                }
            }

        }

    }
}
