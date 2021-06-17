package com.example.rpl.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rpl.adapter.CreateNoteAdapter
import com.example.rpl.model.Notes
import com.android.mailapp.viewmodel.NoteViewModel
import com.example.rpl.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    private var mailAdapter: CreateNoteAdapter? = null
    private lateinit var mailViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mailViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        initiateUI()
        listener()
        observer()

    }

    private fun observer() {
        mailViewModel.listInbox.observe(this, Observer { mail ->
            if (mail != null){
                mailAdapter?.composeMail(mail)
            }
        })
    }

    private fun listener() {
        fabAddNote.setOnClickListener {
            CreateNoteActivity.launchAddNotePage(this@HomeActivity)
        }
    }

    private fun initiateUI(){
        if (mailAdapter == null){
            mailAdapter = CreateNoteAdapter(this, seeMoreDetails = { notes ->
                ViewNoteActivity.launchDetailNote(this, notes)
            })
            with(rv_mail_list_inbox){
                layoutManager = LinearLayoutManager(this@HomeActivity)
                addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
                setHasFixedSize(true)
                adapter = mailAdapter
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CreateNoteActivity.REQUEST_CODE_ADD && resultCode == Activity.RESULT_OK){
            data?.getParcelableExtra<Notes>(CreateNoteActivity.INTENT_NOTE)?.let { notes ->
                mailViewModel.composeMail(notes)
            }
        } else {
            Toast.makeText(this, R.string.empty_not_saved, Toast.LENGTH_SHORT).show()
        }
    }

}