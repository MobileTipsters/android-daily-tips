// Step 1: Create or retrieve the Master Key for encryption/decryption
val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

// Step 2: Initialize/open an instance of EncryptedSharedPreferences
val sharedPreferences = EncryptedSharedPreferences.create(
        "secret_shared_prefs",
        masterKeyAlias,
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
)


// Step 3: Save data to the EncryptedSharedPreferences as usual
sharedPreferences.edit()
.putString("KEY_VALUE", saveText.text.toString())
.apply()


// Step 4: Read data from EncryptedSharedPreferences as usual
val value = sharedPreferences.getString("KEY_VALUE", "")