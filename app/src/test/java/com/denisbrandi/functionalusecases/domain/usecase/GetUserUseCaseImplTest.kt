package com.denisbrandi.functionalusecases.domain.usecase

import com.denisbrandi.functionalusecases.domain.model.User
import com.denisbrandi.functionalusecases.domain.repository.fakes.FakeUserRepository
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class GetUserUseCaseImplTest {

    private val userRepository = FakeUserRepository()
    private val sut = GetUserUseCaseImpl(userRepository)

    @Test
    fun `invoke should return repository result`() {
        val dummyUser = User("1234", "JackSparrow")
        userRepository.userResult = dummyUser

        val actual = sut()

        assertThat(actual).isSameInstanceAs(dummyUser)
    }
}