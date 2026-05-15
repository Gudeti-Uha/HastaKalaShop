# Hasta-Kala Shop 

A "Micro-Sales Analytics" Android app built for artisans who make small crafts like Banana Fiber Bags, Keychains, Wallets, and more. It helps them track sales, identify best-selling products, 
manage stock alerts, and view income reports — giving micro-entrepreneurs the same data power as big retailers.

---

## Problem Statement

Artisans making small crafts struggle with inventory management. They don't know which color or design is best-selling, so they keep making everything, leading to dead stock of items no one wants. 
"Hasta-Kala Shop" solves this by giving them simple billing and analytics tools.

---

## Features

- Quick Bill — Select a product, choose a color, enter quantity and price, and save the sale in seconds
- Best Sellers Dashboard — Pie chart showing which product-color combinations sell the most
- Income Log — View total revenue filtered by This Week, This Month, or All Time with a bar chart
- Stock Alerts — Automatic alerts when a product-color combo hits every 5th sale milestone
- Persistent Storage — All sales data stored locally using Room Database

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | XML Layouts, Material Components |
| Architecture | MVVM (ViewModel + LiveData) |
| Database | Room (SQLite) |
| Charts | MPAndroidChart (Pie & Bar charts) |
| Navigation | Android Navigation Component |
| Async | Kotlin Coroutines |
| Min SDK | API 24 (Android 7.0) |
| Target SDK | API 34 (Android 14) |

---

## Project Structure

```
HastaKalaShop/
├── app/
│   └── src/main/
│       ├── java/com/hastakala/shop/
│       │   ├── data/
│       │   │   ├── database/       # Room DB, DAO
│       │   │   └── repository/     # SaleRepository
│       │   ├── model/              # Sale, Product, SaleStats
│       │   ├── ui/
│       │   │   ├── activities/     # MainActivity, AddSaleActivity
│       │   │   └── fragments/      # Dashboard, BestSellers, Income, Stock
│       │   └── viewmodel/          # SaleViewModel
│       └── res/
│           ├── layout/             # XML UI layouts
│           ├── navigation/         # Nav graph
│           ├── values/             # Colors, strings, themes
│           └── drawable/           # Drawables
├── build.gradle
└── settings.gradle
```

---

## Installation & Setup

### Requirements
- Android Studio Hedgehog (2023.1.1) or later
- JDK 8 or higher
- Android SDK API 34
- Internet connection (for Gradle dependency download on first build)

### Steps to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/Gudeti-Uha/HastaKalaShop.git
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Click `File → Open`
   - Select the `HastaKalaShop` folder

3. **Sync Gradle**
   - Android Studio will auto-sync
   - Or manually: `File → Sync Project with Gradle Files`

4. **Run the app**
   - Connect an Android device (USB Debugging ON) or start an emulator
   - Click the green ▶ Run button or press `Shift + F10`

---

## App Usage

1. Tap the "＋ FAB button" to record a sale
2. Select a product from the grid (Banana Fiber Bag, Keychain, Wallet, etc.)
3. Choose a "color" from the dropdown
4. Enter "quantity" and "price per unit"
5. Tap "Save Sale"
6. View "Best Sellers" tab to see which items sell most (Pie Chart)
7. View "Income" tab to filter revenue by week/month
8. View "Stock" tab to see alerts for products needing restocking

---

## Screenshots

> Run the app on an emulator or device to see the full UI.

**Screens included:**
- Home Dashboard (today's revenue, all-time totals, top seller)
- Record a Sale (product grid, color selector, quantity/price)
- Best Sellers (Pie Chart + ranked list)
- Income Log (Bar Chart + sales log with filters)
- Stock Alerts (warning cards + horizontal bar chart)

---

## Dependencies

All dependencies are declared in `app/build.gradle`:

```gradle
// Room Database
androidx.room:room-runtime:2.6.1
androidx.room:room-ktx:2.6.1

// ViewModel + LiveData
androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0
androidx.lifecycle:lifecycle-livedata-ktx:2.7.0

// MPAndroidChart
com.github.PhilJay:MPAndroidChart:v3.1.0

// Navigation Component
androidx.navigation:navigation-fragment-ktx:2.7.6
```

---

## Future Improvements

- Add ability to set initial stock count per product
- Export sales data as CSV
- Add product images
- Cloud sync with Firebase
- Multi-language support (Kannada, Hindi)

---

## Student Details

- Name: "G Uha"
- USN: "1KG22CS039"
- Project Title No.: 14
- Project: "Android App Development using GenAI — Hasta-Kala Shop"
