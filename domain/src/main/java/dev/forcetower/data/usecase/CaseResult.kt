package dev.forcetower.data.usecase

sealed class CaseResult<out R> {
    data class Success<out T>(val data: T) : CaseResult<T>()
    data class Error(val exception: Exception) : CaseResult<Nothing>()
    object Loading : CaseResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

val CaseResult<*>.succeeded
    get() = this is CaseResult.Success && data != null

fun <T> CaseResult<T>.successOr(fallback: T): T {
    return (this as? CaseResult.Success<T>)?.data ?: fallback
}

val <T> CaseResult<T>.data: T?
    get() = (this as? CaseResult.Success)?.data
