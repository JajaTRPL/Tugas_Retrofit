package com.example.salatprayertime

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas12_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prayerAdapter: PrayerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Fetch data dari API
        fetchPrayerTimes("Jakarta", "Indonesia")
    }

    private fun fetchPrayerTimes(city: String, country: String) {
        ApiClient.apiService.getPrayerTimes(city, country).enqueue(object : Callback<TimingsResponse> {
            override fun onResponse(call: Call<TimingsResponse>, response: Response<TimingsResponse>) {
                if (response.isSuccessful) {
                    val prayerSchedule = response.body()?.data?.timings ?: return
                    prayerAdapter = PrayerAdapter(this@MainActivity, prayerSchedule)
                    binding.recyclerView.adapter = prayerAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load prayer times", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<TimingsResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
