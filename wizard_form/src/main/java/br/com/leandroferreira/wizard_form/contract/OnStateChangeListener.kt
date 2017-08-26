package br.com.leandroferreira.wizard_form.contract

interface OnStateChangeListener<K> {
    fun getState(stateDto : K)
}