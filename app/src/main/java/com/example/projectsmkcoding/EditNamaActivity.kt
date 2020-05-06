package com.example.projectsmkcoding

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nama.*

class EditNamaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nama)

        val intentdata = intent.extras
        val namaUser = intentdata.getString("nama")

        edtProfilName.setText(namaUser)

        btnEditSave.setOnClickListener { savedata() }
    }

    private fun savedata() {
        val namaEdit = edtProfilName.text.toString()
        if (!namaEdit.isEmpty()) {
            val result = Intent()
            result.putExtra("nama", namaEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}
