package com.hastakala.shop.ui.activities;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/hastakala/shop/ui/activities/AddSaleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/hastakala/shop/databinding/ActivityAddSaleBinding;", "selectedColor", "", "selectedProduct", "Lcom/hastakala/shop/model/Product;", "viewModel", "Lcom/hastakala/shop/viewmodel/SaleViewModel;", "getViewModel", "()Lcom/hastakala/shop/viewmodel/SaleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "saveSale", "selectProduct", "product", "setupObservers", "setupProductGrid", "app_debug"})
public final class AddSaleActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.hastakala.shop.databinding.ActivityAddSaleBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.hastakala.shop.model.Product selectedProduct;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedColor;
    
    public AddSaleActivity() {
        super();
    }
    
    private final com.hastakala.shop.viewmodel.SaleViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupProductGrid() {
    }
    
    private final void selectProduct(com.hastakala.shop.model.Product product) {
    }
    
    private final void saveSale() {
    }
    
    private final void setupObservers() {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}