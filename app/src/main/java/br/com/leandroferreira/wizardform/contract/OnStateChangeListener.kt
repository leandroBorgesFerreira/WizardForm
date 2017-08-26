package br.com.leandroferreira.wizardform.contract

interface OnStateChangeListener<K> {
    fun getState(stateDto : K)
}