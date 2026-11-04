// File DatMonHelper.kt:
package vn.edu.ute.datdoan.helper
import vn.edu.ute.datdoan.data.DuLieuMau
import vn.edu.ute.datdoan.model.DonDatHang
import vn.edu.ute.datdoan.model.MonAn

object DatMonHelper {
    fun timMonAn(ma: String): MonAn? =
        DuLieuMau.dsMonAn.find { it.ma.equals(ma.trim(), true) }

    fun hopLeSoLuong(mon: MonAn, soLuong: Int): Boolean =
        soLuong in 1..mon.soLuongToiDa

    fun tinhTienDon_23115053122139(mon: MonAn, soLuong: Int, khoangCach: Int): Long {
        if (khoangCach < 1 || !hopLeSoLuong(mon, soLuong)) return 0L
        // Đặt từ 5 phần trở lên giảm 10% tiền món ăn
        val tienmon = if (soLuong >= 5) (mon.donGia * soLuong * 90) / 100 else mon.donGia * soLuong
        // Phí ship: miễn phí 3km đầu, mỗi km vượt tính 5.000đ
        val kmvuot = if (khoangCach > 3) khoangCach - 3 else 0
        val phiship = kmvuot * 5000L
        return tienmon + phiship
    }

    fun taoMaDon(don: DonDatHang): String =
        "DA139-${don.maMonAn.trim().uppercase()}-${don.soLuong}"

    fun locTheoSoLuong(ds: List<MonAn>, soLuong: Int): List<MonAn> =
        ds.filter { it.soLuongToiDa >= soLuong }
            .sortedWith(compareBy<MonAn> { it.donGia }.thenByDescending { it.soLuongToiDa })
}