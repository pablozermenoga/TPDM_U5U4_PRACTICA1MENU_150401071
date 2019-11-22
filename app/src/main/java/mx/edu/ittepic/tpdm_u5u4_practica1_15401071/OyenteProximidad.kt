package mx.edu.ittepic.tpdm_u5u4_practica1_15401071

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class OyenteProximidad(p:MainActivity): SensorEventListener {
    var puntero = p
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    override fun onSensorChanged(p0: SensorEvent?) {
        puntero.cercas = p0!!.values[0]
    }
}