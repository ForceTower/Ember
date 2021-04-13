package dev.forcetower.data.usecase

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(parameters: P): CaseResult<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    CaseResult.Success(it)
                }
            }
        } catch (e: Exception) {
            Timber.d(e)
            CaseResult.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}