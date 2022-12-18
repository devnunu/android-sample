package com.devnunu.sample.model

sealed class BottomSheetState<out T>(open val tag: T) {
    data class Opened<out T>(override val tag: T) : BottomSheetState<T>(tag = tag)
    data class Closed<out T>(override val tag: T) : BottomSheetState<T>(tag = tag)
}