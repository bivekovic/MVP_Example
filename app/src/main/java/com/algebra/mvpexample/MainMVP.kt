package com.algebra.mvpexample

interface MainMVP {

    interface View {
        fun updateUserInfo( info : String )
        fun showToast( toastText : String )
        fun hideProgressBar( )
    }

    interface Model {
        fun updateFullName( newFullName : String )
        fun updateEmail( newEMail : String )
        fun displayData( ) : String
    }

    interface Presenter {
        fun updateFullName( newFullName : String )
        fun updateEmail( newEMail : String )
        fun emailUpdated( )
        fun fullNameUpdated( )
    }


}