package com.myres.noban.mvvmrxjava.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Posts(
	val id: Int?,
	val userId: Int?,
	val title: String?,
	val body: String?
) : Parcelable