package com.example.prefences058

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    companion object {
        private const val SHARED_PREFERENCES_NAME = "Preferences058"
        private const val  KEY_WORD_LIST= "Wordlist"

    }
    // instanciar las preferencias la clase
    private val  sharedPreferences : SharedPreferences=
        context.getSharedPreferences(SHARED_PREFERENCES_NAME,Context.MODE_PRIVATE)


    fun saveWordList(wordList: WordList){
         val editor = sharedPreferences.edit()
        editor.putString(KEY_WORD_LIST,wordList.getSerializedString())
        editor.apply()

    }

    fun getWordList(): WordList{

        val serializeWordList = sharedPreferences.getString(KEY_WORD_LIST,"")
        return  WordList().apply { deserializeFromString(serializeWordList) }
    }

}