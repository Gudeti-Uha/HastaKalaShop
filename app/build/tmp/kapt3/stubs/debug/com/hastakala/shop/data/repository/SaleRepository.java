package com.hastakala.shop.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00062\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0019R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\n\u00a8\u0006$"}, d2 = {"Lcom/hastakala/shop/data/repository/SaleRepository;", "", "database", "Lcom/hastakala/shop/data/database/AppDatabase;", "(Lcom/hastakala/shop/data/database/AppDatabase;)V", "allSales", "Landroidx/lifecycle/LiveData;", "", "Lcom/hastakala/shop/model/Sale;", "getAllSales", "()Landroidx/lifecycle/LiveData;", "bestSellers", "Lcom/hastakala/shop/data/database/ProductColorStat;", "getBestSellers", "saleDao", "Lcom/hastakala/shop/data/database/SaleDao;", "totalRevenue", "", "getTotalRevenue", "totalSalesCount", "", "getTotalSalesCount", "deleteSale", "", "sale", "(Lcom/hastakala/shop/model/Sale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSalesOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRevenueSince", "startTime", "", "getSalesThisMonth", "getSalesThisWeek", "getStockStats", "Lcom/hastakala/shop/data/database/StockStat;", "insertSale", "app_debug"})
public final class SaleRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.hastakala.shop.data.database.SaleDao saleDao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> allSales = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Double> totalRevenue = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> totalSalesCount = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.data.database.ProductColorStat>> bestSellers = null;
    
    public SaleRepository(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.data.database.AppDatabase database) {
        super();
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertSale(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteSale(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> getSalesThisWeek() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> getSalesThisMonth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Double> getRevenueSince(long startTime) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getStockStats(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.hastakala.shop.data.database.StockStat>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllSalesOnce(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.hastakala.shop.model.Sale>> $completion) {
        return null;
    }
}