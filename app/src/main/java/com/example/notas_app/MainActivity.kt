package com.example.notas_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btngur.setOnClickListener {
            if (etxname.text.isEmpty()||etxcode.text.isEmpty()||etxlab1.text.isEmpty()||etxlab2.text.isEmpty()||etxparc.text.isEmpty()){
                Toast.makeText(this, " Favor rellenar todos los campos", Toast.LENGTH_SHORT).show()
            }
            else {
                val name: String = etxname.text.toString()
                val code: String = etxcode.text.toString()
                val labora1: String = etxlab1.text.toString()
                val labora2: String = etxlab2.text.toString()
                val parcia: String = etxparc.text.toString()

                guardarbasededatos(name,code,labora1,labora2,parcia)
            }

        }

    }
    fun guardarbasededatos(nombre:String,codigo:String,labora1:String,labora2:String,parcial:String){
        val shop=HashMap<String,String>()
        shop["nombre"]=nombre.toString()
        shop["codigo"]=codigo.toString()
        shop["labora1"]=labora1.toString()
        shop["labora2"]=labora2.toString()
        shop["parcial"]=parcial.toString()
        val rootRef= FirebaseDatabase.getInstance().reference
        val taskRef= rootRef.child("inventario").push()
        taskRef.setValue(shop)

    }
}