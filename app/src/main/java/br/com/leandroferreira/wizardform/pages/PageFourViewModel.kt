package br.com.leandroferreira.wizardform.pages

import android.databinding.ObservableField
import br.com.leandroferreira.wizard_form.contract.OnStateChangeListener
import br.com.leandroferreira.wizard_form.contract.UpdatableWizardPageViewModel
import br.com.leandroferreira.wizardform.dto.User

class PageFourViewModel : UpdatableWizardPageViewModel<User>() {

    val name = ObservableField<String?>()
    val lastName = ObservableField<String?>()
    val age = ObservableField<String?>()

    init {
        name.set(stateHolder?.stateDto?.name)
        lastName.set(stateHolder?.stateDto?.lastName)
        age.set(stateHolder?.stateDto?.age)
    }

    override fun getOnStateChangeListener(): OnStateChangeListener<User> =
            object : OnStateChangeListener<User> {
                override fun getState(stateDto: User) {
                    name.set(stateDto.name)
                    lastName.set(stateDto.lastName)
                    age.set(stateDto.age)
                }
            }
}