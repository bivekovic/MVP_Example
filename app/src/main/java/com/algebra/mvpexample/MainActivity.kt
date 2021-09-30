package com.algebra.mvpexample

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import com.algebra.mvpexample.presenter.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity( ), MainMVP.View {

    private lateinit var presenter   : MainMVP.Presenter;
    private lateinit var progressBar : ProgressBar;

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        presenter = MainActivityPresenter( this )

        setupListeners( )
        initProgressBar( )
    }

    private fun setupListeners( ) {
        etUserName.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged( p0: CharSequence?, p1: Int, p2: Int, p3: Int ) { }
            override fun afterTextChanged( p0: Editable? ) {
                presenter.fullNameUpdated( )
            }

            override fun onTextChanged( text: CharSequence?, p1: Int, p2: Int, p3: Int ) {
                presenter.updateFullName( text.toString( ) )
            }
        })

        etEmail.addTextChangedListener( object : TextWatcher {
            override fun beforeTextChanged( p0: CharSequence?, p1: Int, p2: Int, p3: Int ) { }
            override fun afterTextChanged( p0: Editable? ) {
                presenter.emailUpdated( )
            }

            override fun onTextChanged( text: CharSequence?, p1: Int, p2: Int, p3: Int ) {
                presenter.updateEmail( text.toString( ) )
            }
        })
    }

    private fun initProgressBar( ) {
        progressBar = ProgressBar( this, null, android.R.attr.progressBarStyleSmall )
        progressBar.isIndeterminate = true
        val params = RelativeLayout.LayoutParams(
            Resources.getSystem( ).displayMetrics.widthPixels,
            700
        )
        params.addRule( RelativeLayout.CENTER_IN_PARENT )
        this.addContentView( progressBar, params )
        progressBar.visibility = View.VISIBLE
    }


    override fun updateUserInfo( userInfo : String ) {
        tvUserData.text = userInfo
    }

    override fun showToast( toastText: String ) {
        Toast.makeText( this, toastText, Toast.LENGTH_SHORT ).show( )
    }

    override fun hideProgressBar( ) {
        progressBar.visibility = View.INVISIBLE
    }
}