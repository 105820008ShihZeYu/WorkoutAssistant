package com.android.workoutassistant

import android.util.Log

var sqcount = 0
var sqGood = true

class squatAssistant {
    internal var theta_1 = -1f
    internal var theta_2 = -1f
    internal var record = false
    internal var theta_1s = mutableListOf<Float>()
    internal var theta_2s = mutableListOf<Float>()


    fun resetCount() {
        sqcount = 0
    }

    fun setTheta(theta_1: Float, theta_2: Float) {
        this.theta_1 = theta_1
        this.theta_2 = theta_2
        if (record) {
            theta_1s.add(theta_1)
            theta_2s.add(theta_2)
        }
    }

    fun autoRecord() {
        if (theta_1 < 150) {
            this.record = true
            this.theta_1s.add(theta_1)
            this.theta_2s.add(theta_2)
        } else {
            this.record = false
        }
    }

    fun grade() {
        var ft = LowPassFilter(0.5)
        if (record == false) {
            sqGood = true
            Log.d("TEST", (theta_1s).size.toString() + "    " + (theta_2s).size.toString())
            if ((theta_1s).size >= 3 && (theta_2s).size >= 3) {
                for (i in 0..(theta_1s).size - 1) {
                    Log.d("TEST", ft.filter(theta_1s[i].toDouble()).toString() + "      " + ft.filter(theta_2s[i].toDouble()).toString())
                    //if (kotlin.math.abs(theta_1s[i] - theta_2s[i]) > 20) {
                    if (kotlin.math.abs(ft.filter(theta_1s[i].toDouble()) - ft.filter(theta_2s[i].toDouble())) > 15) {
                        sqGood = false
                    }
                }
                theta_1s.clear()
                theta_2s.clear()
                if (sqGood) {
                    sqcount++
                }
            }
        }
    }

}
