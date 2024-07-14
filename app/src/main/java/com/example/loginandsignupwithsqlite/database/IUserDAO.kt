package com.example.loginandsignupwithsqlite.database

import com.example.loginandsignupwithsqlite.model.User

interface IUserDAO {

    fun insertUser(user: User): Long
    fun readUser(user: User): Boolean
}