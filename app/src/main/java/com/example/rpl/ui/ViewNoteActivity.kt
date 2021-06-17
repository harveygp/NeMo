package com.example.rpl.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.rpl.model.Notes
import com.android.mailapp.viewmodel.NoteViewModel
import com.example.rpl.R
import kotlinx.android.synthetic.main.activity_view_note.*

class ViewNoteActivity : AppCompatActivity() {

    private var notes: Notes? = null
    private lateinit var notesViewModel: NoteViewModel

    companion object{

        const val INTENT_NOTE_ADD = "intent_note_add"

        fun launchDetailNote(activity: AppCompatActivity, notes: Notes){
            val intent = Intent(activity, ViewNoteActivity::class.java)
            intent.putExtra(INTENT_NOTE_ADD, notes)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_note)
        notesViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        handleIntent()
        initUI()
        listener()

        val backToMainActivity = findViewById<View>(R.id.btn_detail_note_back)
        backToMainActivity.setOnClickListener {
            onBackPressed()
        }
    }

    private fun handleIntent() {
        notes = intent.getParcelableExtra(INTENT_NOTE_ADD)
    }

    private fun initUI() {
        updateUI(notes)
    }

    private fun updateUI(notes: Notes?) {
        tv_mail_title.text = notes?.emailAddress
        tv_mail_content.text = notes?.emailContent
    }

    private fun listener() {
        btn_delete_note.setOnClickListener {
            notesViewModel.deleteMail(notes?.id ?: 0)
            finish()
        }

        btn_edit_note.setOnClickListener {
            CreateNoteActivity.launchAddNotePage(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CreateNoteActivity.REQUEST_CODE_ADD && resultCode == Activity.RESULT_OK){
            data?.getParcelableExtra<Notes>(CreateNoteActivity.INTENT_NOTE)?.let { notes ->
                this.notes?.let { oldNote ->
                    oldNote.emailAddress = notes.emailAddress
                    oldNote.emailContent = notes.emailContent
                    notesViewModel.editMail(oldNote)
                    updateUI(oldNote)
                }
            }
        } else {
            Toast.makeText(this, R.string.empty_not_saved, Toast.LENGTH_SHORT).show()
        }
    }

}