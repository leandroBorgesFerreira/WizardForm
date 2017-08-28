package br.com.leandroferreira.wizard_forms.binding;

import android.databinding.BindingAdapter;

import java.util.List;

import br.com.leandroferreira.wizard_forms.contract.WizardNavigator;
import br.com.leandroferreira.wizard_forms.contract.WizardStateHolder;
import br.com.leandroferreira.wizard_forms.contract.UpdatableWizardPageViewModel;
import br.com.leandroferreira.wizard_forms.contract.WizardPageViewModel;
import br.com.leandroferreira.wizard_forms.views.WizardPager;
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
                                                                        WizardNavigator wizardNavigator,
                                                                        WizardStateHolder<K> wizardStateHolder) {
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
            wizardPageViewModel.setNavigator(wizardNavigator);
            wizardPageViewModel.setStateHolder(wizardStateHolder);

            if (wizardPageViewModel instanceof UpdatableWizardPageViewModel) {
                if(wizardStateHolder != null) {
                    wizardPageViewModel.getStateHolder().subscribeForStateChange((
                            (UpdatableWizardPageViewModel) wizardPageViewModel).getOnStateChangeListener());
                }
            }
        }

        if (oldAdapter != adapter) {
            wizardPager.setAdapter(adapter);
        }
    }
}
