package com.hastakala.shop.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.hastakala.shop.databinding.FragmentIncomeBinding
import com.hastakala.shop.model.Sale
import com.hastakala.shop.viewmodel.SaleViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class IncomeFragment : Fragment() {

    private var _binding: FragmentIncomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SaleViewModel by activityViewModels()
    private val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentIncomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBarChart()
        setupFilterButtons()
        observeData()
    }

    private fun setupFilterButtons() {
        binding.btnAll.setOnClickListener {
            viewModel.setFilter("all")
            updateButtonStates("all")
        }
        binding.btnWeek.setOnClickListener {
            viewModel.setFilter("week")
            updateButtonStates("week")
        }
        binding.btnMonth.setOnClickListener {
            viewModel.setFilter("month")
            updateButtonStates("month")
        }
        updateButtonStates("all")
    }

    private fun updateButtonStates(selected: String) {
        binding.btnAll.isSelected = selected == "all"
        binding.btnWeek.isSelected = selected == "week"
        binding.btnMonth.isSelected = selected == "month"
    }

    private fun observeData() {
        viewModel.filteredSales.observe(viewLifecycleOwner) { sales ->
            updateSalesList(sales)
            updateBarChart(sales)
        }

        viewModel.filteredRevenue.observe(viewLifecycleOwner) { revenue ->
            binding.tvFilteredRevenue.text = currencyFormat.format(revenue ?: 0.0)
        }
    }

    private fun updateSalesList(sales: List<Sale>) {
        binding.tvSalesCount.text = "${sales.size} transactions"
        val totalItems = sales.sumOf { it.quantity }
        binding.tvItemsSold.text = "$totalItems items sold"

        if (sales.isEmpty()) {
            binding.tvSalesLog.text = "No sales in this period yet.\nTap the + button to record a sale!"
            return
        }

        val sdf = SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault())
        val sb = StringBuilder()
        sales.take(50).forEach { sale ->
            sb.appendLine("📦 ${sale.productName} (${sale.color})")
            sb.appendLine("   Qty: ${sale.quantity}  ×  ${currencyFormat.format(sale.pricePerUnit)}  =  ${currencyFormat.format(sale.totalAmount)}")
            sb.appendLine("   🕐 ${sdf.format(Date(sale.timestamp))}")
            sb.appendLine()
        }
        binding.tvSalesLog.text = sb.toString().trim()
    }

    private fun setupBarChart() {
        binding.barChart.apply {
            description.isEnabled = false
            legend.isEnabled = false
            setDrawGridBackground(false)
            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                setDrawGridLines(false)
                granularity = 1f
            }
            axisLeft.setDrawGridLines(true)
            axisRight.isEnabled = false
            animateY(800)
        }
    }

    private fun updateBarChart(sales: List<Sale>) {
        if (sales.isEmpty()) {
            binding.barChart.clear()
            return
        }

        // Group by day of week
        val dayTotals = mutableMapOf<Int, Double>()
        val cal = Calendar.getInstance()
        sales.forEach { sale ->
            cal.timeInMillis = sale.timestamp
            val day = cal.get(Calendar.DAY_OF_WEEK)
            dayTotals[day] = (dayTotals[day] ?: 0.0) + sale.totalAmount
        }

        val days = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
        val entries = days.mapIndexed { index, _ ->
            BarEntry(index.toFloat(), (dayTotals[index + 1] ?: 0.0).toFloat())
        }

        val dataSet = BarDataSet(entries, "Revenue").apply {
            color = Color.parseColor("#FF6B35")
            valueTextColor = Color.DKGRAY
            valueTextSize = 10f
        }

        binding.barChart.xAxis.valueFormatter = IndexAxisValueFormatter(days)
        binding.barChart.data = BarData(dataSet)
        binding.barChart.invalidate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
