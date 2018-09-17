package com.example.volod.tic_toc


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
//import android.widget.EditText
import android.widget.Toast

import  kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TV.text="$counterA :  $counterB"


    }
    companion object  {
        var rowcoldiag = " "
        var counterA: Int = 0
        var counterB: Int = 0

    }

    protected fun buClick(view:View){
        val buSelected= view as Button
        var cellID=0
        when(buSelected.id){
            R.id.bu1-> cellID=1
            R.id.bu2-> cellID=2
            R.id.bu3-> cellID=3
            R.id.bu4-> cellID=4
            R.id.bu5-> cellID=5
            R.id.bu6-> cellID=6
            R.id.bu7-> cellID=7
            R.id.bu8-> cellID=8
            R.id.bu9-> cellID=9
        }

        PlayGame(cellID,buSelected)
        Draw()
    }

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var ActivePlayer=1

    fun PlayGame(cellID:Int,buSelected:Button){

        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            ActivePlayer=2

        }else{
            buSelected.text="O"
            buSelected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellID)
            ActivePlayer=1
        }
        buSelected.isEnabled=false
        CheckWiner()
        TV.text="$counterA :  $counterB"
    }

    fun IfPlayerWin( a:Int, b:Int, c:Int) :Unit{

        if(player1.contains(a) && player1.contains(b) && player1.contains(c)){
            counterA++
            Toast.makeText(this,"${Player1Name.text.toString()} win the game in $rowcoldiag", Toast.LENGTH_LONG).show()
           onFinish()
        }
        if(player2.contains(a) && player2.contains(b) && player2.contains(c)){
            counterB++
            Toast.makeText(this,"${Player2Name.text.toString()}  win the game in $rowcoldiag", Toast.LENGTH_LONG).show()
            onFinish()
        }
    }

    fun  CheckWiner(){

      fun checkline(a:Int, b:Int, c:Int)=
         when {

             (a==1&&b==2&&c==3)->{
                 rowcoldiag="row1"
                 IfPlayerWin(1,2,3)}
             (a==4&&b==5&&c==6)->{
                 rowcoldiag="row2"
                 IfPlayerWin(4,5,6)}
             (a==7&&b==8&&c==9)->{
                 rowcoldiag="row3"
                 IfPlayerWin(7,8,9)}
             (a==1&&b==4&&c==7)->{
                 rowcoldiag="column1"
                 IfPlayerWin(1,4,7)}
             (a==2&&b==5&&c==8)->{
                 rowcoldiag="column2"
                 IfPlayerWin(2,5,8)}
             (a==3&&b==6&&c==9)->{
                 rowcoldiag="column3"
                 IfPlayerWin(3,6,9)}
             (a==1&&b==5&&c==9)->{
                 rowcoldiag="diagonal1"
                 IfPlayerWin(1,5,9)}
             (a==3&&b==5&&c==7)->{
                 rowcoldiag="diagonal2"
                 IfPlayerWin(3,5,7)}
             else->-1

        }

        checkline(1,2,3)
        checkline(4,5,6)
        checkline(7,8,9)
        checkline(1,4,7)
        checkline(2,5,8)
        checkline(3,6,9)
        checkline(1,5,9)
        checkline(3,5,7)

    }


   fun Draw() {

       var emptyCells = ArrayList<Int>()
       for (cellID in 1..9) {

           if (!(player1.contains(cellID) || player2.contains(cellID))) {
               emptyCells.add(cellID)
           }
       }

       if (emptyCells.isEmpty()) {
           Toast.makeText(this, " Draw", Toast.LENGTH_LONG).show()
           onFinish()
       }

   }

     fun onFinish() {
        recreate()
    }


}
