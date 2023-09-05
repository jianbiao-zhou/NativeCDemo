package com.example.nativecdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nativecdemo.databinding.ActivityMainBinding

/**
 * CMakeLists.txt
 *  test modified branch1
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = helloJni()
    }

    /**
     * A native method that is implemented by the 'nativecdemo' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun helloJni(): String

    companion object {
        // Used to load the 'nativecdemo' library on application startup.
        init {
            System.loadLibrary("nativecdemo")
        }
    }
}