package com.android.workoutassistant

        class Keypoints {
            var points = Array(14) { FloatArray(2) }

            fun setPoints(indexOfPoint: Int, x: Float, y: Float) {
                points[indexOfPoint][0] = x
                points[indexOfPoint][1] = y
    }
    fun getAngle(indexOfPoint1: Int,indexOfPoint2: Int,indexOfPoint0: Int): Float {
        val p1= mutableListOf<Float>()
        p1.add(points[indexOfPoint1][0])
        p1.add(points[indexOfPoint1][1])
        val p2= mutableListOf<Float>()
        p2.add(points[indexOfPoint2][0])
        p2.add(points[indexOfPoint2][1])
        val p0= mutableListOf<Float>()
        p0.add(points[indexOfPoint0][0])
        p0.add(points[indexOfPoint0][1])
        val c=kotlin.math.sqrt(Math.pow(p1[0].toDouble()-p0[0].toDouble(),2.0).toFloat()+Math.pow(p1[1].toDouble()-p0[1].toDouble(),2.0).toFloat())
        val b=kotlin.math.sqrt(Math.pow(p2[0].toDouble()-p0[0].toDouble(),2.0).toFloat()+Math.pow(p2[1].toDouble()-p0[1].toDouble(),2.0).toFloat())
        val a=kotlin.math.sqrt(Math.pow(p1[0].toDouble()-p2[0].toDouble(),2.0).toFloat()+Math.pow(p1[1].toDouble()-p2[1].toDouble(),2.0).toFloat())
        val s=(Math.pow(c.toDouble(),2.0)+Math.pow(b.toDouble(),2.0)-Math.pow(a.toDouble(),2.0))/(2*b*c)
        val angle=kotlin.math.acos(s)*180/Math.PI
        val theta:Float = String.format("%.2f", angle).toFloat()
        return theta
    }

}
