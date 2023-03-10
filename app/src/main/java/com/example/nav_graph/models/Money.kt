package com.example.nav_graph.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Money(var amount:BigDecimal):Parcelable