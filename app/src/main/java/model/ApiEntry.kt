package com.example.salatprayertime

data class PrayerSchedule(
    val Fajr: String,
    val Dhuhr: String,
    val Asr: String,
    val Maghrib: String,
    val Isha: String
)

data class TimingsResponse(
    val data: Data
)

data class Data(
    val timings: PrayerSchedule
)