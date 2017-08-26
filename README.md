
# Wizard Form

Library that helps to create wizard form with android databinding eliminating boiler plate code.

This library was built on top of [binding-collection-adapter](https://github.com/evant/binding-collection-adapter)    

![enter image description here](https://lh3.googleusercontent.com/-NrDNxO2TFXc/WaG52kAzVxI/AAAAAAAAAGI/5ARSuzL2DPsS0ZOF0iEl6-uQW_VHwDt1ACLcBGAs/s0/Aug-26-2017+15-11-12.gif "Aug-26-2017 15-11-12.gif")

## Contents

 - [Installation](#installation)
 - [Important classes](#important-classes)
 - [Tutorial](#tutorial)
 - [Bugs and feedback](#bugs-and-feedback)
 - [Credits](#credits)

## Installation

    compile 'br.com.leandroferreira:wizard-form:0.2.0'

## Important classes  
          
### WizardPager
Implementation of the ViewPager specialised for wizard forms. 

### Navigator 
Navigator must implement Navigator interface. This class is responsible to coordinate the navigation of the pages. 

### StateHolder

StateHolder is the class used to hold the state of the from. You need to insert the POJO that you want to track. 

### WizardPageViewModel/ UpdatableWizardPageViewModel

All the fragments ViewModel of fragments of WizardPager must implement WizardPageViewModel or UpdatableWizardPageViewModel. 

## Tutorial
**1 - Add the XML of the WizardPager**

    <br.com.leandroferreira.wizard_form.views.NonSwipeableWizardPager
          android:id="@+id/viewPager"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          app:itemBinding="@{viewModel.itemBinding}"
          app:items="@{viewModel.pages}"
          app:navigator="@{viewModel.navigator}"
          app:stateHolder="@{viewModel.stateHolder}"
          />

**2 - Create a navigator:**

    class ViewPagerNavigator : Navigator {
	    override fun nextPage() {
            if (viewPager.currentItem < viewPager.adapter.count) {
               viewPager.currentItem = viewPager.currentItem + 1
            }
        }

        override fun previousPage() {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }

       override fun navigateToPage(page: Int) {
             viewPager.currentItem = page
        }

        override fun cancelNavigation() {
            finish()
        }

        override fun currentPage(): Int = viewPager.currentItem
    }

**3 - Define a DTO (data transfer object) to be used in the StateHolder. Example:**
  

    data class User(var name: String?, var lastName : String?, var age : String?)

**4 - Create a StateHolder, that is going to be inserted in the WizardPager/UpdatableWizardPager**

    val stateHolder = StateHolder<User>(User("", "", ""))

**5 - Define all your pages and implement UpdatableWizardPageViewModel or WizardPageViewModel. Example:**

    class PageFourViewModel : UpdatableWizardPageViewModel<User>() {

    val name = ObservableField<String?>()
    val lastName = ObservableField<String?>()
    val age = ObservableField<String?>()

    init {
        name.set(stateHolder?.stateDto?.name)
        lastName.set(stateHolder?.stateDto?.lastName)
        age.set(stateHolder?.stateDto?.age)
    }

    override fun getOnStateChangeListener(): OnStateChangeListener<User> =
            object : OnStateChangeListener<User> {
                override fun getState(stateDto: User) {
                    name.set(stateDto.name)
                    lastName.set(stateDto.lastName)
                    age.set(stateDto.age)
                }
            }
    }

**6 - Bind your dependencies just like you would with [binding-collection-adapter](https://github.com/evant/binding-collection-adapter)    . Example of viewModel:** 


    class MainViewModel(val navigator: Navigator) {
       val itemBinding:     OnItemBind<WizardPageViewModel<User>>
        get() = OnItemBind { itemBinding1, position, _ ->
                when (position) {
                   0 -> itemBinding1.set(BR.viewModel, R.layout.page1_view)
                   1 -> itemBinding1.set(BR.viewModel, R.layout.page2_view)
                   2 -> itemBinding1.set(BR.viewModel, R.layout.page3_view)
                   3 -> itemBinding1.set(BR.viewModel, R.layout.page4_view)
                   else -> throw IllegalArgumentException("There is more viewModel than views!")

               }
            }

        val pages = ObservableArrayList<WizardPageViewModel<User>>()
        val stateHolder = StateHolder<User>(User("", "", ""))

         init {
            pages.add(PageOneViewModel())
            pages.add(PageTwoViewModel())
            pages.add(PageThreeViewModel())
            pages.add(PageFourViewModel())
         }
    }


**For a complete example, you can check this repository for an example of the app shown in the gif above** 

## Bugs and Feedback

For bugs, feature requests, and discussion please use [GitHub Issues](https://github.com/leandroBorgesFerreira/WizardForm/issues).

## Credits

This library was built on top of [binding-collection-adapter](https://github.com/evant/binding-collection-adapter)    

### And that's it! Enjoy!
