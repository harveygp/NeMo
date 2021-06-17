package com.example.rpl.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.example.rpl.model.Notes
import com.example.rpl.R
import kotlinx.android.synthetic.main.activity_create_note.*

class CreateNoteActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE_ADD = 1000
        const val INTENT_NOTE = "intent_note"

        fun launchAddNotePage(activity: Activity) {
            val intent = Intent(activity, CreateNoteActivity::class.java)
            activity.startActivityForResult(intent, REQUEST_CODE_ADD)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        listener()
    }

    private fun listener() {
        btn_save_note.setOnClickListener {
            val data = Intent()
            val emailAddress = et_title_create_note.text.toString().trim()
            val mailContent = et_content_create_note.text.toString().trim()
            val createdAt = System.currentTimeMillis()
            if (TextUtils.isEmpty(emailAddress)) {
                setResult(Activity.RESULT_CANCELED, data)
            } else {
                val note = Notes(
                    emailAddress = emailAddress,
                    emailContent = mailContent,
                    emailDate = createdAt
                )
                data.putExtra(INTENT_NOTE, note)
                setResult(Activity.RESULT_OK, data)
            }

            finish()
        }

        btn_add_note_back.setOnClickListener {
            onBackPressed()
        }
    }
}