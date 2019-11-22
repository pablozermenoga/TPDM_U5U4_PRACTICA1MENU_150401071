package mx.edu.ittepic.tpdm_u5u4_practica1_15401071

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteShake(p:MainActivity): SensorEventListener {
    var puntero = p
    var fin: Long = 0
    var x = 0f
    var y = 0f
    var z = 0f
    var movx = 0f
    var movy = 0f
    var movz = 0f
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(p0: SensorEvent?) {
        var temp : Long = System.currentTimeMillis()
        if((temp - fin) > 100){
            var diffTime = (temp - fin)
            fin = temp
            x = p0!!.values[0]
            y = p0!!.values[1]
            z = p0!!.values[2]

            var shake : Float = Math.abs(x + y + z - movx - movy - movz) / diffTime * 10000

            if(shake > 800){
                puntero.incShake++
                if(puntero.incShake > 3){
                    puntero.incShake = 0
                }
            }
            movx = x
            movy = y
            movz = z

        }
    }
}