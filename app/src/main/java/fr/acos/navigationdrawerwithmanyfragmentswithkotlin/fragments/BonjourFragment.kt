package fr.acos.navigationdrawerwithmanyfragmentswithkotlin.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import fr.acos.navigationdrawerwithmanyfragmentswithkotlin.R

/**
 * Classe représentant un fragment.
 */
class BonjourFragment : Fragment() {

    /**
     * Chargement de la vue qui affiche Bonjour. (fragment_bonjour.xml)
     */
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_bonjour, container, false)
    }

    /**
     * Factiory : utlisation recommandée par google.
     */
    companion object {
        fun newInstance(): BonjourFragment = BonjourFragment()
    }
}
