package uk.ac.solent.emaweek4

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View.OnClickListener
import android.view.View
import android.widget.TextView
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import android.Manifest
import android.content.Context
import android.location.LocationManager
import android.content.Context.LOCATION_SERVICE


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener{
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
            {
                val mgr = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this)
            }
            else
            {
                toast("please allow the 'access fine location' permission in your settings")
            }
        }



    }



}
