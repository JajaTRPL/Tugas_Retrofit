package com.example.salatprayertime

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas12_retrofit.databinding.ItemPrayerTimeBinding

class PrayerAdapter(
    private val context: Context,
    private val prayerTimes: PrayerSchedule
) : RecyclerView.Adapter<PrayerAdapter.PrayerViewHolder>() {

    inner class PrayerViewHolder(private val binding: ItemPrayerTimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(prayerName: String, prayerTime: String) {
            binding.tvPrayerName.text = prayerName
            binding.tvPrayerTime.text = prayerTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrayerViewHolder {
        val binding = ItemPrayerTimeBinding.inflate(LayoutInflater.from(context), parent, false)
        return PrayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PrayerViewHolder, position: Int) {
        val prayerNames = listOf("Fajr", "Dhuhr", "Asr", "Maghrib", "Isha")
        val prayerTimes = listOf(
            prayerTimes.Fajr,
            prayerTimes.Dhuhr,
            prayerTimes.Asr,
            prayerTimes.Maghrib,
            prayerTimes.Isha
        )

        holder.bind(prayerNames[position], prayerTimes[position])
    }

    override fun getItemCount(): Int = 5
}
