// File KiemTraHelper.kt:
package vn.edu.ute.datdoan.helper

object KiemTraHelper {
    fun kiemTraHoTen(hoTen: String) = Regex("^[\\p{L}]+( [\\p{L}]+)+$").matches(hoTen)
    fun kiemTraSdt(sdt: String) = Regex("^0[78]\\d{8}$").matches(sdt)
    fun kiemTraDiaChi(diaChi: String) = diaChi.trim().length >= 5
}