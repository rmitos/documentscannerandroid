package net.rmitsolutions.documentscannerandroid

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.scanlibrary.ScanActivity
import com.scanlibrary.ScanConstants
import net.rmitsolutions.documentscannerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.takePhoto.setOnClickListener { view ->
            startResult.launch(Intent(this, ScanActivity::class.java))
        }
    }

    private val startResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val uri =
                    result.data!!.extras!!.getParcelable<Uri>(ScanConstants.SCANNED_RESULT)
                binding.imageView.setImageURI(uri)
            }
        }
}
