package br.com.leandroferreira.wizardform.contract

abstract class UpdatableWizardPageViewModel<K> : WizardPageViewModel<K>(){
    abstract fun getOnStateChangeListener() : OnStateChangeListener<K>
}