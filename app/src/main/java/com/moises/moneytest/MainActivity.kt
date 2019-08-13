package com.moises.moneytest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import de.tobiasschuerg.money.Currency
import de.tobiasschuerg.money.Money
import de.tobiasschuerg.money.MoneyList

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            val euro = Currency("EUR", "Euro", 1.0)
            val bitcoin = Currency("XBT", "Bitcoin", 0.000209580) // Oct. 17 2017, 21:00
            val dolar = Currency("USD", "Dolar", 0.89) // Oct. 17 2017, 21:00
            val libra = Currency("USD", "Libra", 1.07) // Oct. 17 2017, 21:00

            val savedMoney = Money(2300.03, euro)

            val euroDolar = savedMoney.convertInto(libra)


            val wallet = MoneyList(euro)
            wallet.add(Money(100.01, euro))
            wallet.add(Money(1.27, euro))
            wallet.add(Money(20, euro))
            wallet.add(Money(13.37, euro))

            Snackbar.make(view, "Videotutoriales TIENET ${savedMoney} y en dolares: ${euroDolar} y en la cartera ${wallet.sum()}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
