package nl.hva.madlevel5task1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.madlevel5task1.R
import com.example.madlevel5task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController


        fabToggler()
    }

    private fun fabToggler() {
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id in arrayOf(R.id.addNoteFragment)) {
//                binding.fab.hide()
//            } else {
//                binding.fab.show()
//            }
//        }
    }

}