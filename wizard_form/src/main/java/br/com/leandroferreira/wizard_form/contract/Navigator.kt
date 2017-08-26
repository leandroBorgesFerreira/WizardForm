package br.com.leandroferreira.wizardform.contract

interface Navigator : PageChanger {
    override fun nextPage()
    override fun previousPage()

    fun navigateToPage(page: Int)
    fun cancelNavigation()
    fun currentPage() : Int
}