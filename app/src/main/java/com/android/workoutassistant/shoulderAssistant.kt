package com.android.workoutassistant

var sdcount = 0
var sdGood = true

class shoulderAssistant {
    internal var theta_l1 = -1f
    internal var theta_l2 = -1f
    internal var theta_r1 = -1f
    internal var theta_r2 = -1f
    internal var record = false
    internal var theta_l1s = mutableListOf<Float>()
    internal var theta_l2s = mutableListOf<Float>()
    internal var theta_r1s = mutableListOf<Float>()
    internal var theta_r2s = mutableListOf<Float>()

    fun setTheta(theta_l1: Float, theta_l2: Float, theta_r1: Float, theta_r2: Float) {
        this.theta_l1 = theta_l1
        this.theta_l2 = theta_l2
        this.theta_r1 = theta_r1
        this.theta_r2 = theta_r2
        if (record) {
            theta_l1s.add(theta_l1)
            theta_l2s.add(theta_l2)
            theta_r1s.add(theta_r1)
            theta_r2s.add(theta_r2)
        }
    }
    fun autoRecord() {
        if (theta_l1 < 165) {
            this.record = true
            this.theta_l1s.add(theta_l1)
            this.theta_l2s.add(theta_l2)
            this.theta_r1s.add(theta_r1)
            this.theta_r2s.add(theta_r2)
        } else {
            this.record = false
        }
    }

}
