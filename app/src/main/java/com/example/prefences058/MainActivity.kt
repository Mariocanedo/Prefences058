package com.example.prefences058

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import com.example.prefences058.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var  mBinding: ActivityMainBinding
// referencia a la clase que guarda los datos
private lateinit var  sharedPreferncesManager: SharedPreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)



        mBinding.agregar.setOnClickListener{
            guardaDatos()
            mostraDatos()
        }



    }




    fun guardaDatos(){
        sharedPreferncesManager = SharedPreferencesManager(this)
        val wordList= WordList()
         val valor1 =mBinding.valor1.text.toString()
        val valor2 =mBinding.valor2.text.toString()
        wordList.addWord(valor1,valor2)
        sharedPreferncesManager.saveWordList(wordList)

    }

    fun mostraDatos(){
    val saveWordList = sharedPreferncesManager.getWordList()
        mBinding.palabras.setText(saveWordList.toString())

    }
}