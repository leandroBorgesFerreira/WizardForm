package br.com.leandroferreira.wizard_forms.contract

open class StateHolder<K>(var stateDto : K) {

    private val subscriberList: MutableList<OnStateChangeListener<K>> = mutableListOf()

    fun notifyStateChange() = subscriberList.forEach { listener -> listener.getState(stateDto) }

    fun subscribeForStateChange(listener: OnStateChangeListener<K>) = subscriberList.add(listener)

}