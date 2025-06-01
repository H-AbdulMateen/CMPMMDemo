package com.abdulmateen.cmpmmdemo.core.ui.utils

object Validator {
    fun validateNonEmpty(text: String): ValidationResult {
        return if (text.isNotEmpty()){
            ValidationResult(isValid = true, errorMessage = "")
        } else {
            ValidationResult(isValid = false, errorMessage = "Field cannot be empty")
        }
    }
}

data class ValidationResult(
    val isValid: Boolean = false,
    val errorMessage: String = ""
)