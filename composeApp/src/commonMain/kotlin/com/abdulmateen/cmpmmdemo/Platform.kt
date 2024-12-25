package com.abdulmateen.cmpmmdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform