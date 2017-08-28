package br.com.leandroferreira.wizard_forms.contract

import android.databinding.BaseObservable

abstract class WizardPageViewModel<K> : BaseObservable() {
    var navigator : Navigator? = null
    var stateHolder : StateHolder<K>? = null
}