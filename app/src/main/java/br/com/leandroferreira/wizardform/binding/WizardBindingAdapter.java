package br.com.leandroferreira.wizardform.binding;

import android.databinding.BindingAdapter;

import java.util.List;

import br.com.leandroferreira.wizardform.contract.Navigator;
import br.com.leandroferreira.wizardform.contract.StateHolder;
import br.com.leandroferreira.wizardform.contract.WizardPageViewModel;
import br.com.leandroferreira.wizardform.pages.PageFourViewModel;
import br.com.leandroferreira.wizardform.views.WizardPager;
import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class WizardBindingAdapter {

    // ViewPager
    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"itemBinding", "items", "adapter", "pageTitles", "navigator", "stateHolder"}, requireAll = false)
    public static <T extends WizardPageViewModel<K>, K> void setAdapter(WizardPager wizardPager,
                                                                     ItemBinding<T> itemBinding,
                                                                     List<T> items,
                                                                     BindingViewPagerAdapter<T> adapter,
                                                                     BindingViewPagerAdapter.PageTitles<T> pageTitles,
                                                                     Navigator navigator,
                                                                     StateHolder<K> stateHolder) {
        if (itemBinding == null) {
            throw new IllegalArgumentException("onItemBind must not be null");
        }

        BindingViewPagerAdapter<T> oldAdapter = (BindingViewPagerAdapter<T>) wizardPager.getAdapter();

        if (adapter == null) {
            if (oldAdapter == null) {
                adapter = new BindingViewPagerAdapter<>();
            } else {
                adapter = oldAdapter;
            }
        }

        adapter.setItemBinding(itemBinding);
        adapter.setItems(items);
        adapter.setPageTitles(pageTitles);

        for (WizardPageViewModel<K> wizardPageViewModel : items) {
            wizardPageViewModel.setNavigator(navigator);
            wizardPageViewModel.setStateHolder(stateHolder);

            if (wizardPageViewModel instanceof PageFourViewModel) {
                ((PageFourViewModel) wizardPageViewModel).init();
            }
        }

        if (oldAdapter != adapter) {
            wizardPager.setAdapter(adapter);
        }
    }
}
