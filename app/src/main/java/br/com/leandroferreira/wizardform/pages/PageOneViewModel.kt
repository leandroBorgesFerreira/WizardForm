package br.com.leandroferreira.wizardform.pages

import android.databinding.ObservableField
import br.com.leandroferreira.wizardform.contract.WizardPageViewModel
import br.com.leandroferreira.wizardform.dto.User

class PageOneViewModel: WizardPageViewModel<User>() {

    val name = ObservableField<String>()

    fun goClick() {
        stateHolder?.stateDto?.name = name.get()
        stateHolder?.notifyStateChange()
        navigator?.nextPage()
    }
}