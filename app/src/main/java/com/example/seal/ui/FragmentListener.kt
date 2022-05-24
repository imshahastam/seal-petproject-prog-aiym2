package com.example.seal.ui

import androidx.fragment.app.Fragment

interface FragmentListener {
    fun openFragment(fragment: Fragment, addToBackStack: Boolean? = true) {}
}