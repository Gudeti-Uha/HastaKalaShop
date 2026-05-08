package com.hastakala.shop.data.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\bH\'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\bH\'J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\b2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\bH\'J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u001b"}, d2 = {"Lcom/hastakala/shop/data/database/SaleDao;", "", "deleteSale", "", "sale", "Lcom/hastakala/shop/model/Sale;", "(Lcom/hastakala/shop/model/Sale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSales", "Landroidx/lifecycle/LiveData;", "", "getAllSalesOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBestSellers", "Lcom/hastakala/shop/data/database/ProductColorStat;", "getSalesSince", "startTime", "", "getSalesSinceOnce", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStockStats", "Lcom/hastakala/shop/data/database/StockStat;", "getTotalRevenue", "", "getTotalRevenueSince", "getTotalSalesCount", "", "insertSale", "app_debug"})
@androidx.room.Dao()
public abstract interface SaleDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertSale(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteSale(@org.jetbrains.annotations.NotNull()
    com.hastakala.shop.model.Sale sale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM sales ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> getAllSales();
    
    @androidx.room.Query(value = "SELECT * FROM sales ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllSalesOnce(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.hastakala.shop.model.Sale>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM sales WHERE timestamp >= :startTime ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.model.Sale>> getSalesSince(long startTime);
    
    @androidx.room.Query(value = "SELECT * FROM sales WHERE timestamp >= :startTime ORDER BY timestamp DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSalesSinceOnce(long startTime, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.hastakala.shop.model.Sale>> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(pricePerUnit * quantity) FROM sales WHERE timestamp >= :startTime")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Double> getTotalRevenueSince(long startTime);
    
    @androidx.room.Query(value = "SELECT SUM(pricePerUnit * quantity) FROM sales")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Double> getTotalRevenue();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM sales")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> getTotalSalesCount();
    
    @androidx.room.Query(value = "\n        SELECT productName || \' (\' || color || \')\' as label,\n               SUM(quantity) as totalSold\n        FROM sales\n        GROUP BY productName, color\n        ORDER BY totalSold DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.hastakala.shop.data.database.ProductColorStat>> getBestSellers();
    
    @androidx.room.Query(value = "\n        SELECT productName, color, SUM(quantity) as totalSold\n        FROM sales\n        GROUP BY productName, color\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStockStats(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.hastakala.shop.data.database.StockStat>> $completion);
}