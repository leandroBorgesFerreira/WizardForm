package br.com.leandroferreira.wizard_forms.contract

import java.io.Serializable

open class WizardStateHolder<K>(var stateDto : K) : Serializable {

    @Transient
    private var subscriberList: MutableList<OnStateChangeListener<K>> = mutableListOf()

    fun notifyStateChange() = subscriberList.forEach { listener -> listener.getState(stateDto) }

    fun subscribeForStateChange(listener: OnStateChangeListener<K>) = subscriberList.add(listener)

    private fun readObject(input: java.io.ObjectInputStream) {
        input.defaultReadObject()
        subscriberList = mutableListOf()
    }
}
