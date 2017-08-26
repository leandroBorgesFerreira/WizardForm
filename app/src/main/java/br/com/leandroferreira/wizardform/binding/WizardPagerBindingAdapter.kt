package br.com.leandroferreira.wizardform.binding

import android.databinding.BindingAdapter
import br.com.leandroferreira.wizardform.contract.Navigator
import br.com.leandroferreira.wizardform.contract.StateHolder
import br.com.leandroferreira.wizardform.views.WizardPager
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter
import me.tatarka.bindingcollectionadapter2.ItemBinding

object WizardPagerBindingAdapter {

//    @JvmStatic
//    @BindingAdapter(value = *arrayOf("itemBinding",
//            "items",
//            "adapter",
//            "pageTitles",
//            "navigator",
//            "stateHolder"), requireAll = false)
//    fun <T, K> setAdapter(wizardPager: WizardPager,
//                       itemBinding: ItemBinding<T>?,
//                       items: MutableList<T>,
//                       adapter: BindingViewPagerAdapter<T>?,
//                       pageTitles: BindingViewPagerAdapter.PageTitles<T>?,
//                       navigator: Navigator?,
//                       stateHolder: StateHolder<K>?) {
//
//        val oldAdapter = wizardPager.adapter as BindingViewPagerAdapter<T>?
//
//        val adpt : BindingViewPagerAdapter<T> = adapter ?: oldAdapter ?: BindingViewPagerAdapter()
//
//        adpt.itemBinding = itemBinding
//        adpt.setItems(items)
//        adpt.setPageTitles(pageTitles)
//
//        if (oldAdapter != adapter) {
//            wizardPager.adapter = adapter
//        }
//    }
//
//    @JvmStatic
//    @BindingAdapter(value = *arrayOf("itemBinding",
//            "items",
//            "adapter",
//            "pageTitles"), requireAll = false)
//    fun <T> setAdapter(wizardPager: WizardPager,
//                          itemBinding: ItemBinding<T>?,
//                          items: MutableList<T>,
//                          adapter: BindingViewPagerAdapter<T>?,
//                          pageTitles: BindingViewPagerAdapter.PageTitles<T>?) {
//
//        val oldAdapter = wizardPager.adapter as BindingViewPagerAdapter<T>?
//
//        val adpt : BindingViewPagerAdapter<T> = adapter ?: oldAdapter ?: BindingViewPagerAdapter()
//
//        adpt.itemBinding = itemBinding
//        adpt.setItems(items)
//        adpt.setPageTitles(pageTitles)
//
//        if (oldAdapter != adapter) {
//            wizardPager.adapter = adapter
//        }
//    }
}