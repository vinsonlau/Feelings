package com.example.feelings

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.format.DateUtils
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.feeling_record.*

class AddActivity : AppCompatActivity() {
    private var mood: Int = 2 //1 = sad, 2 = neutral, 3 = happy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        buttonSave.setOnClickListener{
            saveFeeling()
        }

        imageViewHappy.setOnClickListener {
            mood = 3
            it.setBackgroundColor(Color.GRAY)
            imageViewNeutral.setBackgroundColor(Color.WHITE)
            imageViewSad.setBackgroundColor(Color.WHITE)
        }

        imageViewNeutral.setOnClickListener {
            mood = 2
            it.setBackgroundColor(Color.GRAY)
            imageViewHappy.setBackgroundColor(Color.WHITE)
            imageViewSad.setBackgroundColor(Color.WHITE)
        }

        imageViewSad.setOnClickListener {
            mood = 1
            it.setBackgroundColor(Color.GRAY)
            imageViewNeutral.setBackgroundColor(Color.WHITE)
            imageViewHappy.setBackgroundColor(Color.WHITE)
        }
    }

    private fun saveFeeling(){

        if(TextUtils.isEmpty(editTextRemark.text)) {
            editTextRemark.setError("Value is required")
            return
        }

        val remark = editTextRemark.text.toString()
        //val dateCreated =
        val intent = Intent()
        intent.putExtra(EXTRA_MOOD, mood)
        intent.putExtra(EXTRA_REMARK, remark)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }

    companion object{
        const val EXTRA_MOOD = "com.example.feelings.MOOD"
        const val EXTRA_REMARK = "com.example.feelings.REMARK"
    }
}
