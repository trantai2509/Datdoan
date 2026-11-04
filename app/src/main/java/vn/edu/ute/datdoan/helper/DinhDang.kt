// File DinhDang.kt:
package vn.edu.ute.datdoan.helper
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun Long.dinhDangTien(): String {
    val sym = DecimalFormatSymbols(Locale.US).apply { groupingSeparator = '.' }
    return "${DecimalFormat("#,###", sym).format(this)} đ"
}