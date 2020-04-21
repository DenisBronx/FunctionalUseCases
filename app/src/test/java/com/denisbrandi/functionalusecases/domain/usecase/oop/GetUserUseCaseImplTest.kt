package com.denisbrandi.functionalusecases.domain.usecase.oop

import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.UserRepository
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Test

class GetUserUseCaseImplTest {

    private val userRepository: UserRepository = mock()
    private val sut = GetUserUseCaseImpl(userRepository)

    @Test
    fun `invoke should return repository result`() {
        val dummyUser = User("1234", "JackSparrow")
        whenever(userRepository.getUser()).thenReturn(dummyUser)

        val actual = sut()

        assertThat(actual).isEqualTo(dummyUser)
    }
}