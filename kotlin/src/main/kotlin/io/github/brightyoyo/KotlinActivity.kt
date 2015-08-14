package io.github.brightyoyo

import android.app.Activity
import android.media.audiofx.BassBoost
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.brightyoyo.foo.Person
import java.util.*;

/**
 * @author bri
 * @since 15-8-14.
 */
public class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        val person = Person("droid")

        val person2 = person.copy()
    }

    fun <T> MutableList<T>.swap(x:Int,y:Int) {
        val tmp = this[x] // 'this' corresponds to the list
        this[x] = this[y]
        this[y] = tmp
    }


}

interface Base {
    fun print()
}

class BaseImpl(val x:Int) :Base {
    override fun print() {
        print(x)
    }

    class Derived(b:Base) :Base by b

}

