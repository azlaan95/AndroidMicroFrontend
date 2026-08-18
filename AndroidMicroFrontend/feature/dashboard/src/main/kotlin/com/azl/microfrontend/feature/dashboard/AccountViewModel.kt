package com.azl.microfrontend.feature.dashboard

import androidx.lifecycle.ViewModel
import com.azl.microfrontend.core.database.dao.UserSessionDao
import com.azl.microfrontend.core.database.entity.UserSessionEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val userSessionDao: UserSessionDao
) : ViewModel() {
    val userSession: Flow<UserSessionEntity?> = userSessionDao.getSession()
}
