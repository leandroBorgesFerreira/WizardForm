package br.com.leandroferreira.wizard_form.contract

abstract class WizardPageViewModel<K> {
    var navigator : Navigator? = null
    var stateHolder : StateHolder<K>? = null
}