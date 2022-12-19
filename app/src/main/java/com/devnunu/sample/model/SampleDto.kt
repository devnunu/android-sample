package com.devnunu.sample.model

data class SampleDto(
    val firstData: String? = null,
    val secondData: String? = null
)

class SampleDtoProvider {

    var dto: SampleDto? = null
        private set

    fun clearDto(): SampleDtoProvider {
        dto = SampleDto()
        return this
    }

    fun setSampleFirstData(
        firstData: String,
    ) {
        dto = (dto ?: SampleDto()).copy(
            firstData = firstData
        )
    }

    fun setSampleSecondData(
        secondData: String
    ) {
        dto = (dto ?: SampleDto()).copy(
            secondData = secondData
        )
    }
}