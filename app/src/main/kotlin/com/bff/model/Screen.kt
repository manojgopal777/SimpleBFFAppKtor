package com.bff.model

import kotlinx.serialization.Serializable

@Serializable
data class Screen(val name: String, val header: Header, val items: List<Item>)

@Serializable
data class Header(val text: String)

@Serializable
data class Item(val title: String, val subtitle: String, val flag: Boolean = false)
