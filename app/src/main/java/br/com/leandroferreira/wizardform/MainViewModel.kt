package br.com.leandroferreira.wizardform

import android.databinding.ObservableArrayList
import br.com.leandroferreira.wizard_forms.contract.WizardNavigator
import br.com.leandroferreira.wizard_forms.contract.WizardPageViewModel
import br.com.leandroferreira.wizard_forms.contract.WizardStateHolder
import br.com.leandroferreira.wizardform.dto.User
import br.com.leandroferreira.wizardform.pages.PageOneViewModel
import br.com.leandroferreira.wizardform.pages.PageThreeViewModel
import br.com.leandroferreira.wizardform.pages.PageTwoViewModel
import br.com.leandroferreira.wizardform.pages.PageFourViewModel
import me.tatarka.bindingcollectionadapter2.OnItemBind

class MainViewModel(val navigator: WizardNavigator) {

    val itemBinding: OnItemBind<WizardPageViewModel<User>>
        get() = OnItemBind { itemBinding1, position, _ ->
            when (position) {
                0 -> itemBinding1.set(BR.viewModel, R.layout.page1_view)
                1 -> itemBinding1.set(BR.viewModel, R.layout.page2_view)
                2 -> itemBinding1.set(BR.viewModel, R.layout.page3_view)
                3 -> itemBinding1.set(BR.viewModel, R.layout.page4_view)
                else -> throw IllegalArgumentException("There is more viewModel than views!")

            }
        }

    val pages = ObservableArrayList<WizardPageViewModel<User>>()
    val stateHolder = WizardStateHolder<User>(User("", "", ""))

    init {
        pages.add(PageOneViewModel())
        pages.add(PageTwoViewModel())
        pages.add(PageThreeViewModel())
        pages.add(PageFourViewModel())
    }
}