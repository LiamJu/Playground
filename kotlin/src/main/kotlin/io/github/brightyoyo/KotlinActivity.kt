package io.github.brightyoyo

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @author bri
 * @since 15-8-14.
 */
public class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
    }
}
