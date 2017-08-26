package br.com.leandroferreira.wizardform.pages

import android.databinding.ObservableField
import br.com.leandroferreira.wizardform.contract.WizardPageViewModel
import br.com.leandroferreira.wizardform.dto.User

class PageTwoViewModel : WizardPageViewModel<User>() {

    val lastName = ObservableField<String>()

    fun goClick() {
        stateHolder?.stateDto?.lastName = lastName.get()
        stateHolder?.notifyStateChange()
        navigator?.nextPage()
    }
}