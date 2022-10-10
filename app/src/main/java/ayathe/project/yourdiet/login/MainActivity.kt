package ayathe.project.yourdiet.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ayathe.project.yourdiet.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private var loginFragment = LoginFragment()
    private var registerFragment = RegisterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        fragmentsReplacement(loginFragment)
        bottom_nav_login.setOnItemSelectedListener {
            when(it.itemId){
                R.id.login -> fragmentsReplacement(loginFragment)
                R.id.register -> fragmentsReplacement(registerFragment)
            }
            true
        }
    }

    fun fragmentsReplacement(fragment: Fragment){
        val fragmentContainer = supportFragmentManager.beginTransaction()
        fragmentContainer.replace(R.id.login_container, fragment)
        fragmentContainer.commit()
    }
}