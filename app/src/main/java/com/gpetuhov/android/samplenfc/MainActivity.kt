package com.gpetuhov.android.samplenfc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.app.PendingIntent
import android.nfc.NfcAdapter
import android.nfc.Tag
import com.pawegio.kandroid.toast

// MainActivity uses Foreground Dispatch System to intercept an intent
// and claim priority over other activities that handle the same intent.

// By default NFC intent is dispatched to the application, that most fits the intent
// (NFC technologies used, data type).

// Here MainActivity does NOT have intent filter to catch NFC intents,
// but shows toast on NFC discovered, when is RUNNING.

class MainActivity : AppCompatActivity() {

    private lateinit var nfcAdapter: NfcAdapter
    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
    }

    override fun onResume() {
        super.onResume()
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, null, null)
    }

    override fun onPause() {
        super.onPause()
        nfcAdapter.disableForegroundDispatch(this)
    }

    // onNewIntent is NOT called in newly created activity!
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val tag: Tag? = intent?.getParcelableExtra(NfcAdapter.EXTRA_TAG)

        if (tag != null) {
            // This toast will show up, if MainActivity is resumed only
            toast("NFC discovered")
        }
    }
}
