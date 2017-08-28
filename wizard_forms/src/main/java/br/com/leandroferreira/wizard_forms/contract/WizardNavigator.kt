package br.com.leandroferreira.wizard_forms.contract

interface WizardNavigator : PageChanger {
    override fun nextPage()
    override fun previousPage()

    fun navigateToPage(page: Int)
    fun cancelNavigation()
    fun currentPage() : Int
}