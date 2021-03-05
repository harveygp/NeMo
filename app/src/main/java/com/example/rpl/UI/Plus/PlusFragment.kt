package com.example.rpl.UI.Plus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.rpl.R
import kotlinx.android.synthetic.main.fragment_plus.*

class PlusFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(activity, R.anim.rotate_open_anim) }
    private val rotateCLose: Animation by lazy { AnimationUtils.loadAnimation(activity, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(activity, R.anim.from_bottom_anim) }
    private val tobottom: Animation by lazy { AnimationUtils.loadAnimation(activity, R.anim.to_bottom_anim) }

    private var clicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addButton.setOnClickListener {
            onAddButtonClicked()
        }

        noteButton.setOnClickListener{
            Toast.makeText(activity, "masuk nih", Toast.LENGTH_SHORT).show()
        }

        ListButton.setOnClickListener{
            Toast.makeText(activity, "masuk nih", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onAddButtonClicked(){
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean){
        if(!clicked){
            noteButton.startAnimation(fromBottom)
            ListButton.startAnimation(fromBottom)
            addButton.startAnimation(rotateOpen)
        }else{
            noteButton.startAnimation(tobottom)
            ListButton.startAnimation(tobottom)
            addButton.startAnimation(rotateCLose)
        }
    }

    private fun setVisibility(clicked: Boolean){
        if(!clicked){
            noteButton.visibility = View.VISIBLE
            ListButton.visibility = View.VISIBLE
        }else{
            noteButton.visibility = View.INVISIBLE
            ListButton.visibility = View.INVISIBLE
        }
    }

    private fun setClickable(clicked: Boolean){
        if(!clicked){
            noteButton.isClickable = true
            ListButton.isClickable = true
        }else{
            noteButton.isClickable = false
            ListButton.isClickable = false
        }
    }
}