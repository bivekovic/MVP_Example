package com.algebra.mvpexample.presenter

import com.algebra.mvpexample.MainMVP
import com.algebra.mvpexample.model.User

class MainActivityPresenter( val view : MainMVP.View ) : MainMVP.Presenter {

    private val model : MainMVP.Model = User( )

    override fun updateFullName( newFullName: String ) {
        model.updateFullName( newFullName )
        val userInfoText = model.displayData( )
        view.updateUserInfo( userInfoText )
    }

    override fun updateEmail( newEMail: String ) {
        model.updateEmail( newEMail )
        val userInfoText = model.displayData( )
        view.updateUserInfo( userInfoText )
        view.showToast( "Email updated" )
    }

    override fun emailUpdated( ) {
        view.hideProgressBar( )
    }

    override fun fullNameUpdated( ) {
        view.hideProgressBar( )
    }

}