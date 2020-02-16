package com.ravimhzn.daggerinkotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Posts(
    @SerializedName("userId") @Expose var userId: Int,
    @SerializedName("id") @Expose var id: Int,
    @SerializedName("title") @Expose var title: String,
    @SerializedName("body") @Expose var body: String
) {
    constructor() : this(0, 0, "", "") //Empty constructor
}