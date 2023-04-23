package com.geektech.l_1_m_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.bumptech.glide.Glide
import com.geektech.l_1_m_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf(
        "https://img3.akspic.ru/previews/5/5/4/1/7/171455/171455-zhivopis-illustracia-art-voda-oblako-500x.jpg",
        "https://i.pinimg.com/564x/55/36/c8/5536c8edc514d16064a65f3e20d8e181.jpg",
        "https://pibig.info/uploads/posts/2022-07/1657196778_1-pibig-info-p-krasivie-letnie-kartinki-na-telefon-1.jpg",
        "https://klike.net/uploads/posts/2022-07/1658294080_1.jpg",
        "https://klike.net/uploads/posts/2022-07/1658294080_1.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSubmit.setOnClickListener {
            val url = binding.etUrl.text.toString()
            if (Patterns.WEB_URL.matcher(url).matches()) {
                list.add(url)
                binding.etUrl.text.clear()
            } else {
                Toast.makeText(this, "Url is not validate", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRandom.setOnClickListener {
            val item = list.random()
            Glide.with(this).load(item).into(binding.ivImage)
        }
    }
}