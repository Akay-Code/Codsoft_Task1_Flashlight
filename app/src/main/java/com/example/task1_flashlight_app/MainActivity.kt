package com.example.task1_flashlight_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RelativeLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //declaring some initial variables
    @SuppressLint("UseSwitchCompatOrMaterialCode")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switchLight = findViewById<Switch>(R.id.switchFlashLight)

        switchLight.setOnCheckedChangeListener { compoundButton, b ->
            if (b) turnOnLight()
            else turnOffLight()
        }

    }

    @SuppressLint("ResourceAsColor")
    private fun turnOnLight(){
        val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val camId = camManager.cameraIdList[0]
        camManager.setTorchMode(camId, true)

        //changing text
        val textStatus = findViewById<TextView>(R.id.txtStatus)
        textStatus.text = "💡 On 💡"

        Toast.makeText(applicationContext, "Flashlight is On !", Toast.LENGTH_SHORT).show()


//        //changing background
//        var refer = findViewById<RelativeLayout>(R.id.mainScreen)
//        refer.setBackgroundColor(R.color.white)

    }

    @SuppressLint("ResourceAsColor")
    private fun turnOffLight(){
        val camManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val camId = camManager.cameraIdList[0]
        camManager.setTorchMode(camId , false)
        val textStatus = findViewById<TextView>(R.id.txtStatus)
        textStatus.text = "Off"

        Toast.makeText(applicationContext, "Flashlight turned Off !", Toast.LENGTH_SHORT).show()

        //changing background
//        var refer = findViewById<RelativeLayout>(R.id.mainScreen)
//        refer.setBackgroundColor(R.color.black)
    }

    override fun onBackPressed() {
        turnOffLight()
        finish()
    }
}