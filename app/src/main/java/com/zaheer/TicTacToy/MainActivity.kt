package com.zaheer.TicTacToy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    protected fun buClick(view:View){
        val buSelected= view as Button
        var cellID=0
        when(buSelected.id){
            R.id.bo1-> cellID= 1
            R.id.bo2-> cellID= 2
            R.id.bo3-> cellID= 3
            R.id.bo4-> cellID= 4
            R.id.bo5-> cellID= 5
            R.id.bo6-> cellID= 6
            R.id.bo7-> cellID= 7
            R.id.bo8-> cellID= 8
            R.id.bo9-> cellID= 9
        }

       // Toast.makeText(this,"ID:"+ cellID,Toast.LENGTH_LONG).show()
        PlayGame(cellID,buSelected)

    }
    var Player1=ArrayList<Int>()
    var Player2=ArrayList<Int>()
    var ActivePlayer=1

    fun PlayGame(cellID:Int,buSelected:Button){
        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.BLUE)
            Player2.add(cellID)
            ActivePlayer=1
        }
        buSelected.isEnabled=false
        CheckWiner()
    }

    fun CheckWiner(){
        var winner=-1

        //row1
        if(Player1.contains(1)&&Player1.contains(2)&&Player1.contains(3)){
            winner=1
        }
        if(Player2.contains(1)&&Player2.contains(2)&&Player2.contains(3)){
            winner=2
        }

        //row2
        if(Player1.contains(4)&&Player1.contains(5)&&Player1.contains(6)){
            winner=1
        }
        if(Player2.contains(4)&&Player2.contains(5)&&Player2.contains(6)){
            winner=2
        }
        //row3
        if(Player1.contains(7)&&Player1.contains(8)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(7)&&Player2.contains(8)&&Player2.contains(9)){
            winner=2
        }

        //col1
        if(Player1.contains(1)&&Player1.contains(4)&&Player1.contains(7)){
            winner=1
        }
        if(Player2.contains(1)&&Player2.contains(4)&&Player2.contains(7)){
            winner=2
        }
        //col2
        if(Player1.contains(2)&&Player1.contains(5)&&Player1.contains(8)){
            winner=1
        }
        if(Player2.contains(2)&&Player2.contains(5)&&Player2.contains(8)){
            winner=2
        }
        //col3
        if(Player1.contains(3)&&Player1.contains(6)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(3)&&Player2.contains(6)&&Player2.contains(9)){
            winner=2
        }
        //dal1
        if(Player1.contains(1)&&Player1.contains(5)&&Player1.contains(9)){
            winner=1
        }
        if(Player2.contains(1)&&Player2.contains(5)&&Player2.contains(9)){
            winner=2
        }
        //dal2
        if(Player1.contains(7)&&Player1.contains(5)&&Player1.contains(3)){
            winner=1
        }
        if(Player2.contains(7)&&Player2.contains(5)&&Player2.contains(3)){
            winner=2
        }
        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"Player 1 win the game",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player 2 win the game",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun AutoPlay(){
        var emptyCells=ArrayList<Int>()
        for (cellID in 1..9){
            if(!(Player1.contains(cellID) || Player2.contains(cellID))){
                emptyCells.add(cellID)
            }
        }

        val r=Random
        val randIndex=r.nextInt(emptyCells.size-0)+0
        val cellID=emptyCells[randIndex]

        var buSelected:Button?
        when(cellID){
            1->buSelected=bo1
            2->buSelected=bo2
            3->buSelected=bo3
            4->buSelected=bo4
            5->buSelected=bo5
            6->buSelected=bo6
            7->buSelected=bo7
            8->buSelected=bo8
            9->buSelected=bo9
            else->{
                buSelected=bo1
            }
        }

        PlayGame(cellID,buSelected)

    }
}
