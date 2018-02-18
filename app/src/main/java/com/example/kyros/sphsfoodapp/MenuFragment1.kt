package com.example.kyros.sphsfoodapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.menu_fragment_1.*

/**
 * Created by Kyros on 2/17/2018.
 */
class MenuFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.menu_fragment_1, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
    }
}