package com.example.notlaruygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detay.*
import kotlinx.android.synthetic.main.activity_not_kayit.*
import kotlinx.android.synthetic.main.activity_not_kayit.editTextDers
import kotlinx.android.synthetic.main.activity_not_kayit.editTextNot1
import kotlinx.android.synthetic.main.activity_not_kayit.editTextNot2

class NotKayitActivity : AppCompatActivity() {

    private lateinit var vt : VeritabaniYardimcisi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_kayit)

        vt = VeritabaniYardimcisi(this)

        toolbarNotKayit.title="Not Kayıt"
        setSupportActionBar(toolbarNotKayit)

        buttonKaydet.setOnClickListener {

            val ders_adi = editTextDers.text.toString().trim() //trim sayesinde white space denilen baştaki ve sondaki boşlukları siliniyor
            val not1 = editTextNot1.text.toString().trim()
            val not2 = editTextNot2.text.toString().trim()

            if(TextUtils.isEmpty(ders_adi)){
                Snackbar.make(toolbarNotKayit,"Ders adı giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener //bu if çalışıyorsa sonraki iflere hiç bakma demek yani başa dön
            }

            if(TextUtils.isEmpty(not1)){
                Snackbar.make(toolbarNotKayit,"1. Notu giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener //bu if çalışıyorsa sonraki iflere hiç bakma demek yani başa dön
            }

            if(TextUtils.isEmpty(not2)){
                Snackbar.make(toolbarNotKayit,"2. Notu giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener //bu if çalışıyorsa sonraki iflere hiç bakma demek yani başa dön
            }

            Notlardao().notEkle(vt,ders_adi,not1.toInt(),not2.toInt())


            startActivity(Intent(this@NotKayitActivity,MainActivity::class.java))
            finish()
        }

    }
}