package lat.pam.tugasnavigation


import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        navigationView = findViewById(R.id.bottom_navigation)
        supportFragmentManager.beginTransaction().replace(R.id.Body_container, HomeFragment()).commit()
        navigationView.setSelectedItemId(R.id.nav_home)

        navigationView.setOnNavigationItemSelectedListener { item ->
            var fragment: androidx.fragment.app.Fragment? = null
            when (item.itemId) {
                R.id.nav_home -> fragment = HomeFragment()
                R.id.nav_search -> fragment = SearchFragment()
                R.id.nav_Like -> fragment = LikeFragment()
                R.id.nav_Account -> fragment = AccountFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.Body_container, fragment!!).commit()

            return@setOnNavigationItemSelectedListener true
        }
    }
}
