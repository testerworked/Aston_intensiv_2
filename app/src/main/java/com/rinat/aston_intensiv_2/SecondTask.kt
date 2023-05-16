package com.rinat.aston_intensiv_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.widget.doOnTextChanged
import coil.imageLoader
import coil.request.ImageRequest
import kotlinx.coroutines.*

class SecondTask : AppCompatActivity() {

    private val imageLoadFlags by lazy {
        findViewById<ImageView>(R.id.imageLoadFlags)
    }

    private val searchWords by lazy {
        findViewById<EditText>(R.id.editSearchWords)
    }
    var urlForFlagDownload: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)



        GlobalScope.launch(Dispatchers.IO) {
            searchWords.doOnTextChanged { textFromSearch, _, _, _ ->
                //updateTextView(text.toString())
                GlobalScope.launch(Dispatchers.Main) {
                    urlForFlagDownload = textFromSearch.toString()
                }
            }
        }

        GlobalScope.launch{
            delay(1000L)

            val imageLoader = imageLoadFlags.context.imageLoader
            val request = ImageRequest.Builder(imageLoadFlags.context)
                //.data("https://sportishka.com/uploads/posts/2022-03/1647938865_67-sportishka-com-p-krasota-zimnego-baikala-turizm-krasivo-fot-71.jpg")
                .data(urlForFlagDownload)
                .target(imageLoadFlags)
                .build()
            imageLoader.enqueue(request)
        }



    }


}