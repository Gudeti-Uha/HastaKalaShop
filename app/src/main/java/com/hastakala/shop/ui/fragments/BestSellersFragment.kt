package com.hastakala.shop.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.hastakala.shop.databinding.FragmentBestSellersBinding
import com.hastakala.shop.viewmodel.SaleViewModel

class BestSellersFragment : Fragment() {

    private var _binding: FragmentBestSellersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SaleViewModel by activityViewModels()

    private val chartColors = listOf(
        Color.parseColor("#FF6B6B"), Color.parseColor("#4ECDC4"), Color.parseColor("#45B7D1"),
        Color.parseColor("#FFA07A"), Color.parseColor("#98D8C8"), Color.parseColor("#F7DC6F"),
        Color.parseColor("#BB8FCE"), Color.parseColor("#85C1E9"), Color.parseColor("#82E0AA"),
        Color.parseColor("#F0B27A")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBestSellersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPieChart()

        viewModel.bestSellers.observe(viewLifecycleOwner) { sellers ->
            if (sellers.isNullOrEmpty()) {
                binding.pieChart.visibility = View.GONE
                binding.tvNoData.visibility = View.VISIBLE
                binding.rvBestSellers.visibility = View.GONE
            } else {
                binding.pieChart.visibility = View.VISIBLE
                binding.tvNoData.visibility = View.GONE
                binding.rvBestSellers.visibility = View.VISIBLE
                updatePieChart(sellers.map { it.label to it.totalSold })
                updateList(sellers.map { it.label to it.totalSold })
            }
        }
    }

    private fun setupPieChart() {
        binding.pieChart.apply {
            description.isEnabled = false
            isDrawHoleEnabled = true
            holeRadius = 40f
            setHoleColor(Color.TRANSPARENT)
            setUsePercentValues(true)
            legend.isEnabled = true
            setEntryLabelColor(Color.WHITE)
            setEntryLabelTextSize(11f)
            setDrawEntryLabels(false)
        }
    }

    private fun updatePieChart(data: List<Pair<String, Int>>) {
        val entries = data.take(8).map { (label, count) ->
            PieEntry(count.toFloat(), label.take(18))
        }
        val dataSet = PieDataSet(entries, "").apply {
            colors = chartColors.take(entries.size)
            valueTextColor = Color.WHITE
            valueTextSize = 12f
            sliceSpace = 3f
        }
        val pieData = PieData(dataSet).apply {
            setValueFormatter(PercentFormatter(binding.pieChart))
        }
        binding.pieChart.data = pieData
        binding.pieChart.animateY(1000, Easing.EaseInOutQuad)
        binding.pieChart.invalidate()
    }

    private fun updateList(data: List<Pair<String, Int>>) {
        val sb = StringBuilder()
        data.forEachIndexed { index, (label, count) ->
            val medal = when (index) { 0 -> "🥇"; 1 -> "🥈"; 2 -> "🥉"; else -> "  ${index + 1}." }
            sb.appendLine("$medal  $label  —  $count sold")
        }
        binding.tvBestSellerList.text = sb.toString().trim()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
