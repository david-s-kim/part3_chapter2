package com.example.part3_chapter2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.part3_chapter2.databinding.ActivityPinBinding
import com.example.part3_chapter2.widget.ShuffleNumberKeyboard


class PinActivity : AppCompatActivity(), ShuffleNumberKeyboard.KeyPadListener{

    private lateinit var binding: ActivityPinBinding
    private val viewModel: PinViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.shuffleKeyBoard.setKeyPadListener(this)

        viewModel.messageLiveData.observe(this) {
            println(Toast.makeText(this, "", Toast.LENGTH_SHORT))
        }

    }

    override fun onClickNum(num: String) {
        viewModel.input(num)
    }

    override fun onClickDelete() {
        viewModel.delete()
    }

    override fun onClickDone() {
        viewModel.done()
    }

}