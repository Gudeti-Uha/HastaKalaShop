package com.hastakala.shop.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hastakala.shop.databinding.FragmentStockBinding
import com.hastakala.shop.viewmodel.SaleViewModel

class StockFragment : Fragment() {

    private var _binding: FragmentStockBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SaleViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStockBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refreshStockAlerts()

        viewModel.allSales.observe(viewLifecycleOwner) {
            viewModel.refreshStockAlerts()
        }

        viewModel.stockAlerts.observe(viewLifecycleOwner) { alerts ->
            if (alerts.isNullOrEmpty()) {
                binding.tvAlertsTitle.text = "✅ No stock alerts right now"
                binding.tvAlerts.text = "Keep selling! Alerts will appear\nwhen you hit every 5th sale\nof a product."
            } else {
                binding.tvAlertsTitle.text = "⚠️ Stock Alerts (${alerts.size})"
                val sb = StringBuilder()
                alerts.forEach { stat ->
                    sb.appendLine("🔔  ${stat.productName}  (${stat.color})")
                    sb.appendLine("   ${stat.totalSold} sold — time to make more!")
                    sb.appendLine()
                }
                binding.tvAlerts.text = sb.toString().trim()
            }
        }

        viewModel.bestSellers.observe(viewLifecycleOwner) { sellers ->
            if (sellers.isNullOrEmpty()) {
                binding.tvStockSummary.text = "No sales data yet.\nStart recording sales to see insights."
                return@observe
            }
            val sb = StringBuilder()
            sb.appendLine("📊 All-time Sales by Product & Color")
            sb.appendLine("─────────────────────────────────")
            sellers.forEach { stat ->
                val bar = "█".repeat(minOf(stat.totalSold, 20))
                sb.appendLine("${stat.label}")
                sb.appendLine("  $bar ${stat.totalSold} sold")
            }
            binding.tvStockSummary.text = sb.toString().trim()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
