package mx.edu.ittepic.tpdm_u5u4_practica1_15401071

import android.graphics.Canvas
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class Lienzo(p:MainActivity): View(p) {
    var puntero = p
    var picono : Imagen ?= null;


    var icono1 = Imagen(this,50f, 300f,R.drawable.icono1)
    var icono2 = Imagen(this,300f, 300f, R.drawable.icono2)
    var icono3 = Imagen(this, 600f, 300f, R.drawable.icono3)
    var icono4 = Imagen(this, 900f, 300f, R.drawable.icono4)
    var icono5 = Imagen(this, 1200f, 300f, R.drawable.icono5)


    var icono21 = Imagen(this,50f, 300f,R.drawable.vicono1)
    var icono22 = Imagen(this,300f, 300f, R.drawable.vicono2)
    var icono23 = Imagen(this, 600f, 300f, R.drawable.vicono3)
    var icono24 = Imagen(this, 900f, 300f, R.drawable.vicono4)
    var icono25 = Imagen(this, 1200f, 300f, R.drawable.vicono5)


    var icono31 = Imagen(this,50f, 300f,R.drawable.bn_icono1)
    var icono32 = Imagen(this,300f, 300f, R.drawable.bn_icono2)
    var icono33 = Imagen(this, 600f, 300f, R.drawable.bn_icono3)
    var icono34 = Imagen(this, 900f, 300f, R.drawable.bn_icono4)
    var icono35 = Imagen(this, 1200f, 300f, R.drawable.bn_icono5)


    var icono41 = Imagen(this, 50f, 500f, R.drawable.iconfinder1)
    var icono42 = Imagen(this,300f, 500f, R.drawable.iconfinder2)
    var icono43 = Imagen(this, 600f, 500f, R.drawable.iconfinder3)
    var icono44 = Imagen(this, 900f, 500f, R.drawable.iconfinde4)
    var icono45 = Imagen(this, 1200f, 500f, R.drawable.iconfinder5)



    var arrayImagen = arrayListOf<Imagen>(icono1,icono2,icono3,icono4,icono5)
    var arrayImg2 = arrayListOf<Imagen>(icono21,icono22,icono23,icono24,icono25)
    var arrayImg3 = arrayListOf<Imagen>(icono31,icono32,icono33,icono34,icono35)
    var arrayImg4 = arrayListOf<Imagen>(icono41,icono42,icono43,icono44,icono45)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        if(puntero.cercas == 0f){
            icono1.visible = false
            icono2.visible = false
            icono3.visible = false
            icono4.visible = false
            icono5.visible = false
            invalidate()
        }
        else{
            when(puntero.incShake){
                0 -> {
                    drawImgs(arrayImagen,c)
                    moverImagenes(arrayImagen, puntero.x)
                }
                1 -> {
                    drawImgs(arrayImg2,c)
                    moverImagenes(arrayImg2, puntero.x)
                }
                2 -> {
                    drawImgs(arrayImg3,c)
                    moverImagenes(arrayImg3, puntero.x)
                }
                3 -> {
                    drawImgs(arrayImg4,c)
                    moverImagenes(arrayImg4, puntero.x)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                if(icono1.estaEnArea(event.getX(), event.getY())||
                    icono21.estaEnArea(event.getX(), event.getY()) ||
                    icono31.estaEnArea(event.getX(), event.getY()) ||
                    icono41.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono Instagram", Toast.LENGTH_SHORT).show()
                    picono = icono1
                }

                if(icono2.estaEnArea(event.getX(), event.getY())||
                    icono22.estaEnArea(event.getX(), event.getY()) ||
                    icono32.estaEnArea(event.getX(), event.getY()) ||
                    icono42.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste a Larry", Toast.LENGTH_SHORT).show()
                    picono = icono2
                }

                if(icono3.estaEnArea(event.getX(), event.getY())||
                    icono23.estaEnArea(event.getX(), event.getY()) ||
                    icono33.estaEnArea(event.getX(), event.getY()) ||
                    icono43.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono WhatsApp", Toast.LENGTH_SHORT).show()
                    picono = icono3
                }

                if(icono4.estaEnArea(event.getX(), event.getY())||
                    icono24.estaEnArea(event.getX(), event.getY()) ||
                    icono34.estaEnArea(event.getX(), event.getY()) ||
                    icono44.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono Youtube", Toast.LENGTH_SHORT).show()
                    picono = icono4
                }

                if(icono5.estaEnArea(event.getX(), event.getY())||
                    icono25.estaEnArea(event.getX(), event.getY()) ||
                    icono35.estaEnArea(event.getX(), event.getY()) ||
                    icono45.estaEnArea(event.getX(), event.getY())){

                    Toast.makeText(puntero,"Tocaste icono Facebook", Toast.LENGTH_SHORT).show()
                    picono = icono5
                }
            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                picono = null
            }
        }
        return true
    }

    fun moverImagenes(arrayImg : ArrayList<Imagen>, x:Float){
        arrayImg.forEach{
            it.mover(x)
        }
        invalidate()
    }

    fun hideImages(c: Canvas){
        c.restore()
        invalidate()
    }

    fun drawImgs(arrayImgs : ArrayList<Imagen>, c: Canvas){
        arrayImgs.forEach {
            it.pintar(c)
        }
    }
}
