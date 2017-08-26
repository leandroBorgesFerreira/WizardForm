package br.com.leandroferreira.wizardform.contract

abstract class WizardPageViewModel<K> {
    var navigator : Navigator? = null
    var stateHolder : StateHolder<K>? = null
}