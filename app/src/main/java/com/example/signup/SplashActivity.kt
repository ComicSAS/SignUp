package com.example.signup

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnTouchListener, GestureDetector.OnGestureListener {

    private lateinit var mGestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        tv_splash_sign_in.setOnTouchListener(this)
        tv_splash_sign_up.setOnTouchListener(this)
        mGestureDetector = GestureDetector(this, this)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if(v!=null){
            if(v.id == R.id.tv_splash_sign_in){
                tv_splash_sign_in.setTextSize(25.0F)
                mGestureDetector.onTouchEvent(event)
                return true
            }
            if(v.id == R.id.tv_splash_sign_up){
                tv_splash_sign_up.setTextSize(25.0F)
                mGestureDetector.onTouchEvent(event)
                return true
            }
        }
        return true
    }

    /*
        GestureDetector
     */

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Log.d("Gesture ", " onSingleTapUp")
        return true
    }

    override fun onDown(e: MotionEvent?): Boolean {
        Log.d("Gesture ", " onDown")
        return true
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        if (e1 != null && e2 != null) {
            if (e1.x < e2.x) {
                Log.d("Gesture ", "Left to Right swipe: " + e1.x + " - " + e2.x)
                Log.d("Speed ", velocityX.toString() + " pixels/second")
                tv_splash_sign_up.textSize = 25.0F
                tv_splash_sign_in.textSize = 25.0F
            }
            if (e1.x > e2.x) {
                Log.d("Gesture ", "Right to Left swipe: " + e1.x + " - " + e2.x)
                Log.d("Speed ", velocityX.toString() + " pixels/second")
                tv_splash_sign_up.textSize = 25.0F
                tv_splash_sign_in.textSize = 25.0F
            }
            if (e1.y < e2.y) {
                Log.d("Gesture ", "Up to Down swipe: " + e1.x + " - " + e2.x)
                Log.d("Speed ", velocityY.toString() + " pixels/second")
                tv_splash_sign_up.textSize = 25.0F
                tv_splash_sign_in.textSize = 25.0F
            }
            if (e1.y > e2.y) {
                Log.d("Gesture ", "Down to Up swipe: " + e1.x + " - " + e2.x)
                Log.d("Speed ", velocityY.toString() + " pixels/second")
                tv_splash_sign_up.textSize = 25.0F
                tv_splash_sign_in.textSize = 25.0F
            }
        }

        tv_splash_sign_up.textSize = 18.0F
        tv_splash_sign_in.textSize = 18.0F
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        Log.d("Gesture ", " onScroll")
        if (e1 != null && e2 != null) {
            if (e1.y < e2.y) {
                Log.d("Gesture ", " Scroll Down")
            }
            if (e1.y > e2.y) {
                Log.d("Gesture ", " Scroll Up")
            }
        }
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        Log.d("Gesture ", " onLongPress")
    }

    override fun onShowPress(e: MotionEvent?) {
        Log.d("Gesture ", " onShowPress")
    }
}
