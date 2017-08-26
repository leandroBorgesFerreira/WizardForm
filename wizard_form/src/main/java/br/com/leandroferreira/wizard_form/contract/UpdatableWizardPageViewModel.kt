package br.com.leandroferreira.wizard_form.contract

abstract class UpdatableWizardPageViewModel<K> : WizardPageViewModel<K>(){
    abstract fun getOnStateChangeListener() : OnStateChangeListener<K>
}