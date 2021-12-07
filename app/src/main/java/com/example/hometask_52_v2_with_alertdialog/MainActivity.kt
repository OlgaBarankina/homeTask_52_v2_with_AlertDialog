package com.example.hometask_52_v2_with_alertdialog

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var timer : CountDownTimer
    private lateinit var alertDialog: AlertDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btStart.setOnClickListener {

            var edEnterMinR = Integer.parseInt(edEnterMin.getText().toString())
            var edEnterSecR = Integer.parseInt(edEnterSec.getText().toString())

            var Result = (edEnterMinR * 60000 + edEnterSecR * 1000).toLong()


            timer = object : CountDownTimer(Result, 1000  /*step in 1 sec*/) {
                @SuppressLint("SetTextI18n")
                override fun onTick(millisUntilFinished: Long) {
                    tvMessage.setText("Left: " + millisUntilFinished / 1000 + " seconds")
                }


                override fun onFinish() {
                    createDialog()

                }
            }

            timer.start()

        }





    }


    fun createDialog() {

        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Timer was finished!")
        //alertDialogBuilder.setMessage("Are you sure you want to exit?")
        alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
            finish()
        }

        //alertDialogBuilder.setNegativeButton("Cancel", { dialogInterface: DialogInterface, i: Int -> })

        alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }





}


