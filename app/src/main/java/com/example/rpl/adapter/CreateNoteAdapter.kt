package com.example.rpl.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.rpl.model.Notes
import com.example.rpl.R

class CreateNoteAdapter(
    context: Context,
    private val seeMoreDetails: ((Notes) -> Unit)? = null
): RecyclerView.Adapter<CreateNoteAdapter.MailViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var mailInbox = emptyList<Notes>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MailViewHolder {
        val itemView = inflater.inflate(R.layout.item_note, parent, false)
        return MailViewHolder(itemView)
    }

    override fun getItemCount() = mailInbox.size

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        val selectedMail = mailInbox[position]
        with(holder){
            emailAddress.text = selectedMail.emailAddress
            emailContent.text = selectedMail.emailContent
            emailDate.text = DateUtils.getRelativeTimeSpanString(selectedMail.emailDate)
            emailItem.setOnClickListener {
                seeMoreDetails?.invoke(selectedMail)
            }
        }
    }

    inner class MailViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val emailAddress: AppCompatTextView = itemView.findViewById(R.id.tv_mail_title)
        val emailContent: AppCompatTextView = itemView.findViewById(R.id.tv_mail_content)
        val emailDate: AppCompatTextView = itemView.findViewById(R.id.tv_mail_date)
        val emailItem: ConstraintLayout = itemView.findViewById(R.id.item_email)
    }

    internal fun composeMail(mail: List<Notes>){
        this.mailInbox = mail
        notifyDataSetChanged()
    }
}