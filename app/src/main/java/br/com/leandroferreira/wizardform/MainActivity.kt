package br.com.leandroferreira.wizardform

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.leandroferreira.wizard_form.contract.Navigator
import br.com.leandroferreira.wizardform.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Navigator{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = MainViewModel(this)
    }

    override fun nextPage() {
        if (viewPager.currentItem < viewPager.adapter.count) {
            viewPager.currentItem = viewPager.currentItem + 1
        }
    }

    override fun previousPage() {
        if (viewPager.currentItem > 0) {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    override fun navigateToPage(page: Int) {
        viewPager.currentItem = page
    }

    override fun cancelNavigation() {
        finish()
    }

    override fun currentPage(): Int = viewPager.currentItem
}
