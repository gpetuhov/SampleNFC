# SampleNFC
Reading NFC tag in Android.

## Requirements
* Android Studio 3.5 Canary 8
* Kotlin 1.3.21
* Android Gradle Plugin 3.5.0-alpha08
* Gradle wrapper 5.3-rc-2
* AAPT 2

## Notes
MainActivity shows toast on NFC detected, when running (in Resumed state).

NfcActivity is started by Android with intent, when NFC with appropriate technology is detected. 

## References
https://developer.android.com/guide/topics/connectivity/nfc/nfc

https://developer.android.com/guide/topics/connectivity/nfc/advanced-nfc