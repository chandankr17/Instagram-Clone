package com.example.instagramclone.Models

class Reel {
    var reelUrl:String=""
    var caption:String=""
    var profileLink:String?=null
    constructor()
    constructor(caption: String,reelUrl:String) {
        this.caption = caption
        this.reelUrl=reelUrl
    }
    constructor(caption: String,reelUrl:String,profileLink:String) {
        this.caption = caption
        this.reelUrl=reelUrl
        this.profileLink=profileLink
    }
}