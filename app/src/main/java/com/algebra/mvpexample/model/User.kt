package com.algebra.mvpexample.model

import com.algebra.mvpexample.MainMVP

class User( ) : MainMVP.Model {

    var fullName = ""
    var eMail    = ""


    override fun updateFullName( newFullName: String ) {
        fullName = newFullName
    }

    override fun updateEmail( newEMail: String ) {
        eMail = newEMail
    }

    override fun displayData(): String {
        return """Full name: ${fullName} 
            |Mail: ${eMail}
        """.trimMargin()
    }
}