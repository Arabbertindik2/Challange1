package com.example.projectsmkcoding

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_nama.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambildata()
        btneditname.setOnClickListener { navigasiedit() }
        btndial.setOnClickListener { dialPhoneNumber(edttelp.text.toString()) }
        btnabout.setOnClickListener { about() }
    }

    private fun about() {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun dialPhoneNumber(phoneNumber : String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel: $phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    companion object {
        val REQUEST_CODE = 100
    }

    private fun navigasiedit() {
        val intent = Intent(this, EditNamaActivity::class.java)

        val namaUser = edtname.text.toString()
        intent.putExtra("nama", REQUEST_CODE)

        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                edtname.text = result
            } else {
                Toast.makeText(this, "Edit failed", Toast.LENGTH_SHORT).show()
            }
        }
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
