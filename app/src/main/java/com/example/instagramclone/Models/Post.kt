package com.example.instagramclone.Models

class Post {
    var postUrl:String=""
    var caption:String=""
    var uid:String=""
    var time:String=""
    constructor()
    constructor(caption: String,postUrl:String) {
        this.caption = caption
        this.postUrl=postUrl
    }
    constructor(caption: String,postUrl:String,uid:String,time:String) {
        this.caption = caption
        this.postUrl=postUrl
        this.uid=uid
        this.time=time
    }
}