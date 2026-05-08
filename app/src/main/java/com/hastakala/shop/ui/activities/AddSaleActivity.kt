package com.hastakala.shop.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hastakala.shop.databinding.ActivityAddSaleBinding
import com.hastakala.shop.model.Product
import com.hastakala.shop.model.ProductCatalog
import com.hastakala.shop.model.Sale
import com.hastakala.shop.viewmodel.SaleViewModel

class AddSaleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddSaleBinding
    private val viewModel: SaleViewModel by viewModels()
    private var selectedProduct: Product? = null
    private var selectedColor: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSaleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Record a Sale"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupProductGrid()
        setupObservers()

        binding.btnSaveSale.setOnClickListener { saveSale() }
    }

    private fun setupProductGrid() {
        val products = ProductCatalog.products
        val buttons = listOf(
            binding.btnProduct1, binding.btnProduct2, binding.btnProduct3, binding.btnProduct4,
            binding.btnProduct5, binding.btnProduct6, binding.btnProduct7, binding.btnProduct8
        )

        buttons.forEachIndexed { index, btn ->
            if (index < products.size) {
                val product = products[index]
                btn.text = "${product.emoji}\n${product.name}"
                btn.visibility = View.VISIBLE
                btn.setOnClickListener {
                    selectProduct(product)
                    buttons.forEach { b -> b.isSelected = false }
                    btn.isSelected = true
                }
            } else {
                btn.visibility = View.GONE
            }
        }
    }

    private fun selectProduct(product: Product) {
        selectedProduct = product
        selectedColor = null
        binding.colorSection.visibility = View.VISIBLE
        binding.tvSelectedProduct.text = "Selected: ${product.emoji} ${product.name}"

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, product.availableColors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerColor.adapter = adapter
    }

    private fun saveSale() {
        val product = selectedProduct
        if (product == null) {
            Toast.makeText(this, "⚠️ Please select a product!", Toast.LENGTH_SHORT).show()
            return
        }

        val color = binding.spinnerColor.selectedItem?.toString()
        if (color == null) {
            Toast.makeText(this, "⚠️ Please select a color!", Toast.LENGTH_SHORT).show()
            return
        }

        val quantityText = binding.etQuantity.text.toString()
        val quantity = quantityText.toIntOrNull()
        if (quantity == null || quantity <= 0) {
            binding.etQuantity.error = "Enter valid quantity"
            return
        }

        val priceText = binding.etPrice.text.toString()
        val price = priceText.toDoubleOrNull()
        if (price == null || price <= 0) {
            binding.etPrice.error = "Enter valid price"
            return
        }

        val sale = Sale(
            productName = product.name,
            color = color,
            quantity = quantity,
            pricePerUnit = price
        )

        viewModel.insertSale(sale)
    }

    private fun setupObservers() {
        viewModel.insertSuccess.observe(this) { success ->
            if (success == true) {
                Toast.makeText(this, "✅ Sale recorded successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
