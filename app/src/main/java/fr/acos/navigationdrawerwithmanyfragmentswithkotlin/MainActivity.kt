package fr.acos.navigationdrawerwithmanyfragmentswithkotlin

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import fr.acos.navigationdrawerwithmanyfragmentswithkotlin.fragments.BonjourFragment
import fr.acos.navigationdrawerwithmanyfragmentswithkotlin.fragments.HelloFragment
import fr.acos.navigationdrawerwithmanyfragmentswithkotlin.fragments.OlaFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Classe représentant l'unique activité de cette application
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{
    /**
     * Objet permettant d'enregister une instance de la classe BonjourFragment.
     */
    private var fragmentBonjour: Fragment? = null;
    /**
     * Objet permettant d'enregister une instance de la classe HelloFragment.
     */
    private var fragmentHello: Fragment? = null;
    /**
     * Objet permettant d'enregister une instance de la classe OlaFragment.
     */
    private var fragmentOla: Fragment? = null;

    /**
     * Identifiant du fragment BonjourFragment.
     */
    private val FRAGMENT_BONJOUR_ID = 0
    /**
     * Identifiant du fragment HelloFragment.
     */
    private val FRAGMENT_HELLO_ID = 1
    /**
     * Identifiant du fragment OlaFragment.
     */
    private val FRAGMENT_OLA_ID = 2

    /**
     * Méthode appelée pour afficher un fragment.
     */
    private fun afficherFragment(identifiantDuFragment: Int)
    {
        when (identifiantDuFragment)
        {
            FRAGMENT_BONJOUR_ID -> this.creationEtAffichageDeBonjourFragment()
            FRAGMENT_HELLO_ID -> this.creationEtAffichageDeHelloFragment()
            FRAGMENT_OLA_ID -> this.creationEtAffichageDeOlaFragment()
        }
    }

    /**
     * Cette fonction créé une instance d'un fragment de type BonjourFragment si cela n'a pas encore été fait.
     * Ensuite cette fonction affiche le fragment dans l'activité à l'aide de la fonction chargementDuFragment.
     */
    private fun creationEtAffichageDeBonjourFragment()
    {
        if (this.fragmentBonjour == null)
        {
            this.fragmentBonjour = BonjourFragment.newInstance()
        }
        this.chargementDuFragment(this.fragmentBonjour)
    }

    /**
     * Cette fonction créé une instance d'un fragment de type BonjourFragment si cela n'a pas encore été fait.
     * Ensuite cette fonction affiche le fragment dans l'activité à l'aide de la fonction chargementDuFragment.
     */
    private fun creationEtAffichageDeHelloFragment() {
        if (this.fragmentHello == null) this.fragmentHello = HelloFragment.newInstance()
        this.chargementDuFragment(this.fragmentHello)
    }

    /**
     * Cette fonction créé une instance d'un fragment de type BonjourFragment si cela n'a pas encore été fait.
     * Ensuite cette fonction affiche le fragment dans l'activité à l'aide de la fonction chargementDuFragment.
     */
    private fun creationEtAffichageDeOlaFragment() {
        if (this.fragmentOla == null) this.fragmentOla = OlaFragment.newInstance()
        this.chargementDuFragment(this.fragmentOla)
    }

    /**
     * Charge le fragment dans l'activité.
     */
    private fun chargementDuFragment(fragment: Fragment?) {
        if (fragment != null) {
            if (!fragment.isVisible) {
                supportFragmentManager.beginTransaction()
                        .replace(fragment_a_afficher.id, fragment).commit()
            }
        }
    }

    /**
     * Fonction onCreate de base auto-généré par l'assistant.
     * (Quelques fonctionnalités ont été supprimées pour la démonstration)
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }

    /**
     * Fonction onBackPressed de base auto-généré par l'assistant.
     */
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
        {
            drawer_layout.closeDrawer(GravityCompat.START)
        }
        else
        {
            super.onBackPressed()
        }
    }

    /**
     * Fonction onCreateOptionsMenu de base auto-généré par l'assistant.
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    /**
     * Fonction onOptionsItemSelected de base auto-généré par l'assistant.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    /**
     * Personnalisation effectué pour la démonstration.
     * Si il ya un clic sur le lien Import alors on affiche le fragment BonjourFragment
     * Si il ya un clic sur le lien Gallery alors on affiche le fragment BonjourFragment
     * Si il ya un clic sur le lien SlideShow alors on affiche le fragment BonjourFragment
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.nav_camera -> this.afficherFragment(FRAGMENT_BONJOUR_ID)
            R.id.nav_gallery -> this.afficherFragment(FRAGMENT_HELLO_ID)
            R.id.nav_slideshow -> this.afficherFragment(FRAGMENT_OLA_ID)
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
