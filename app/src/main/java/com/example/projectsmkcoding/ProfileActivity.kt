package com.example.projectsmkcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambildata()
    }

    private fun ambildata() {
        val bundle = intent.extras

        val nama = bundle?.getString("nama1")
        val gender = bundle?.getString("gender")
        val umur = bundle?.getString("umur1")
        val email = bundle?.getString("email")
        val telp = bundle?.getString("telp1")
        val alamat = bundle?.getString("alamat1")

        edtname.text = nama
        jk.text = gender
        edtumur.text = umur
        edtemail.text = email
        edttelp.text = telp
        edtalamat.text = alamat
    }
}
