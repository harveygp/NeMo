package com.example.rpl.ui

class RegisterActivity(private var name: String, private var email: String, private var username: String, private var password: String) {
    init {
        this.name = name
        this.email = email
        this.username = username
        this.password = password
    }

    fun getName(): String{
        return this.name
    }

    fun setName(name: String){
        this.name = name
    }

    fun getEmail(): String{
        return this.email
    }

    fun setEmail(email: String){
        this.email = email
    }

    fun getUsername(): String{
        return this.username
    }

    fun setUsername(firstName: String){
        this.username = username
    }

    fun getPassword(): String{
        return this.password
    }

    fun setPassword(password: String){
        this.password = password
    }

    override fun toString(): String{
        return " " + name + "\n" +
                " " + email + "\n" +
                " " + username + "\n" +
                " " + password
    }


}