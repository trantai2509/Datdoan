package vn.edu.ute.datdoan.model

import java.io.Serializable

data class DonDatHang(
    val hoTen: String, val sdt: String, val diaChi: String,
    val maMonAn: String, val soLuong: Int, val khoangCach: Int,
    val ghiChu: String = "Khong hanh"
) : Serializable {
    fun tomTat(): String = "$hoTen - $maMonAn - SL: $soLuong - ${khoangCach}km"
}