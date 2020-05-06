package com.example.projectsmkcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.etumur
import kotlinx.android.synthetic.main.activity_profile.*

class MainActivity : AppCompatActivity() {
    var edtname: EditText? = null
    var spinnerjks: Spinner? = null
    var edtemail: EditText? = null
    var edttelp: EditText? = null
    var edtumur: EditText? = null
    var edtAlamat: EditText? = null

    private var nameinput: String = ""
    private var emailinput: String = ""
    private var telpinput: String = ""
    private var umurinput: String = ""
    private var alamatinput: String = ""
    private var genderinput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtname = findViewById(R.id.etname)
        edtemail = findViewById(R.id.etemail)
        edtumur = findViewById(R.id.etumur)
        spinnerjks = findViewById(R.id.spinnerjk)
        edttelp = findViewById(R.id.ettelp)
        edtAlamat = findViewById(R.id.etalamat)

        btnsave.setOnClickListener { ValidasiInput() }

    }

    private fun ValidasiInput() {
        nameinput = etname.text.toString()
        emailinput = etemail.text.toString()
        telpinput = ettelp.text.toString()
        umurinput = etumur.text.toString()
        alamatinput = etalamat.text.toString()
        genderinput = spinnerjk.selectedItem.toString()


        when {
            nameinput.isEmpty() -> etname.error = "Nama tidak kosong"
            genderinput.equals(
                "Pilih Jenis Kelamin",
                ignoreCase = true
            ) -> tampilToast("Jenis Kelamin harus dipilih")
            emailinput.isEmpty() -> etemail.error = "Email tidak boleh kosong"
            telpinput.isEmpty() -> ettelp.error = "Telp tidak boleh kosong"
            umurinput.isEmpty()-> etumur.error = "umur kosong"
            alamatinput.isEmpty() -> etalamat.error = "Alamat tidak boleh "

            else -> {
                tampilToast("Navigasi ke halaman profil")
                gotoProfilAvtivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.Jenis_Kelamin,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerjk.adapter = adapter
    }


    private fun gotoProfilAvtivity() {
        val Intent = Intent(this, ProfileActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama1", nameinput)
        bundle.putString("gender", genderinput)
        bundle.putString("umur1", umurinput)
        bundle.putString("email", emailinput)
        bundle.putString("telp1", telpinput)
        bundle.putString("alamat1", alamatinput)

        Intent.putExtras(bundle)
        startActivity(Intent)
    }
}
