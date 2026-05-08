package com.hastakala.shop.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fJ\u000e\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020(J\u000e\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0011\u00a8\u0006."}, d2 = {"Lcom/hastakala/shop/viewmodel/SaleViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_filterMode", "Landroidx/lifecycle/MutableLiveData;", "", "_insertSuccess", "", "_stockAlerts", "", "Lcom/hastakala/shop/data/database/StockStat;", "allSales", "Landroidx/lifecycle/LiveData;", "Lcom/hastakala/shop/model/Sale;", "getAllSales", "()Landroidx/lifecycle/LiveData;", "bestSellers", "Lcom/hastakala/shop/data/database/ProductColorStat;", "getBestSellers", "filterMode", "getFilterMode", "filteredRevenue", "", "getFilteredRevenue", "filteredSales", "getFilteredSales", "insertSuccess", "getInsertSuccess", "repository", "Lcom/hastakala/shop/data/repository/SaleRepository;", "stockAlerts", "getStockAlerts", "totalRevenue", "getTotalRevenue", "totalSalesCount", "", "getTotalSalesCount", "deleteSale", "", "sale", "insertSale", "refreshStockAlerts", "setFilter", "mode", "app_debug"})
public final class SaleViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.hastakala.shop.data.repository.SaleRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> allSales = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Double> totalRevenue = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> totalSalesCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.data.database.ProductColorStat>> bestSellers = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _filterMode = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> filterMode = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> filteredSales = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Double> filteredRevenue = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.hastakala.shop.data.database.StockStat>> _stockAlerts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.data.database.StockStat>> stockAlerts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _insertSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> insertSuccess = null;
    
    public SaleViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> getAllSales() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Double> getTotalRevenue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getTotalSalesCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.data.database.ProductColorStat>> getBestSellers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getFilterMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> getFilteredSales() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Double> getFilteredRevenue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.data.database.StockStat>> getStockAlerts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getInsertSuccess() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String mode) {
    }
    
    public final void insertSale(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.model.Sale sale) {
    }
    
    public final void deleteSale(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.model.Sale sale) {
    }
    
    public final void refreshStockAlerts() {
    }
}