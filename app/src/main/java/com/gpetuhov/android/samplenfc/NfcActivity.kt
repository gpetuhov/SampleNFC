package com.gpetuhov.android.samplenfc

import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.NfcA
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_nfc.*

class NfcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nfc)

        showTagContents()
    }

    // Get tag contents using NfcA technology
    private fun showTagContents() {
        val tag: Tag? = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)

        if (tag != null) {
            val nfca = NfcA.get(tag)
            if (nfca != null) {
                nfca.connect()
                val byteArray = nfca.atqa
                val text = "Tag contents: ${String(byteArray)}"
                text_view.text = text
            }
        }
    }
}