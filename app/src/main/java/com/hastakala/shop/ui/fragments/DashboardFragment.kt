package com.hastakala.shop.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.hastakala.shop.databinding.FragmentDashboardBinding
import com.hastakala.shop.viewmodel.SaleViewModel
import java.text.NumberFormat
import java.util.Locale

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SaleViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currencyFormat = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

        viewModel.totalRevenue.observe(viewLifecycleOwner) { revenue ->
            binding.tvTotalRevenue.text = currencyFormat.format(revenue ?: 0.0)
        }

        viewModel.totalSalesCount.observe(viewLifecycleOwner) { count ->
            binding.tvTotalSales.text = "$count"
        }

        viewModel.allSales.observe(viewLifecycleOwner) { sales ->
            val today = sales.filter {
                val cal = java.util.Calendar.getInstance()
                val saleCal = java.util.Calendar.getInstance()
                saleCal.timeInMillis = it.timestamp
                cal.get(java.util.Calendar.DAY_OF_YEAR) == saleCal.get(java.util.Calendar.DAY_OF_YEAR) &&
                        cal.get(java.util.Calendar.YEAR) == saleCal.get(java.util.Calendar.YEAR)
            }
            val todayRevenue = today.sumOf { it.totalAmount }
            binding.tvTodayRevenue.text = currencyFormat.format(todayRevenue)
            binding.tvTodaySales.text = "${today.size}"
        }

        viewModel.bestSellers.observe(viewLifecycleOwner) { sellers ->
            if (sellers.isNotEmpty()) {
                val top = sellers.first()
                binding.tvTopProduct.text = top.label
                binding.tvTopCount.text = "${top.totalSold} sold"
            } else {
                binding.tvTopProduct.text = "No sales yet"
                binding.tvTopCount.text = ""
            }
        }

        viewModel.refreshStockAlerts()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
