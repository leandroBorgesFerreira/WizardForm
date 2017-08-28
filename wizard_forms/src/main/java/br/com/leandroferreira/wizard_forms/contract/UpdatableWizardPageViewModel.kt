package br.com.leandroferreira.wizard_forms.contract

abstract class UpdatableWizardPageViewModel<K>(navigator: WizardNavigator? = null,
                                               stateHolder: WizardStateHolder<K>? = null) :
        WizardPageViewModel<K>(navigator, stateHolder){
    abstract fun getOnStateChangeListener() : OnStateChangeListener<K>
}