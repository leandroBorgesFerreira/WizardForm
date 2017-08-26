package br.com.leandroferreira.wizardform.pages

import android.databinding.ObservableField
import br.com.leandroferreira.wizard_form.contract.WizardPageViewModel
import br.com.leandroferreira.wizardform.dto.User

class PageThreeViewModel : WizardPageViewModel<User>() {

    val age = ObservableField<String>()

    fun goClick() {
        stateHolder?.stateDto?.age = age.get()
        stateHolder?.notifyStateChange()
        navigator?.nextPage()
    }
}