package br.com.leandroferreira.wizard_forms.contract

interface OnStateChangeListener<K> {
    fun getState(stateDto : K)
}