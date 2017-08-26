
# Wizard Form

Library that helps to create wizard form with android databinding eliminating boiler plate code.

This library was built on top of [binding-collection-adapter](https://github.com/evant/binding-collection-adapter)    

![enter image description here](https://lh3.googleusercontent.com/-NrDNxO2TFXc/WaG52kAzVxI/AAAAAAAAAGI/5ARSuzL2DPsS0ZOF0iEl6-uQW_VHwDt1ACLcBGAs/s0/Aug-26-2017+15-11-12.gif "Aug-26-2017 15-11-12.gif")

## Contents

 - [Installation](#installation)
 - [How to use / Sample](#how-to-use)
 - [Bugs and feedback](#bugs-and-feedback)
 - [Credits](#credits)

## Installation

    compile 'br.com.leandroferreira:wizard-form:0.2.0'

## How to use

    <br.com.leandroferreira.wizard_form.views.NonSwipeableWizardPager
          android:id="@+id/viewPager"
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          app:itemBinding="@{viewModel.itemBinding}"
          app:items="@{viewModel.pages}"
          app:navigator="@{viewModel.navigator}"
          app:stateHolder="@{viewModel.stateHolder}"
          />

Navigator must implement Navigator interface. This class is responsible to coordinate the navigation of the pages. 

StateHolder is the class used to hold the state of the from. You need to insert the POJO that you want to track. 

All the fragments ViewModel must implement WizardPageViewModel or UpdatableWizardPageViewModel.

## Bugs and Feedback

For bugs, feature requests, and discussion please use [GitHub Issues](https://github.com/leandroBorgesFerreira/WizardForm/issues).

## Credits

This library was built on top of [binding-collection-adapter] (https://github.com/evant/binding-collection-adapter)    

### And that's it! Enjoy!
