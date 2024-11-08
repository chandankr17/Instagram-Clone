package com.example.instagramclone.Models

class User {
    var image:String?=null
    var name:String?=null
    var email:String?=null
    var password:String?=null
    constructor()
    constructor(email: String?,name:String?,image:String?,password:String?) {
        this.email = email
        this.name=name
        this.password=password
        this.image=image
    }
    constructor(email: String?,name:String?,password:String?) {
        this.email = email
        this.name=name
        this.password=password
    }

    constructor(email: String?,password:String?) {
        this.email = email
        this.password=password
    }


}