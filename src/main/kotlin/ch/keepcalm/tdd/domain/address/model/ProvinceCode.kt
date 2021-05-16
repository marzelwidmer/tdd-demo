package ch.keepcalm.tdd.domain.address.model

// Domain Primitive
data class ProvinceCode(val value: String = "") {
    private val minLength = 2
    private val maxLength = 20
    private val validationMessageLength = "$javaClass Domain Primitive Validation Error (<$maxLength | >$minLength): [${value}] have a wrong length of [${value.length}] characters."
    private val validationMessageNotEmpty = "value must be non-empty"

    init {
        require(value.isNotEmpty()) { validationMessageNotEmpty }
        require(value.trim().length >= minLength) { validationMessageLength }
        require(value.trim().length <= maxLength) { validationMessageLength }
    }

    override fun toString() = value
}
