package br.com.leandroferreira.wizard_forms.contract

import android.databinding.BaseObservable

abstract class WizardPageViewModel<K>(var navigator: WizardNavigator? = null,
                                      var stateHolder: WizardStateHolder<K>? = null) : BaseObservable()


